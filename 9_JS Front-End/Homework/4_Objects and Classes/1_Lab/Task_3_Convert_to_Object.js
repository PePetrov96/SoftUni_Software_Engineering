function solve(input) {
    let object = JSON.parse(input);

    let entry = Object.entries(object);

    for (let [key, value] of entry) {
        console.log(`${key}: ${value}`);
    }

}

solve('{"name": "George", "age": 40, "town": "Sofia"}');
solve('{"name": "Peter", "age": 35, "town": "Plovdiv"}');