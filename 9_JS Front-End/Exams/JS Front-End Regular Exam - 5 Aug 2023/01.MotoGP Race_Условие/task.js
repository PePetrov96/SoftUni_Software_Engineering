function solve(input) {
    class Driver {
        constructor(rider, fuel, position) {
            this.rider = rider;
            this.fuel = Number(fuel);
            this.position = Number(position);
        }
    }

    function fillMap() {
        let out = new Map();
        let n = input.shift();

        for (let i = 0; i < n; i++) {
            let tokens = input.shift().split('|');

            let rider = tokens[0];
            let fuel = tokens[1];
            let position = tokens[2];

            out.set(rider, new Driver(rider, fuel, position));
        }

        return out;
    }

    function StopForFuel(rider, minFuel, changedPosition) {
        let driver = driverList.get(rider);

        if (driver.fuel >= minFuel) {
            console.log(`${rider} does not need to stop for fuel!`);
        } else {
            driver.position = changedPosition;
            console.log(`${rider} stopped to refuel but lost his position, now he is ${changedPosition}.`);
        }
    }

    function Overtaking(rider1, rider2) {
        let driver1 = driverList.get(rider1);
        let driver2 = driverList.get(rider2);

        if (driver1.position < driver2.position) {
            [driver1.position, driver2.position] = [driver2.position, driver1.position];
            console.log(`${rider1} overtook ${rider2}!`);
        }
    }

    function EngineFail(rider, lapsLeft) {
        driverList.delete(rider);
        console.log(`${rider} is out of the race because of a technical issue, ${lapsLeft} laps before the finish.`);
    }

    const driverList = fillMap();

    let command = input.shift();

    while (command !== 'Finish') {
        let tokens = command.split(' - ');

        switch (tokens[0]) {
            case 'StopForFuel': StopForFuel(tokens[1], tokens[2], tokens[3]);
                break;
            case 'Overtaking': Overtaking(tokens[1], tokens[2]);
                break;
            case 'EngineFail': EngineFail(tokens[1], tokens[2]);
                break;
        }

        command = input.shift();
    }

    for (const [key, driver] of driverList) {
        console.log(`${driver.rider}\n Final position: ${driver.position}`);
    }
}

// solve(["3",
//   "Valentino Rossi|100|1",
//   "Marc Marquez|90|2",
//   "Jorge Lorenzo|80|3",
//   "StopForFuel - Valentino Rossi - 50 - 1",
//   "Overtaking - Marc Marquez - Jorge Lorenzo",
//   "EngineFail - Marc Marquez - 10",
//   "Finish"]);
//
// solve(["4",
//   "Valentino Rossi|100|1",
//   "Marc Marquez|90|3",
//   "Jorge Lorenzo|80|4",
//   "Johann Zarco|80|2",
//   "StopForFuel - Johann Zarco - 90 - 5",
//   "Overtaking - Marc Marquez - Jorge Lorenzo",
//   "EngineFail - Marc Marquez - 10",
//   "Finish"]);
