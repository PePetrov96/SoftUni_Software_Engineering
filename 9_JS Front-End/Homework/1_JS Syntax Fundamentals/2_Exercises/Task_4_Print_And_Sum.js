function solve(start, end) {
    let sum = 0;
    let string = "";

    for (let i = start; i <= end; i++) {
        sum += i;
        string += (i + " ");
    }

    console.log(string.trim());
    console.log(`Sum: ${sum}`);
}