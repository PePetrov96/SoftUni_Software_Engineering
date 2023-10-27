function solve(number) {
    let numberArray = number.toString().split("");
    let sum = 0;

    for (let i = 0; i < numberArray.length; i++) {
        sum += Number(numberArray[i]);
    }

    console.log(sum);
}