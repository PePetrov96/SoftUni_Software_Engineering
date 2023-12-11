const BASE_URL = 'http://localhost:3030/jsonstore/tasks';

const endpoints = {
    update: (id) => `${BASE_URL}/${id}`,
    delete: (id) => `${BASE_URL}/${id}`
}

let currentTaskId = '';

const locationInput = document.getElementById('location');
const dateInput = document.getElementById('date');
const temperatureInput = document.getElementById('temperature');

const loadHistoryBtn = document.getElementById('load-history');
const addWeatherBtn = document.getElementById('add-weather');
const editWeatherBtn = document.getElementById('edit-weather');

const weatherList = document.getElementById('list');

function attachEventListeners() {
    loadHistoryBtn.addEventListener('click', loadHistoryEventHandler);
    addWeatherBtn.addEventListener('click', addWeatherEventHandler);
    editWeatherBtn.addEventListener('click', editWeatherEventHandler);
}

async function editWeatherEventHandler() {
    if (currentTaskId === '') return;

    const data = {
        location: locationInput.value,
        temperature: temperatureInput.value,
        date: dateInput.value
    }

    await fetch(endpoints.update(currentTaskId), {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data)
    });

    clearFields();
    await loadHistoryEventHandler();
    enableAddBtn();
}

async function addWeatherEventHandler() {
    let location = locationInput.value;
    let date = dateInput.value;
    let temperature = temperatureInput.value;

    if (location === '' || date === '' || temperature === '') {
        return;
    }

    await fetch(BASE_URL, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            location: location,
            temperature: temperature,
            date: date
        })
    });

    clearFields();
    await loadHistoryEventHandler();
}

async function loadHistoryEventHandler() {
    clearList();

    try {
        let res = await fetch(BASE_URL);
        let data = await res.json();

        let entries = Object.entries(data);

        for (const [key, entry] of entries) {
            let container = document.createElement('div');
            container.className = 'container';

            container.innerHTML += `
                                        <h2>${entry.location}</h2>
                                        <h3>${entry.date}</h3>
                                        <h3 id="celsius">${entry.temperature}</h3>
                                        <div id="buttons-container">  
                                            <button class="change-btn">Change</button>
                                            <button class="delete-btn">Delete</button>
                                        </div>`;

            container
                .querySelector('.change-btn')
                .addEventListener('click', (event) => changeTask(event, entry._id));

            container
                .querySelector('.delete-btn')
                .addEventListener('click', (event) => deleteTask(event, entry._id));

            weatherList.appendChild(container);
        }
    } catch (error) {
        console.error('Error: ', error);
        throw error;
    }
}

function changeTask(event, taskID) {
    event.preventDefault();
    enableEditBtn();

    const task = event.target.parentElement.parentElement;
    const [location, date, temperature] = Array.from(task.children);

    locationInput.value = location.textContent;
    dateInput.value = date.textContent;
    temperatureInput.value = temperature.textContent;

    currentTaskId = taskID;

    task.style.display = 'none'; // !! CAUTION !! TODO
}

async function deleteTask(event, taskID) {
    event.preventDefault();

    await fetch(endpoints.delete(taskID), {
        method: 'DELETE'
    });

    await loadHistoryEventHandler();
}

function clearList() {
    weatherList.innerHTML = '';
}

function clearFields() {
    locationInput.value = '';
    temperatureInput.value = '';
    dateInput.value = '';
}

function enableEditBtn() {
    editWeatherBtn.disabled = false;
    addWeatherBtn.disabled = true;
}

function enableAddBtn() {
    editWeatherBtn.disabled = true;
    addWeatherBtn.disabled = false;
}

attachEventListeners();