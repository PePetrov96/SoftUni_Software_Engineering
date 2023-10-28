function solve(input) {
    class Hero {
        constructor(name, level, items) {
            this.name = name;
            this.level = level;
            this.items = items || [];
        }
    }

    let heroList = [];

    for (let heroInput of input) {
        let tokens = heroInput.split(' / ');
        let name = tokens.shift();
        let level = tokens.shift();
        let items = [...tokens];

        heroList.push(new Hero(name,level,items));
    }

    heroList.sort((a, b) => a.level - b.level);

    for (let hero of heroList) {
        console.log(`Hero: ${hero.name}`);
        console.log(`level => ${hero.level}`);
        console.log(`items => ${hero.items}`);
    }
}

solve(['Isacc / 25 / Apple, GravityGun','Derek / 12 / BarrelVest, DestructionSword','Hes / 1 / Desolator, Sentinel, Antara']);
solve(['Batman / 2 / Banana, Gun','Superman / 18 / Sword','Poppy / 28 / Sentinel, Antara']);