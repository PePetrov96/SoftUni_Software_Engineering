function solve(number) {
    let numArray = String(number).split('');

    let isSame = true;

    let sum = Number(numArray[0]);

    for (let i = 1; i < numArray.length; i++) {
        if (numArray[0] !== numArray[i]) {
            isSame = false;
        }

        sum += Number(numArray[i]);
    }
    console.log(isSame);
    console.log(sum);
}

solve(2222222);
solve(1234);