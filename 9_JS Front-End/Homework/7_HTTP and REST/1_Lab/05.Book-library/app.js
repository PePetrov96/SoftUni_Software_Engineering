function attachEvents() {
    document.querySelector('table').addEventListener('click', handleTableClick);
    document.getElementById('form').addEventListener('click', handleFormClick);
    document.getElementById('loadBooks').addEventListener('click', loadBooks);
}

function handleTableClick(event) {
    let button = event.target.closest('button');
    if (!button) return;

    if (button.innerText === 'Edit') {
        prepareEditForm(button);
    } else if (button.innerText === 'Delete') {
        deleteBook(button).catch(console.error);
    }
}

function handleFormClick(event) {
    let button = event.target.closest('button');
    if (!button) return;

    if (button.innerText === 'Submit') {
        createBook().catch(console.error);
    }
}

function loadBooks() {
    return fetch('http://localhost:3030/jsonstore/collections/books')
        .then(res => res.json())
        .then(updateBookTable)
        .catch(error => {
            console.error('Error loading books:', error);
            throw error;
        });
}

function updateBookTable(books) {
    const tableBody = document.querySelector('table tbody');
    tableBody.innerHTML = Object.values(books).map(book => createBookRow(book)).join('');
}

function createBookRow(book) {
    return `
        <tr>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>
                <button>Edit</button>
                <button>Delete</button>
            </td>
        </tr>`;
}

function createBook() {
    const title = document.querySelector('input[name="title"]').value;
    const author = document.querySelector('input[name="author"]').value;

    if (title.length === 0 || author.length === 0) {
        return Promise.resolve(); // Return a resolved promise for empty inputs
    }

    const bookData = {title, author};

    return fetch('http://localhost:3030/jsonstore/collections/books', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(bookData)
    })
        .then(res => res.json())
        .then(createdBook => {
            loadBooks(); // Reload all books
            document.querySelector('input[name="title"]').value = '';
            document.querySelector('input[name="author"]').value = '';
        })
        .catch(error => {
            console.error('Error creating book:', error);
            throw error;
        });
}

function prepareEditForm(button) {
    let row = button.closest('tr');
    let title = row.querySelector('td:nth-of-type(1)').textContent;
    let author = row.querySelector('td:nth-of-type(2)').textContent;

    document.querySelector('input[name="title"]').value = title;
    document.querySelector('input[name="author"]').value = author;

    document.querySelector('#form h3').textContent = 'Edit FORM';
    const submitButton = document.querySelector('#form button');
    submitButton.textContent = 'Save';
    submitButton.onclick = () => saveEditedBook(row, submitButton).catch(console.error);
}

function saveEditedBook(row, submitButton) {
    const titleInput = document.querySelector('input[name="title"]');
    const authorInput = document.querySelector('input[name="author"]');
    const title = titleInput.value;
    const author = authorInput.value;

    return findBookID(row.querySelector('td:nth-of-type(1)').textContent, row.querySelector('td:nth-of-type(2)').textContent)
        .then(bookId => {
            let fetchUrl = 'http://localhost:3030/jsonstore/collections/books';
            let method = 'POST';

            if (bookId) {
                fetchUrl += `/${bookId}`;
                method = 'PUT';
            }

            return fetch(fetchUrl, {
                method: method,
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ title, author })
            });
        })
        .then(response => response.json())
        .then(updatedBook => {
            row.querySelector('td:nth-of-type(1)').textContent = updatedBook.title;
            row.querySelector('td:nth-of-type(2)').textContent = updatedBook.author;

            titleInput.value = '';
            authorInput.value = '';
            document.querySelector('#form h3').textContent = 'FORM';
            submitButton.textContent = 'Submit';
            submitButton.onclick = createBook;
        })
        .catch(error => {
            console.error('Error saving edited book:', error);
            throw error;
        });
}

function deleteBook(button) {
    let row = button.closest('tr');
    let title = row.querySelector('td:nth-of-type(1)').textContent;
    let author = row.querySelector('td:nth-of-type(2)').textContent;

    return findBookID(title, author)
        .then(bookId => {
            if (!bookId) {
                row.remove();
                return;
            }
            return fetch(`http://localhost:3030/jsonstore/collections/books/${bookId}`, {
                method: 'DELETE'
            });
        })
        .then(response => {
            if (response && !response.ok) {
                throw new Error('Failed to delete the book');
            }
            row.remove();
        })
        .catch(error => {
            console.error('Error deleting book:', error);
            throw error;
        });
}

function findBookID(title, author) {
    return fetch('http://localhost:3030/jsonstore/collections/books')
        .then(response => response.json())
        .then(books => {
            for (let id in books) {
                let book = books[id];
                if (book.title === title && book.author === author) {
                    return id;
                }
            }
            return null;
        })
        .catch(error => {
            console.error('Error finding book ID:', error);
            throw error;
        });
}

attachEvents();
