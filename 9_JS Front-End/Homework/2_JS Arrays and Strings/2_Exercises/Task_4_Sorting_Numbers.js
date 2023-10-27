function solve(numbers) {
    let printNumbers = [];

    let count = numbers.length;

    for (let i = 0; i < count; i++) {
        if (i % 2 === 0) {
            numbers.sort(function (a,b) {return a - b;});
        } else {
            numbers.sort(function (a,b) {return b - a;});
        }
        printNumbers.push(numbers.shift());
    }

    return printNumbers;
}

solve([1, 65, 3, 52, 48, 63, 31, -3, 18, 56]);