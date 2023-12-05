const BASE_URL = 'http://localhost:3030/jsonstore/phonebook';

const phonebookList = document.getElementById('phonebook');
const loadBtn = document.getElementById('btnLoad');
const createBtn = document.getElementById('btnCreate');
const nameInput = document.getElementById('person');
const phoneInput = document.getElementById('phone');

function attachEvents() {
    loadBtn.addEventListener('click', loadContacts);
    createBtn.addEventListener('click', createContact);
}

function loadContacts() {
    phonebookList.innerHTML = '';

    fetch(BASE_URL)
        .then(res => res.json())
        .then((data) => {
            Object.entries(data).forEach(([key, contact]) => {
                let li = document.createElement('li');
                li.textContent = `${contact.person}: ${contact.phone}`;

                let button = document.createElement('button');
                button.textContent = 'Delete';
                button.addEventListener('click', () => deleteTask(contact.person));

                li.appendChild(button);
                phonebookList.appendChild(li);
            });
        })
        .catch((error) => {
            console.error("Error: ", error);
        });
}

function createContact() {
    const contactName = nameInput.value;
    const contactPhone = phoneInput.value;

    const contact = { person: contactName, phone: contactPhone };

    fetch(BASE_URL, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(contact)
    })
        .then(() => {
            loadContacts(); // Reload contacts after successful creation
        })
        .catch((error) => {
            console.error('Error: ', error);
        });
}

function getIdByLocation(task) {
    return fetch(BASE_URL)
        .then(res => res.json())
        .then(res => Object.entries(res).find(e => e[1].person === task)[1]._id);
}

function deleteTask(taskLocation) {
    getIdByLocation(taskLocation)
        .then((id) =>
            fetch(`${BASE_URL}/${id}`, {
                method: 'DELETE',
                headers: { 'Content-Type': 'application/json' },
            })
        )
        .catch(console.error);
}

attachEvents();

