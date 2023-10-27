function solve(list) {
    let evenSum = 0;
    let oddSum = 0;

    for (let i = 0; i < list.length; i++) {
        if (list[i] % 2 === 0) {
            evenSum += list[i];
        } else {
            oddSum += list[i];
        }
    }

    console.log(evenSum - oddSum);
}

solve([1,2,3,4,5,6]);
solve([3,5,7,9]);
solve([2,4,6,8,10]);