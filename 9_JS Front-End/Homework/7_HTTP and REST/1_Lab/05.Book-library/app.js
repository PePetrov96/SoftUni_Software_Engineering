function attachEvents() {
    document.querySelector('table').addEventListener('click', function(event) {
        let button = event.target.closest('button');
        if (!button) return;

        if (button.innerText === 'Edit') {
            prepareEditForm(button);
        } else if (button.innerText === 'Delete') {
            deleteBook(button);
        }
    });


    // Separate event listener for the Submit button in the form
    document.getElementById('form').addEventListener('click', function(event) {
        let button = event.target.closest('button');
        if (!button) return;

        if (button.innerText === 'Submit') {
            createBook();
        }
    });

    // Event listener for the Load All Books button
    document.getElementById('loadBooks').addEventListener('click', loadBooks);

    function loadBooks() {
        fetch('http://localhost:3030/jsonstore/collections/books')
            .then(res => res.json())
            .then(books => {
                let bookRows = document.querySelectorAll('table tbody tr');
                let bookArray = Object.values(books);

                for (let i = 0; i < bookRows.length; i++) {
                    bookRows[i].querySelector('td:nth-of-type(1)').textContent = bookArray[i].title;
                    bookRows[i].querySelector('td:nth-of-type(2)').textContent = bookArray[i].author;
                }
            })
            .catch(error => console.error('Error:', error));
    }
    function createBook() {
        // Get the title and author from the input fields
        const title = document.querySelector('input[name="title"]').value;
        const author = document.querySelector('input[name="author"]').value;

        if (title.length === 0 || author.length === 0) {
            return;
        }

        // Construct the book data
        const bookData = {title, author};

        // POST the new book data to the server
        fetch('http://localhost:3030/jsonstore/collections/books', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(bookData)
        })
            .then(res => res.json())
            .then(createdBook => {
                // Append the new book to the table without clearing existing rows
                appendBookToTable(createdBook);

                // Clear the input fields
                document.querySelector('input[name="title"]').value = '';
                document.querySelector('input[name="author"]').value = '';
            })
            .catch(error => console.error('Error:', error));
    }
    function appendBookToTable(book) {
        const tableBody = document.querySelector('table tbody');
        const newRowHtml = `
        <tr>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>
                <button>Edit</button>
                <button>Delete</button>
            </td>
        </tr>`;

        tableBody.innerHTML += newRowHtml;

    }
    function deleteBook(button) {
        let row = button.closest('tr');
        let title = row.querySelector('td:nth-of-type(1)').textContent;
        let author = row.querySelector('td:nth-of-type(2)').textContent;

        if (isNaN(findBookID(title, author))) {
            createBook();
        }

        findBookID(title, author)
            .then(bookId => {
                if (!bookId) {
                    // If book ID is not found, just remove the row
                    row.parentElement.removeChild(row);
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
                // Remove the row from the table
                row.remove();
            })
            .catch(error => console.error('Error:', error));
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
        submitButton.onclick = () => saveEditedBook(row, submitButton);
    }
    function saveEditedBook(row, submitButton) {
        const titleInput = document.querySelector('input[name="title"]');
        const authorInput = document.querySelector('input[name="author"]');

        const title = titleInput.value;
        const author = authorInput.value;

        findBookID(row.querySelector('td:nth-of-type(1)').textContent, row.querySelector('td:nth-of-type(2)').textContent)
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

                // Clear the input fields and reset form
                titleInput.value = '';
                authorInput.value = '';
                document.querySelector('#form h3').textContent = 'FORM';
                submitButton.textContent = 'Submit';
                submitButton.onclick = createBook;
            })
            .catch(error => console.error('Error:', error));
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
                return NaN;
            });
    }
}

attachEvents();