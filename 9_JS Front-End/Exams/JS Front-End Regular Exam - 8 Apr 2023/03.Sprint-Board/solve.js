const BASE_URL = 'http://localhost:3030/jsonstore/tasks';

const endpoints = {
    update: (id) => `${BASE_URL}/${id}`,
    delete: (id) => `${BASE_URL}/${id}`
}

const toDoList = document.querySelector('#todo-section .task-list');
const inProgressList = document.querySelector('#in-progress-section .task-list');
const codeReviewList = document.querySelector('#code-review-section .task-list');
const doneList = document.querySelector('#done-section .task-list');

const titleInput = document.getElementById('title');
const descriptionInput = document.getElementById('description');

const createTaskBtn = document.getElementById('create-task-btn');
const loadBoardBtn = document.getElementById('load-board-btn');

function attachEvents() {
    loadBoardBtn.addEventListener('click', loadBoardEventHandler);
    createTaskBtn.addEventListener('click', addTaskEventHandler);
}

async function loadBoardEventHandler() {
    clearAllLists();

    try {
        let res = await fetch(BASE_URL);
        let data = await res.json();
        
        let entries = Object.entries(data);

        for (const [key, entry] of entries) {
            //Create li element and set class name
            let li = document.createElement('li');
            li.className = 'task';

            //Create h3 element, for title and append it
            let h3 = document.createElement('h3');
            h3.innerText = entry.title.trim();
            li.appendChild(h3);

            //Create p element, for description and append it
            let p = document.createElement('p');
            p.innerText = entry.description.trim();
            li.appendChild(p);

            //Create button element
            let button = document.createElement('button');

            //Name the button, based on the task's status and place it in the correct list
            switch (entry.status) {
                case 'ToDo':
                    button.innerText = 'Move to In Progress';
                    li.appendChild(button);
                    toDoList.appendChild(li);
                    break;
                case 'In Progress':
                    button.innerText = 'Move to Code Review';
                    li.appendChild(button);
                    inProgressList.appendChild(li);
                    break;
                case 'Code Review':
                    button.innerText = 'Move to Done';
                    li.appendChild(button);
                    codeReviewList.appendChild(li);
                    break;
                case 'Done':
                    button.innerText = 'Close';
                    li.appendChild(button);
                    doneList.appendChild(li);
                    break;
            }

            //Add event handler for the button. Send the event location and the entry id to the method
            button
                .addEventListener('click',
                        event => moveTaskEventHandler(event, entry._id));

        }

    } catch (error) {
        console.error('Error:', error);
        throw error;
    }
}

async function addTaskEventHandler() {
    let title = titleInput.value;
    let description = descriptionInput.value;

    //Check if either fields is empty and do nothing if one of them is
    if (title === '' || description === '') {
        return;
    }

    //POST the task to the localhost
    await fetch(BASE_URL, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            title: title,
            description: description,
            status: 'ToDo',
        })
    });

    //clear the fields and reload the board
    clearFields();
    await loadBoardEventHandler();
}

async function moveTaskEventHandler(event, taskId) {
    //get the <li> of the button
    let element = event.target.parentElement;

    let title = element.querySelector('h3').textContent;
    let description = element.querySelector('p').textContent;
    let status = getStatus(element); // get the new status, based on the current status. If the status is already "Done", then 'null' will be returned

    if (status !== null) { //If we get a status - Move the task to the next location
        const data = {
            title: title,
            description: description,
            status: status,
            _id: taskId,
        }

        await fetch(endpoints.update(taskId), {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data)
        });
    } else { //If 'null' is returned, then we delete the element
        //delete the task
        await fetch(endpoints.delete(taskId), {
            method: 'DELETE'
        });
    }

    // Reload the board
    await loadBoardEventHandler();
}

function getStatus(element) {
    // get the parent ("article") of the parent ('ul') of the <li> element and see the #ID of the <article>
    let listName = element.parentElement.parentElement.id;

    switch (listName) {
        case 'todo-section': return 'In Progress';
        case 'in-progress-section': return 'Code Review';
        case 'code-review-section': return 'Done';
        case 'done-section': return null;
    }
}

function clearAllLists() {
    toDoList.innerHTML = '';
    inProgressList.innerHTML = '';
    codeReviewList.innerHTML = '';
    doneList.innerHTML = '';
}

function clearFields() {
    titleInput.value = '';
    descriptionInput.value = '';
}

attachEvents();