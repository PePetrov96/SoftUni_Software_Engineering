function solve(input) {
    function assignFlights(input) {
        let map = new Map();

        for (const inputFlight of input) {
            let tokens = inputFlight.split(' ');
            let code = tokens.shift();
            let destination = tokens.join(' ');

            map.set(code, {Destination: destination, Status: 'Ready to fly'});
        }

        return map;
    }

    function updateFlights(flights, input) {
        let map = flights;

        for (const inputFlight of input) {
            let tokens = inputFlight.split(' ');
            let code = tokens.shift();
            let updatedStatus = tokens.join(' ');

            if (map.has(code)) {
                map.get(code).Status = updatedStatus;
            }
        }

        return map;
    }

    function printFlights(flights, status) {
        let filteredFlights = new Map([...flights].filter(([_,flight]) => flight.Status === status));
        filteredFlights.forEach(flight => console.log(flight));
    }

    let flights = assignFlights(input[0]);
    let updatedFlights = updateFlights(flights, input[1]);
    printFlights(updatedFlights, input[2][0]);
}

solve([['WN269 Delaware','FL2269 Oregon','WN498 Las Vegas','WN3145 Ohio','WN612 Alabama','WN4010 New York',
    'WN1173 California', 'DL2120 Texas','KL5744 Illinois','WN678 Pennsylvania'],
    ['DL2120 Cancelled','WN612 Cancelled','WN1173 Cancelled','SK430 Cancelled'],['Cancelled']]);
solve([['WN269 Delaware','FL2269 Oregon','WN498 Las Vegas','WN3145 Ohio','WN612 Alabama','WN4010 New York',
    'WN1173 California','DL2120 Texas','KL5744 Illinois','WN678 Pennsylvania'],
    ['DL2120 Cancelled','WN612 Cancelled','WN1173 Cancelled','SK330 Cancelled'],
    ['Ready to fly']]);