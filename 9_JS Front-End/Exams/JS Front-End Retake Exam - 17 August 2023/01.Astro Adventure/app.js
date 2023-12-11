function solve(input) {
    function explore(astronaut, energyNeeded) {
        if (astronaut.energyReserves >= energyNeeded) {
            console.log(`${astronaut.name} has successfully explored a new area and now has ${astronaut.energyReserves -= energyNeeded} energy!`);
        } else {
            console.log(`${astronaut.name} does not have enough energy to explore!`);
        }
    }
    function refuel(astronaut, amount) {
        if (astronaut.energyReserves + amount > 200) {
            let amount1 = 200 - astronaut.energyReserves;
            astronaut.energyReserves = 200;
            console.log(`${astronaut.name} refueled their energy by ${amount1}!`);
        } else {
            astronaut.energyReserves += amount;
            console.log(`${astronaut.name} refueled their energy by ${amount}!`);
        }
    }
    function breathe(astronaut, amount) {
        if (astronaut.oxygenLevel + amount > 100) {
            let amount1 = 100 - astronaut.oxygenLevel;
            astronaut.oxygenLevel = 100;
            console.log(`${astronaut.name} took a breath and recovered ${amount1} oxygen!`);
        } else {
            astronaut.oxygenLevel += amount;
            console.log(`${astronaut.name} took a breath and recovered ${amount} oxygen!`);
        }
    }
    class Astronaut {
        constructor(name, oxygenLevel, energyReserves) {
            this.name = name;
            this.oxygenLevel = Number(oxygenLevel);
            this.energyReserves = Number(energyReserves);
        }
    }

    let astronautList = new Map();

    let n = input.shift();

    for (let i = 0; i < n; i++) {
        let tokens = input.shift().split(' ');
        let name = tokens[0];
        let oxygenLevel = tokens[1];
        let energyReserves = tokens[2];

        astronautList.set(name, new Astronaut(name, oxygenLevel, energyReserves));
    }

    let command = input.shift().split(' - ');

    while (command[0] !== "End") {
        let astronaut = astronautList.get(command[1]);

        switch (command[0]) {
            case 'Explore': explore(astronaut, Number(command[2]));
                break;
            case 'Refuel': refuel(astronaut, Number(command[2]));
                break;
            case 'Breathe': breathe(astronaut, Number(command[2]));
                break;
        }

        command = input.shift().split(' - ');
    }

    for (const [key, astronaut] of astronautList) {
        console.log(`Astronaut: ${astronaut.name}, Oxygen: ${astronaut.oxygenLevel}, Energy: ${astronaut.energyReserves}`);
    }
}