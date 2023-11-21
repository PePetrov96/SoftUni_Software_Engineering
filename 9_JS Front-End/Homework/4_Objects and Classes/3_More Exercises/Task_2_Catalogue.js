function solve(input) {
    let products = new Map();

    for (let product of input) {
        let tokens = product.split(' : ');
        let name = tokens[0];
        let price = Number(tokens[1]);

        products.set(name, price);
    }

    let sortedProducts = new Map([...products.entries()].sort((a, b) => {
        // Convert keys to lowercase for case-insensitive sorting
        let keyA = a[0].toLowerCase();
        let keyB = b[0].toLowerCase();

        if (keyA < keyB) return -1;
        if (keyA > keyB) return 1;
        return 0;
    }));

    let sortedMap = new Map();

    for (const [key, value] of sortedProducts) {
        let keyLetter = key.split('')[0];
        let product = `${key}: ${value}`;

        if (sortedMap.has(keyLetter)) {
            let existingValues = sortedMap.get(keyLetter);
            existingValues.push(product);
            sortedMap.set(keyLetter, existingValues);
        } else {
            sortedMap.set(keyLetter, [product]);
        }
    }

    sortedMap.forEach((value, key) => {
        console.log(key);
        value.forEach(value => console.log(`  ${value}`));
    });
}

solve(['Appricot : 20.4','Fridge : 1500','TV : 1499','Deodorant : 10','Boiler : 300',
    'Apple : 1.25','Anti-Bug Spray : 15','T-Shirt : 10']);
solve(['Omlet : 5.4','Shirt : 15','Cake : 59']);