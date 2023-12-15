const BASE_URL = 'http://localhost:3030/jsonstore/tasks';

const endpoints = {
    update: (id) => `${BASE_URL}/${id}`,
    delete: (id) => `${BASE_URL}/${id}`
};

const addButton = document.querySelector("#add-button");
const loadButton = document.getElementById('load-button');

const taskList = document.querySelector("#todo-list");

const inputName = document.querySelector("#title");

function attachEvents() {
    loadButton.addEventListener('click', loadTasksHandler);
    addButton.addEventListener('click', addTodo);
}

async function loadTasksHandler(event) {
    if (event) {
        event.preventDefault();
    }

    clearList();

    try {
        let res = await fetch(BASE_URL);
        let data = await res.json();

        let list = Object.entries(data);

        for (const [key, element] of list) {
            const li = document.createElement('li');

            const span = document.createElement('span');
            span.textContent = element.name;
            li.appendChild(span);

            const removeBtn = document.createElement('button');
            removeBtn.innerText = 'Remove';
            removeBtn.id = element._id;
            removeBtn.addEventListener('click', removeTaskHandler);
            li.appendChild(removeBtn);

            const editBtn = document.createElement('button');
            editBtn.innerText = 'Edit';
            editBtn.id = element._id;
            editBtn.addEventListener('click', createEditInput);
            li.appendChild(editBtn);

            taskList.appendChild(li);
        }

    } catch (error) {
        console.error('Error:', error);
        throw error
    }
}

async function addTodo(event) {
    event.preventDefault();

    const name = inputName.value;

    if (typeof name !== "string" || name === '') {
      return;
    }

    await fetch(BASE_URL, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            name: name,
        })
    });

    clearFields();
    await loadTasksHandler(event);
}

function createEditInput(event) {
    event.preventDefault();
    const liItem = event.target.parentElement;

    //replace SPAN with INPUT
    let span = liItem.querySelector('span');
    let input = document.createElement('input');
    input.type = 'text';
    input.value = span.textContent;
    liItem.replaceChild(input, span);

    // Rename "Edit" to "Submit", remove the old event listener and add a new one
    let editButton = liItem.querySelector('button:last-of-type');
    editButton.innerText = 'Submit';
    editButton.removeEventListener('click', createEditInput);
    editButton.addEventListener('click', editTaskHandler)
}


async function editTaskHandler(event) {
    const name = event.target.parentElement.querySelector('input').value;

    await fetch(endpoints.update(event.target.id), {
        method: 'PATCH',
        body: JSON.stringify({
            name: name
        })
    });

    await loadTasksHandler();
}

async function removeTaskHandler(event) {
    const id = event.target.id;

    await fetch(endpoints.delete(id), {
        method: 'DELETE'
    });

    await loadTasksHandler();
}
function clearList() {
    taskList.innerHTML = '';
}

function clearFields() {
    inputName.value = '';
}

attachEvents();
