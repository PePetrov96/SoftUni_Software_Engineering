function solve(length, array) {
    let finalArray = [];

    for (let i = length-1; i >= 0; i--) {
        finalArray += array[i] + " ";
    }

    console.log(finalArray.trim());
}

solve(3, [10, 20, 30, 40, 50]);