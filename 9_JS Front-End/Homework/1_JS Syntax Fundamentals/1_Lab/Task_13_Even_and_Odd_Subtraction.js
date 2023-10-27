function solve(arr) {
    let evenSum = 0;
    let oddSum = 0;

    for (let i = 0; i <= arr.length-1; i++) {
        let num = Number(arr[i]);

        if (num % 2 === 0) { //even
            evenSum += num;
        } else { //odd
            oddSum += num;
        }
    }

    console.log(evenSum - oddSum);
}

solve([1,2,3,4,5,6]);
solve([3,5,7,9]);
solve([2,4,6,8,10]);