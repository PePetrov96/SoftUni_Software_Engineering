function solve(names) {
    names.sort();

    for (let i = 0; i < names.length; i++) {
        if (names[i] !== "") {
            console.log(`${i+1}.${names[i]}`);
        }
    }
}

solve(["John", "Bob", "Christina", "Ema"]);
solve(['']);