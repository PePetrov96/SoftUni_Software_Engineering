function solve(input) {
    function fillList() {
        let groceries = input.shift().split('!');

        for (const grocery of groceries) {
            groceriesList.push(grocery);
        }
    }

    function urgent(item) {
        if (!groceriesList.includes(item)) {
            groceriesList.unshift(item);
        }
    }

    function unnecessary(item) {
        if (groceriesList.includes(item)) {
            let index = groceriesList.indexOf(item);

            groceriesList.splice(index, 1);
        }
    }

    function correct(oldItem, newItem) {
        if (groceriesList.includes(oldItem)) {
            let index = groceriesList.indexOf(oldItem);

            groceriesList.splice(index, 1, newItem);
        }
    }

    function rearrange(item) {
        if (groceriesList.includes(item)) {
            let index = groceriesList.indexOf(item);
            groceriesList.push(groceriesList.splice(index, 1));
        }
    }

    function runCommands() {
        let line = input.shift();

        while (line !== 'Go Shopping!') {
            let tokens = line.split(' ');
            let command = tokens.shift();

            switch (command) {
                case 'Urgent': urgent(tokens[0]);
                    break;
                case 'Unnecessary': unnecessary(tokens[0]);
                    break;
                case 'Correct': correct(tokens[0], tokens[1]);
                    break;
                case 'Rearrange': rearrange(tokens[0]);
                    break;
            }

            line = input.shift();
        }
    }

    let groceriesList = [];
    fillList();
    runCommands();

    console.log(groceriesList.join(', '));
}

solve(["Tomatoes!Potatoes!Bread",
    "Unnecessary Milk",
    "Urgent Tomatoes",
    "Go Shopping!"]);

solve(["Milk!Pepper!Salt!Water!Banana",
    "Urgent Salt",
    "Unnecessary Grapes",
    "Correct Pepper Onion",
    "Rearrange Grapes",
    "Correct Tomatoes Potatoes",
    "Go Shopping!"]);