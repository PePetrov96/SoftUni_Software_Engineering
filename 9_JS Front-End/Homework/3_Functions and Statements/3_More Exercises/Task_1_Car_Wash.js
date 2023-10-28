function solve(actions) {
    let cleaned = 0;

    for (const action of actions) {
        switch (action) {
            case 'soap':
                cleaned += 10;
                break
            case 'water':
                cleaned += (cleaned * 0.20);
                break
            case 'vacuum cleaner':
                cleaned += (cleaned * 0.25);
                break
            case 'mud':
                cleaned -= (cleaned * 0.10);
                break
        }
    }
    console.log(`The car is ${cleaned.toFixed(2)}% clean.`);
}

solve(['soap', 'soap', 'vacuum cleaner', 'mud', 'soap', 'water']);
solve(["soap", "water", "mud", "mud", "water", "mud", "vacuum cleaner"]);
