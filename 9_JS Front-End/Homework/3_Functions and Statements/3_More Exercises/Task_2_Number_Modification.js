function solve(n) {
    while(getAverage(n) < 5) {
        n = (n * 10) + 9;
    }

    console.log(n);

    function getAverage(n) {
        let average = 0;
        let numbers = n.toString().split('');

        for (let i = 0; i < numbers.length; i++) {
            average += Number(numbers[i]);
        }

        return average / numbers.length;
    }
}

solve(101);
solve(5835);