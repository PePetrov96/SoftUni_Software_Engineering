function solve(input) {
    class Task {
        constructor(taskId, title, status, estimatedPoints) {
            this.taskId = taskId;
            this.title = title;
            this.status = status;
            this.estimatedPoints = Number(estimatedPoints);
        }
    }
    
    function addNew(assigneeName, taskId, title, status, estimatedPoints) {
        if (!assigneesMap.has(assigneeName)) {
            console.log(`Assignee ${assigneeName} does not exist on the board!`);
        } else {
            let task = new Task(taskId, title, status, estimatedPoints);
            assigneesMap.get(assigneeName).push(task);
        }
    }

    function changeStatus(assigneeName, taskId, newStatus) {
        let assignee = assigneesMap.get(assigneeName);

        if (!assignee) {
            console.log(`Assignee ${assigneeName} does not exist on the board!`);
        } else {
            let task = assigneesMap.get(assigneeName).find(t => t.taskId === taskId);

            if (task) {
                task.status = newStatus;
            } else {
                console.log(`Task with ID ${taskId} does not exist for ${assigneeName}!`);
            }
        }
    }

    function removeTask(assigneeName, index) {
        let assignee = assigneesMap.get(assigneeName);

        if (!assignee) {
            console.log(`Assignee ${assigneeName} does not exist on the board!`);
        } else {
            let list = assigneesMap.get(assigneeName);

            if (index < 0 || index >= list.length) {
                console.log('Index is out of range!');
            } else {
                list.splice(index, 1);
            }
        }
    }

    function processInput() {
        for (let i = 0; i < n; i++) {
            let tokens = input.shift().split(':');
            let assignee = tokens[0];
            let task = new Task(tokens[1], tokens[2], tokens[3], tokens[4]);

            if (!assigneesMap.has(assignee)) {
                assigneesMap.set(assignee, []);
            }

            assigneesMap.get(assignee).push(task);
        }

        for (let line of input) {
            let tokens = line.split(":");
            let command = tokens.shift();

            switch (command) {
                case 'Add New': addNew(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4]);
                    break;
                case 'Change Status': changeStatus(tokens[0], tokens[1], tokens[2]);
                    break;
                case 'Remove Task': removeTask(tokens[0], tokens[1]);
                    break;
            }
        }
    }

    function printResult() {
        let toDoTasksTotalPoints = 0;
        let inProgressTasksTotalPoints = 0;
        let codeReviewTasksTotalPoints = 0;
        let doneTasksTotalPoints = 0;

        assigneesMap.forEach(tasks => {
            tasks.forEach(task => {
                switch (task.status) {
                    case 'ToDo':
                        toDoTasksTotalPoints += task.estimatedPoints;
                        break;
                    case 'In Progress':
                        inProgressTasksTotalPoints += task.estimatedPoints;
                        break;
                    case 'Code Review':
                        codeReviewTasksTotalPoints += task.estimatedPoints;
                        break;
                    case 'Done':
                        doneTasksTotalPoints += task.estimatedPoints;
                        break;
                }
            });
        });

        console.log(`ToDo: ${toDoTasksTotalPoints}pts`);
        console.log(`In Progress: ${inProgressTasksTotalPoints}pts`);
        console.log(`Code Review: ${codeReviewTasksTotalPoints}pts`);
        console.log(`Done Points: ${doneTasksTotalPoints}pts`);

        if (doneTasksTotalPoints >= (toDoTasksTotalPoints + inProgressTasksTotalPoints + codeReviewTasksTotalPoints)) {
            console.log('Sprint was successful!');
        } else {
            console.log('Sprint was unsuccessful...');
        }
    }

    let assigneesMap = new Map();

    let n = input.shift();

    processInput();

    printResult();
}

solve([
        '5',

        'Kiril:BOP-1209:Fix Minor Bug:ToDo:3',
        'Mariya:BOP-1210:Fix Major Bug:In Progress:3',
        'Peter:BOP-1211:POC:Code Review:5',
        'Georgi:BOP-1212:Investigation Task:Done:2',
        'Mariya:BOP-1213:New Account Page:In Progress:13',

        'Add New:Kiril:BOP-1217:Add Info Page:In Progress:5',
        'Change Status:Peter:BOP-1290:ToDo',
        'Remove Task:Mariya:1',
        'Remove Task:Joro:1',]);

solve(  [
        '4',

        'Kiril:BOP-1213:Fix Typo:Done:1',
        'Peter:BOP-1214:New Products Page:In Progress:2',
        'Mariya:BOP-1215:Setup Routing:ToDo:8',
        'Georgi:BOP-1216:Add Business Card:Code Review:3',

        'Add New:Sam:BOP-1237:Testing Home Page:Done:3',
        'Change Status:Georgi:BOP-1216:Done',
        'Change Status:Will:BOP-1212:In Progress',
        'Remove Task:Georgi:3',
        'Change Status:Mariya:BOP-1215:Done',]);