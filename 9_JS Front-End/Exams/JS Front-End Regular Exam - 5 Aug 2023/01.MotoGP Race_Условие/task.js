function solve(input) {
    class Rider {
        constructor(name, fuel, position) {
            this.name = name;
            this.fuel = Number(fuel);
            this.position = Number(position);
        }
    }

    const riders = [];
    const n = Number(input.shift());
    for (let i = 0; i < n; i++) {
        let [name, fuel, position] = input.shift().split("|");
        riders.push(new Rider(name, fuel, position));
    }

    input.forEach(command => {
        let [action, ...args] = command.split(" - ");
        switch (action) {
            case "StopForFuel":
                stopForFuel(args[0], Number(args[1]), Number(args[2]));
                break;
            case "Overtaking":
                overtaking(args[0], args[1]);
                break;
            case "EngineFail":
                engineFail(args[0], Number(args[1]));
                break;
        }
    });

    function stopForFuel(riderName, minFuel, newPosition) {
        let rider = riders.find(r => r.name === riderName);
        if (rider.fuel < minFuel) {
            rider.position = newPosition;
            console.log(`${rider.name} stopped to refuel but lost his position, now he is ${rider.position}.`);
        } else {
            console.log(`${rider.name} does not need to stop for fuel!`);
        }
    }

    function overtaking(rider1Name, rider2Name) {
        let rider1 = riders.find(r => r.name === rider1Name);
        let rider2 = riders.find(r => r.name === rider2Name);
        if (rider1.position < rider2.position) {
            [rider1.position, rider2.position] = [rider2.position, rider1.position];
            console.log(`${rider1Name} overtook ${rider2Name}!`);
        }
    }

    function engineFail(riderName, lapsLeft) {
        let index = riders.findIndex(r => r.name === riderName);
        console.log(`${riders[index].name} is out of the race because of a technical issue, ${lapsLeft} laps before the finish.`);
        riders.splice(index, 1);
    }

    riders.forEach(rider => console.log(`${rider.name}\n  Final position: ${rider.position}`));
}

solve(["3",
    "Valentino Rossi|100|1",
    "Marc Marquez|90|2",
    "Jorge Lorenzo|80|3",
    "StopForFuel - Valentino Rossi - 50 - 1",
    "Overtaking - Marc Marquez - Jorge Lorenzo",
    "EngineFail - Marc Marquez - 10",
    "Finish"]);

solve(["4",
    "Valentino Rossi|100|1",
    "Marc Marquez|90|3",
    "Jorge Lorenzo|80|4",
    "Johann Zarco|80|2",
    "StopForFuel - Johann Zarco - 90 - 5",
    "Overtaking - Marc Marquez - Jorge Lorenzo",
    "EngineFail - Marc Marquez - 10",
    "Finish"]);
