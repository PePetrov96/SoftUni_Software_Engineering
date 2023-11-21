function solve(input) {
    let garage = new Map();

    for (const line of input) {
        let tokens = line.split(' - ');
        let garageNumber = tokens[0];
        let info = tokens[1].split(': ').join(' - ');

        if (!garage.has(garageNumber)) {
            garage.set(garageNumber, [info]);
        } else {
            let currentInfo = garage.get(garageNumber);
            currentInfo.push(info);
        }
    }

    garage.forEach((value, key, map) => {
        console.log(`Garage № ${key}`);
        value.forEach(value => console.log(`--- ${value}`));
    })
}

solve(['1 - color: blue, fuel type: diesel', '1 - color: red, manufacture: Audi',
    '2 - fuel type: petrol', '4 - color: dark blue, fuel type: diesel, manufacture: Fiat']);

solve(['1 - color: green, fuel type: petrol', '1 - color: dark red, manufacture: WV',
    '2 - fuel type: diesel', '3 - color: dark blue, fuel type: petrol']);