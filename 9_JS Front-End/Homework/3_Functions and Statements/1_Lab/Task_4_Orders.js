function solve(product, amount) {
    let cost = price(product) * amount;

    console.log(cost.toFixed(2));
    function price(product) {
        switch (product) {
            case 'coffee':
                return 1.50;
                break;
            case 'water':
                return 1.00;
                break;
            case 'coke':
                return 1.40;
                break;
            case 'snacks':
                return 2.00;
                break;
        }
    }
}

solve("water", 5);
solve("coffee", 2);
solve("coke", 2);