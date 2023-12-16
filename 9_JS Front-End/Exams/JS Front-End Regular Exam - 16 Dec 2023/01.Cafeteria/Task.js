function solve(input) {
    class Barista {
        constructor(name, shift, coffeeList) {
            this.name = name;
            this.shift = shift;
            this.coffeeList = coffeeList;
        }
    }

    let baristaMap = new Map();

    fillMap();

    processCommands();

    printOutput();

    function fillMap() {
        let n = input.shift();

        for (let i = 0; i < n; i++) {
            let [name, shift, coffeeData] = input.shift().split(' ');
            let coffeeList = coffeeData.split(',');

            baristaMap.set(name, new Barista(name, shift, coffeeList));

        }
    }

    function processCommands() {
        let line = input.shift();

        while (line !== 'Closed') {
            let tokens = line.split(' / ');
            let command = tokens.shift();

            switch (command) {
                case 'Prepare': prepare(tokens[0], tokens[1], tokens[2]);
                    break;
                case 'Change Shift': changeShift(tokens[0], tokens[1]);
                    break;
                case 'Learn': learn(tokens[0], tokens[1]);
                    break;
            }

            line = input.shift();
        }
    }
    
    function prepare(baristaName, shift, coffeeType) {
        let barista = baristaMap.get(baristaName);

        if (barista.shift === shift && barista.coffeeList.includes(coffeeType)) {
            console.log(`${baristaName} has prepared a ${coffeeType} for you!`);
        } else {
            console.log(`${baristaName} is not available to prepare a ${coffeeType}.`);
        }
    }
    
    function changeShift(baristaName, newShift) {
        baristaMap.get(baristaName).shift = newShift;
        console.log(`${baristaName} has updated his shift to: ${newShift}`);
    }
    
    function learn(baristaName, newCoffeeType) {
        let barista = baristaMap.get(baristaName);

        if (barista.coffeeList.includes(newCoffeeType)) {
            console.log(`${baristaName} knows how to make ${newCoffeeType}.`);
        } else {
            barista.coffeeList.push(newCoffeeType);
            console.log(`${baristaName} has learned a new coffee type: ${newCoffeeType}.`);
        }
    }

    function printOutput() {
        baristaMap.forEach(barista => {
            let name = barista.name;
            let shift = barista.shift;
            let coffeeList = barista.coffeeList;

            console.log(`Barista: ${name}, Shift: ${shift}, Drinks: ${coffeeList.join(', ')}`);
        });
    }
}

// solve(['3',
//     'Alice day Espresso,Cappuccino',
//     'Bob night Latte,Mocha',
//     'Carol day Americano,Mocha',
//     'Prepare / Alice / day / Espresso',
//     'Change Shift / Bob / night',
//     'Learn / Carol / Latte',
//     'Learn / Bob / Latte',
//     'Prepare / Bob / night / Latte',
//     'Closed']);
//
// solve(['4',
//     'Alice day Espresso,Cappuccino',
//     'Bob night Latte,Mocha',
//     'Carol day Americano,Mocha',
//     'David night Espresso',
//     'Prepare / Alice / day / Espresso',
//     'Change Shift / Bob / day',
//     'Learn / Carol / Latte',
//     'Prepare / Bob / night / Latte',
//     'Learn / David / Cappuccino',
//     'Prepare / Carol / day / Cappuccino',
//     'Change Shift / Alice / night',
//     'Learn / Bob / Mocha',
//     'Prepare / David / night / Espresso',
//     'Closed']);