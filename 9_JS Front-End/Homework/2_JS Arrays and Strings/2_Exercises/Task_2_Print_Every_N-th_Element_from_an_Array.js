function solve(array, number) {
    let printArray = [];

    for (let i = 0; i < array.length; i += number) {
        printArray.push(array[i]);
    }

    return printArray;
}

solve(['5','20','31','4','20'], 2);
solve(['dsa', 'asd', 'test', 'tset'], 2);
solve(['1', '2', '3', '4', '5'],);