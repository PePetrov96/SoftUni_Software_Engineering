function solve(input) {
    let addressBook = {};

    for (let entry of input) {
        let tokens = entry.split(':');
        let name = tokens[0];
        let address = tokens[1];

        addressBook[name] = address;
    }

    let entries = Object.entries(addressBook);

    entries.sort(([keyA, valueA],[keyB, valueB]) => {
        return keyA.localeCompare(keyB);
    });

    for (let entry in entries) {
        console.log(`${entries[entry][0]} -> ${entries[entry][1]}`);
    }
}

solve(['Tim:Doe Crossing','Bill:Nelson Place','Peter:Carlyle Ave','Bill:Ornery Rd']);
solve(['Bob:Huxley Rd','John:Milwaukee Crossing','Peter:Fordem Ave','Bob:Redwing Ave',
    'George:Mesta Crossing','Ted:Gateway Way','Bill:Gateway Way','John:Grover Rd',
    'Peter:Huxley Rd','Jeff:Gateway Way','Jeff:Huxley Rd']);