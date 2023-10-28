function solve(input) {
    let cars = new Set();

    for (const line of input) {
        let car = line.split(', ');
        let command = car.shift();
        let cardNumber = car.shift();

        if (command === 'IN') {
            cars.add(cardNumber);
        } else if (command === 'OUT') {
            cars.delete(cardNumber);
        }
    }

    cars = new Set([...cars].sort());

    if (cars.size === 0) {
        console.log('Parking Lot is Empty');
    } else {
        for (const car of cars) {
            console.log(car);
        }
    }
}

solve(['IN, CA2844AA', 'IN, CA1234TA', 'OUT, CA2844AA', 'IN, CA9999TT', 'IN, CA2866HI', 'OUT, CA1234TA',
    'IN, CA2844AA', 'OUT, CA2866HI', 'IN, CA9876HH', 'IN, CA2822UU']);
solve(['IN, CA2844AA','IN, CA1234TA','OUT, CA2844AA','OUT, CA1234TA']);