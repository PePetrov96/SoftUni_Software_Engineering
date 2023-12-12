window.addEventListener('load', solve);

function solve() {
    const titleInput = document.getElementById('title');
    const descriptionInput = document.getElementById('description');
    const labelInput = document.getElementById('label');
    const pointsInput = document.getElementById('points');
    const assigneeInput = document.getElementById('assignee');

    const createTaskBtn = document.getElementById('create-task-btn');
    const deleteTaskBtn = document.getElementById('delete-task-btn');

    const taskList = document.getElementById('tasks-section');

    const taskID = document.getElementById('task-id');

    const totalPoints = document.getElementById('total-sprint-points');

    let index = 1;

    function attachEvents() {
        createTaskBtn.addEventListener('click', createTaskEventHandler);
        deleteTaskBtn.addEventListener('click', deleteTaskEventHandler);
    }

    function createTaskEventHandler() {
        let title = titleInput.value;
        let description = descriptionInput.value;
        let label = labelInput.value;
        let points = pointsInput.value;
        let assignee = assigneeInput.value;

        if (title === '' || description === '' || points === '' || assignee === '') {
            return;
        }

        let id = `task-${index++}`;

        let article = document.createElement('article');
        article.id = id;
        article.className = 'task-card';
        taskID.value = id;


        article.innerHTML = `
            <div class="task-card-label ${getClassName(label)}">${label} ${getIcon(label)}</div>
            <h3 class="task-card-title">${title}</h3>
            <p class="task-card-description">${description}</p>
            <div class="task-card-points">Estimated at ${points} pts</div>
            <div class="task-card-assignee">Assigned to: ${assignee}</div>
            <div class="task-card-actions">
                <button>Delete</button>
            </div>
        `;

        article
            .querySelector('.task-card-actions button')
            .addEventListener('click', event => prepareDelete(event));

        taskList.appendChild(article);
        clearFields();
        addPoints(points);
    }

    function deleteTaskEventHandler() {
        //remove the task from the list
        let taskToDelete = taskList.querySelector(`#${taskID.value}`);
        taskList.removeChild(taskToDelete);

        clearFields();
        enableCreateBtn();
        removePoints(taskToDelete.querySelector('.task-card-points'));
        enableFields();
    }

    function prepareDelete(event) {
        //find the task and its ID
        let item = event.target.parentElement.parentElement;
        taskID.value = item.id;

        //fill in the form with the details
        titleInput.value = item
            .querySelector('.task-card-title')
            .textContent;

        descriptionInput.value = item
            .querySelector('.task-card-description')
            .textContent;

        labelInput.value = item
            .querySelector('.task-card-label')
            .textContent
            .slice(0, -1)
            .trim();

        pointsInput.value = Number(item
            .querySelector('.task-card-points')
            .textContent
            .replace('Estimated at ','')
            .replace(' pts', ''));

        assigneeInput.value = item
            .querySelector('.task-card-assignee')
            .textContent
            .replace('Assigned to: ', '');

        disableFields();
        enableDeleteBtn();
    }
    
    function getIcon(type) {
        switch (type) {
            case 'Feature': return '&#8865';
            case 'Low Priority Bug': return '&#9737';
            case 'High Priority Bug': return '&#9888';
        }
    }

    function getClassName(type) {
        switch (type) {
            case 'Feature': return 'feature';
            case 'Low Priority Bug': return 'low-priority';
            case 'High Priority Bug': return 'high-priority';
        }
    }

    function clearFields() {
        titleInput.value = '';
        descriptionInput.value = '';
        labelInput.selectedIndex = 0;
        pointsInput.value = '';
        assigneeInput.value = '';
    }

    function enableDeleteBtn() {
        createTaskBtn.disabled = true;
        deleteTaskBtn.disabled = false;
    }

    function enableCreateBtn() {
        createTaskBtn.disabled = false;
        deleteTaskBtn.disabled = true;
    }

    function addPoints(points) {
        let add = Number(points);
        let current = parseInt((totalPoints.textContent).match(/\d+/)[0], 10);


        let updated = current + add;

        totalPoints.textContent = `Total Points ${updated}pts`;
    }

    function disableFields() {
        assigneeInput.disabled = true;
        pointsInput.disabled = true;
        labelInput.disabled = true;
        descriptionInput.disabled = true;
        titleInput.disabled = true;
    }

    function enableFields() {
        assigneeInput.disabled = false;
        pointsInput.disabled = false;
        labelInput.disabled = false;
        descriptionInput.disabled = false;
        titleInput.disabled = false;
    }

    function removePoints(points) {
        let remove = parseInt((points.textContent).match(/\d+/)[0], 10);
        let current = parseInt((totalPoints.textContent).match(/\d+/)[0], 10);

        let updated = current - remove;

        totalPoints.textContent = `Total Points ${updated}pts`;

    }

    attachEvents();
}