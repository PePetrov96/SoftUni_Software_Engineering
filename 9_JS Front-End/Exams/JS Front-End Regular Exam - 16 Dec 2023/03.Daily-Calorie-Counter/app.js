const BASE_URL = 'http://localhost:3030/jsonstore/tasks';

const endpoints = {
    update: (id) => `${BASE_URL}/${id}`,
    delete: (id) => `${BASE_URL}/${id}`
}

let currentTaskId = '';

const foodInput = document.getElementById('food');
const timeInput = document.getElementById('time');
const caloriesInput = document.getElementById('calories');

const mealList = document.getElementById('list');

const loadBtn = document.getElementById('load-meals');
const addBtn = document.getElementById('add-meal');
const editBtn = document.getElementById('edit-meal');

function attachEventListeners() {
    loadBtn.addEventListener('click', loadMealsEventHandler);
    addBtn.addEventListener('click', addMealEventHandler);
    editBtn.addEventListener('click', editMealEventHandler);
}

async function editMealEventHandler() {
    if (currentTaskId === '') return;

    const data = {
        food: foodInput.value,
        calories: caloriesInput.value,
        time: timeInput.value,
    }

    await fetch(endpoints.update(currentTaskId), {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data)
    });

    clearFields();
    await loadMealsEventHandler();
    enableAddBtn();
}

async function addMealEventHandler() {
    let food = foodInput.value;
    let time = timeInput.value;
    let calories = caloriesInput.value;

    if (food === '' || time === '' || calories === '') return;

    await fetch(BASE_URL, {
        method: "POST",
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            food: food,
            calories: calories,
            time: time,
        })
    });

    clearFields();
    await loadMealsEventHandler();
}

async function loadMealsEventHandler(){
    clearList();
    
    try {
        let res = await fetch(BASE_URL);
        let data = await res.json();
        let entries = Object.entries(data);

        for (const [, entry] of entries) {
            let container = document.createElement('div');
            container.className = 'meal';

            container.innerHTML = `<h2>${entry.food}</h2>
                                 <h3>${entry.time}</h3>
                                 <h3>${entry.calories}</h3>
                                 <div id="meal-buttons">
                                    <button class="change-meal">Change</button>
                                    <button class="delete-meal">Delete</button>
                                 </div>`;

            container
                .querySelector('.change-meal')
                .addEventListener('click', (event) => changeTask(event, entry._id));

            container
                .querySelector('.delete-meal')
                .addEventListener('click', (event) => deleteTask(event, entry._id));

            mealList.appendChild(container);
        }

    } catch (error) {
        console.error('Error', error);
    }
}

async function changeTask(event, taskID) {
    event.preventDefault();
    enableEditBtn();

    const task = event.target.parentElement.parentElement;
    const [food, time, calories] = Array.from(task.children);

    foodInput.value = food.textContent;
    timeInput.value = time.textContent;
    caloriesInput.value = calories.textContent;

    currentTaskId = taskID;

    mealList.removeChild(task);
}

async function deleteTask(event, taskID) {
    event.preventDefault();
    await fetch(endpoints.delete(taskID), {
        method: 'DELETE'
    });

    await loadMealsEventHandler();
}

function clearList() {
    mealList.innerHTML = '';
}

function clearFields() {
    foodInput.value = '';
    timeInput.value = '';
    caloriesInput.value = '';
}

function enableEditBtn() {
    editBtn.disabled = false;
    addBtn.disabled = true;
}

function enableAddBtn() {
    editBtn.disabled = true;
    addBtn.disabled = false;
}


window.addEventListener("load", attachEventListeners);
