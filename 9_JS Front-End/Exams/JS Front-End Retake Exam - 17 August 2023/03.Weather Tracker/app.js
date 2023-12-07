const BASE_URL = 'http://localhost:3030/jsonstore/tasks';

const endpoints = {
    update: (id) => `${BASE_URL}/${id}`,
    delete: (id) => `${BASE_URL}/${id}`,
};

const locationInput = document.getElementById("location");
const dateInput = document.getElementById("date");
const temperatureInput = document.getElementById("temperature");

const list = document.getElementById('list');

const addBtn = document.getElementById("add-weather");
const editBtn = document.getElementById("edit-weather");
const loadBtn = document.getElementById("load-history");

let selectedTaskId = null;

function attachEvents() {
    loadBtn.addEventListener('click', loadBoardEventHandler);
    addBtn.addEventListener('click', createTaskEventHandler);
    editBtn.addEventListener('click', editTaskEventHandler);
}

function getIdByLocation(task) {
    return fetch(BASE_URL)
        .then(res => res.json())
        .then(res => Object.entries(res).find(e => e[1].location == task)[1]._id);
}

async function loadBoardEventHandler() {
    clearAllSections();
    try {
        const res = await fetch(BASE_URL);
        const allTasks = await res.json();
        Object.values(allTasks).forEach((task) => {
            const container = document.createElement('div');
            container.className = 'container';

            const locationElement = document.createElement('h2');
            locationElement.textContent = task.location;

            const dateElement = document.createElement('h3');
            dateElement.textContent = task.date;

            const temperatureElement = document.createElement('h3');
            temperatureElement.textContent = task.temperature;
            temperatureElement.setAttribute('id', 'celsius')

            const buttonsContainer = document.createElement('div'); // Create the new div for buttons
            buttonsContainer.className = 'buttons-container';

            const changeBtn = document.createElement('button');
            changeBtn.className = 'change-btn';
            changeBtn.textContent = 'Change';

            const doneBtn = document.createElement('button');
            doneBtn.className = 'delete-btn';
            doneBtn.textContent = 'Done';

            buttonsContainer.appendChild(changeBtn); // Append buttons to the new div
            buttonsContainer.appendChild(doneBtn);

            container.appendChild(locationElement);
            container.appendChild(dateElement);
            container.appendChild(temperatureElement);
            container.appendChild(buttonsContainer); // Append the new div to the container

            list.appendChild(container);
        });
        attachEventListeners();
    } catch (err) {
        console.error(err);
    }
}

function attachEventListeners() {
    const changeButtons = document.querySelectorAll('.change-btn');
    const doneButtons = document.querySelectorAll('.delete-btn');

    changeButtons.forEach((changeButton) => {
        changeButton.addEventListener('click', (event) => {
            const taskElement = event.target.closest('.container');

            const location = taskElement.querySelector('h2').textContent;
            const date = taskElement.querySelector('h3:nth-child(2)').textContent;
            const temperature = taskElement.querySelector('h3:nth-child(3)').textContent;
            editTask(location, date, temperature);
            enableEditBtn();
        });
    });


    doneButtons.forEach((doneButton) => {
        doneButton.addEventListener('click', (event) => {
            const taskElement = event.target.closest('.container');
            const location = taskElement.querySelector('h2').textContent;
            deleteTask(location);
        });
    });

}

async function editTask(taskLocation, taskDate, taskTemperature) {
    selectedTaskId = await getIdByLocation(taskLocation);
    locationInput.value = taskLocation;
    dateInput.value = taskDate;
    temperatureInput.value = taskTemperature;
}


function createTaskEventHandler(ev) {
    ev.preventDefault();
    if (locationInput.value !== '' && temperatureInput.value !== '' && dateInput.value !== '') {
        const headers = {
            method: 'POST',
            body: JSON.stringify({
                location: locationInput.value,
                temperature: temperatureInput.value,
                date: dateInput.value,
            }),
        };

        fetch(BASE_URL, headers)
            .then(loadBoardEventHandler)
            .catch(console.error);

        clearAllInputs();
    }
}

function editTaskEventHandler(ev) {
    ev.preventDefault();

    const data = {
        location: locationInput.value,
        temperature: temperatureInput.value,
        date: dateInput.value,
        _id: selectedTaskId,
    };

    fetch(endpoints.update(data._id), {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
    })
        .then(() => {
            clearAllInputs();
            loadBoardEventHandler();
            selectedTaskId = null;
            enableAddBtn();
        })
        .catch(console.error);
}

function deleteTask(taskLoacation) {
    getIdByLocation(taskLoacation)
        .then((id) =>
            fetch(endpoints.delete(id), {
                method: 'DELETE',
                headers: { 'Content-Type': 'application/json' },
            })
        )
        .then(() => {
            clearAllSections();
            loadBoardEventHandler();
            selectedTaskId = null;
            enableAddBtn();
        })
        .catch(console.error);
}


function enableEditBtn() {
    addBtn.disabled = true;
    editBtn.disabled = false;
}

function enableAddBtn() {
    addBtn.disabled = false;
    editBtn.disabled = true;
}
function clearAllSections() {
    list.innerHTML = '';
}

function clearAllInputs() {
    locationInput.value = '';
    temperatureInput.value = '';
    dateInput.value = '';
}

attachEvents();
