function solve(n) {
    for (let i = 0; i < n; i++) {
        printRow(n);
    }

    function printRow(n) {
        console.log((n.toString() + " ").repeat(n));
    }
}

solve(3);
solve(7);
solve(2);