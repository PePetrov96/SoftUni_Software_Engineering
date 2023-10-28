function solve(city) {
    let entry = Object.entries(city);

    for (let [key, value] of entry) {
        console.log(`${key} -> ${value}`);
    }

    // Object.entries(city)
    //     .forEach((key) => console.log(key.join(' -> ')));
}

solve({name: "Sofia",area: 492,population: 1238438,country: "Bulgaria", postCode: "1000"});
solve({name: "Plovdiv",area: 389,population: 1162358,country: "Bulgaria",postCode: "4000"});