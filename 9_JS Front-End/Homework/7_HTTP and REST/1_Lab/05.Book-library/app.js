const BASE_URL = 'http://localhost:3030/jsonstore/collections/books';

const endpoints = {
    books: () => `${BASE_URL}`,
    book: (id) => `${BASE_URL}/${id}`,
};

const authorInput = document.querySelector('input[name="author"]');
const titleInput = document.querySelector('input[name="title"]');
const formTitle = document.querySelector('#form h3');
const booksTable = document.querySelector('table tbody');

function attachEvents() {
    document.getElementById('loadBooks').addEventListener('click', loadBooks);
    document.getElementById('submitButton').addEventListener('click', handleFormSubmit);
    booksTable.addEventListener('click', handleTableClick);
}

function handleFormSubmit(event) {
    event.preventDefault();
    const action = formTitle.textContent.includes('Edit') ? saveEditedBook : createBook;
    action().catch(console.error);
}

function handleTableClick(event) {
    const button = event.target.closest('button');
    if (!button) return;

    const row = button.closest('tr');
    if (button.textContent === 'Edit') {
        prepareEditForm(row);
    } else if (button.textContent === 'Delete') {
        deleteBook(row).catch(console.error);
    }
}

async function loadBooks() {
    try {
        const response = await fetch(endpoints.books());
        const data = await response.json();
        booksTable.innerHTML = Object.values(data).map(createBookRow).join('');
    } catch (error) {
        console.error('Error loading books:', error);
    }
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

async function createBook() {
    const title = titleInput.value.trim();
    const author = authorInput.value.trim();
    if (!title || !author) return;

    try {
        await fetch(endpoints.books(), {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify({ title, author })
        });
        await loadBooks();
        resetForm();
    } catch (error) {
        console.error('Error creating book:', error);
    }
}

function prepareEditForm(row) {
    titleInput.value = row.cells[0].textContent;
    authorInput.value = row.cells[1].textContent;
    formTitle.textContent = 'Edit FORM';
    document.getElementById('submitButton').textContent = 'Save';
    row.classList.add('editing');
}

async function saveEditedBook() {
    const row = document.querySelector('tr.editing');
    if (!row) return;

    const title = titleInput.value.trim();
    const author = authorInput.value.trim();
    const bookId = await findBookID(row.cells[0].textContent, row.cells[1].textContent);

    if (!title || !author || !bookId) return;

    try {
        await fetch(endpoints.book(bookId), {
            method: 'PUT',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify({ title, author })
        });
        row.cells[0].textContent = title;
        row.cells[1].textContent = author;
        resetForm();
    } catch (error) {
        console.error('Error updating book:', error);
    } finally {
        row.classList.remove('editing');
    }
}

async function deleteBook(row) {
    const bookId = await findBookID(row.cells[0].textContent, row.cells[1].textContent);
    if (!bookId) {
        row.remove();
        return;
    }

    try {
        await fetch(endpoints.book(bookId), {
            method: 'DELETE'
        });
        row.remove();
    } catch (error) {
        console.error('Error deleting book:', error);
    }
}

async function findBookID(title, author) {
    try {
        const response = await fetch(endpoints.books());
        const books = await response.json();
        for (let id in books) {
            if (books[id].title === title && books[id].author === author) {
                return id;
            }
        }
        return null;
    } catch (error) {
        console.error('Error finding book ID:', error);
        throw error;
    }
}

function resetForm() {
    titleInput.value = '';
    authorInput.value = '';
    formTitle.textContent = 'FORM';
    document.getElementById('submitButton').textContent = 'Submit';
}

attachEvents();
