function solve(num1, num2, num3) {
    let printNum;

    if (num1 > num2 && num1 > num3) {
        printNum = num1;
    } else if (num2 > num1 && num2 > num3) {
        printNum = num2;
    } else if (num3 > num1 && num3 > num2) {
        printNum = num3;
    }

    console.log(`The largest number is ${printNum}.`);
}

solve(-3, -5, -22.5)