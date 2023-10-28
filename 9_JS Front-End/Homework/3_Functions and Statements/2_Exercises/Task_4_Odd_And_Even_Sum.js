function solve(largeNumber) {
    let numbersArray = largeNumber.toString().split('');

    let oddSum = sumOddNumbers(numbersArray);
    let evenSum = sumEvenNumbers(numbersArray);

    console.log(`Odd sum = ${oddSum}, Even sum = ${evenSum}`);

    function sumEvenNumbers(numbers) {
        let sum = 0;

        for (let i = 0; i < numbers.length; i++) {
            let number = Number(numbersArray[i]);
            if (number % 2 === 0) {
                sum += number;
            }
        }

        return sum;
    }
    function sumOddNumbers(numbers) {
        let sum = 0;

        for (let i = 0; i < numbers.length; i++) {
            let number = Number(numbersArray[i]);
            if (number % 2 !== 0) {
                sum += number;
            }
        }

        return sum;
    }
}

solve(1000435);
solve(3495892137259234);