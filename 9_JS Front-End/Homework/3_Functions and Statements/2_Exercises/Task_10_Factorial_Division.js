function solve(num1, num2) {
    let firstFactorial = getFactorial(num1);
    let secondFactorial = getFactorial(num2);

    console.log((firstFactorial / secondFactorial).toFixed(2));

    function getFactorial(n) {
        if (n === 0) {
            return 1;
        } else {
            return n * getFactorial(n - 1);
        }
    }
}

solve(5,2);
solve(6,2);