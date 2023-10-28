function solve(a, b, func) {
    switch (func) {
        case 'multiply':
            console.log(multiply(a,b));
            break
        case 'divide':
            console.log(divide(a,b));
            break
        case 'add':
            console.log(add(a,b));
            break
        case 'subtract':
            console.log(subtract(a,b));
            break
    }

    function multiply(a,b) {
        return a * b;
    }
    function divide(a,b) {
        return a / b;
    }

    function add(a,b) {
        return a + b;
    }
    function subtract(a,b) {
        return a - b;
    }
}

solve(5,5,'multiply');
solve(40,8,'divide');
solve(12,19,'add');
solve(50,13,'subtract');