function solve(input) {
    let phonebook = {};

    for (let entry of input) {
        let tokens = entry.split(' ');
        let name = tokens[0];
        let number = tokens[1];
        phonebook[name] = number;
    }

    for (let key in phonebook) {
        console.log(`${key} -> ${phonebook[key]}`);
    }
}

solve(['Tim 0834212554','Peter 0877547887','Bill 0896543112','Tim 0876566344']);
solve(['George 0552554','Peter 087587','George 0453112','Bill 0845344']);