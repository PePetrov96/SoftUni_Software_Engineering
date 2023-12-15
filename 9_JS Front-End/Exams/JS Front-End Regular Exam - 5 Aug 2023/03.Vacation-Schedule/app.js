const BASE_URL = 'http://localhost:3030/jsonstore/tasks';

const endpoints = {
    update: (id) => `${BASE_URL}/${id}`,
    delete: (id) => `${BASE_URL}/${id}`
};

const loadVacationsBtn = document.getElementById('load-vacations');
const addVacationBtn = document.getElementById('add-vacation');
const editVacationBtn = document.getElementById('edit-vacation');

const vacationsList = document.getElementById('list');

const nameInput = document.getElementById('name');
const numDaysInput = document.getElementById('num-days');
const dateInput = document.getElementById('from-date');

let currentTaskId = '';

function attachEvents() {
    loadVacationsBtn.addEventListener('click', loadBoardEventHandler);
    addVacationBtn.addEventListener('click', addVacationEventHandler);

    editVacationBtn.addEventListener('click', async (e) => {
        e.preventDefault();
        if (!currentTaskId) return;

        const data = {
            name: nameInput.value,
            days: numDaysInput.value,
            date: dateInput.value
        };

        await fetch(endpoints.update(currentTaskId), {
            method: 'PATCH',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data)
        });

        clearFields();
        loadBoardEventHandler();
        enableAddBtn();
    });
}

async function loadBoardEventHandler() {
    clearList();

    try {
        const res = await fetch(BASE_URL);
        const allTasks = await res.json();

        let tasks = Object.values(allTasks);

        for (const task of tasks) {
            const taskElement = document.createElement('div');
            taskElement.className = 'container';
            taskElement.innerHTML = `
                <h2>${task.name}</h2>
                <h3>${task.date}</h3>
                <h3>${task.days}</h3>
                <button class="change-btn">Change</button>
                <button class="done-btn">Done</button>`;

            taskElement
                .querySelector('.change-btn')
                .addEventListener('click', (ev) => updateCourse(ev, task._id));

            taskElement
                .querySelector('.done-btn')
                .addEventListener('click', (ev) => deleteCourse(ev, task._id));

            vacationsList.appendChild(taskElement);
        }
    } catch (err) {
        console.error(err);
    }
}

async function updateCourse(ev, taskId) {
    ev.preventDefault();
    enableEditBtn();
    const task = ev.target.parentElement;
    const [name, date, days] = Array.from(task.children);
    nameInput.value = name.textContent;
    dateInput.value = date.textContent;
    numDaysInput.value = days.textContent;

    currentTaskId = taskId;
}

async function addVacationEventHandler() {
    let name = nameInput.value;
    let date = dateInput.value;
    let days = numDaysInput.value;

    if (name === '' || date === '' || days === '') {
        return;
    }

    await fetch(BASE_URL, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            name: name,
            date: date,
            days: days
        })
    });

    clearFields();
    await loadBoardEventHandler();
}

async function deleteCourse(ev, taskId) {
    ev.preventDefault();

    await fetch(endpoints.delete(taskId), {
        method: 'DELETE'
    });

    loadBoardEventHandler();
}

function clearList() {
    vacationsList.innerHTML = '';
}

function clearFields() {
    nameInput.value = '';
    numDaysInput.value = '';
    dateInput.value = '';
}

function enableAddBtn() {
    addVacationBtn.disabled = false;
    editVacationBtn.disabled = true;
}

function enableEditBtn() {
    addVacationBtn.disabled = true;
    editVacationBtn.disabled = false;
}

attachEvents();
