function solve(firstList, secondList) {
    let productList = {};

    for (let i = 0; i < firstList.length; i++) {
        let name = firstList[i];
        let quantity = Number(firstList[i+1]);
        i++;

        productList[name] = quantity;
    }

    for (let i = 0; i < secondList.length; i++) {
        let name = secondList[i];
        let quantity = Number(secondList[i+1]);
        i++;

        if (!productList.hasOwnProperty(name)) {
            productList[name] = quantity;
        } else {
            productList[name] += quantity;
        }
    }

    for (let product in productList) {
        console.log(`${product} -> ${productList[product]}`)
    }
}

solve(['Chips', '5', 'CocaCola', '9', 'Bananas','14', 'Pasta', '4', 'Beer', '2'],
    ['Flour', '44', 'Oil', '12', 'Pasta', '7','Tomatoes', '70', 'Bananas', '30']);
solve(['Salt', '2', 'Fanta', '4', 'Apple', '14', 'Water', '4', 'Juice', '5' ],
    [ 'Sugar', '44', 'Oil', '12', 'Apple', '7', 'Tomatoes', '7', 'Bananas', '30']);