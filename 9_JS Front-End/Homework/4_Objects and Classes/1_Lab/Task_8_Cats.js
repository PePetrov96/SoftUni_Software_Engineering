function solve(input) {
    class Cat {
        constructor(name, age) {
            this.name = name;
            this.age = age;
        }
    }

    let cats = [];

    for (let line of input) {
        let tokens = line.split(' ');
        const cat = new Cat(tokens[0], tokens[1]);
        cats.push(cat);
    }

    for (let cat of cats) {
        introduce(cat);
    }

    function introduce(cat) {
        console.log(`${cat.name}, age ${cat.age} says Meow`);
    }
}

solve(['Mellow 2', 'Tom 5']);
solve(['Candy 1', 'Poppy 3', 'Nyx 2']);