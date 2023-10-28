function solve(numbers) {

    for (const number of numbers) {
        let reverseNumber = Number(number.toString().split('').reverse().join(''));

        console.log(checkIfPalindrome(number, reverseNumber));
    }
    function checkIfPalindrome(num1, num2) {
        return num1 === num2;
    }
}

solve([123,323,421,121]);
solve([32,2,232,1010]);