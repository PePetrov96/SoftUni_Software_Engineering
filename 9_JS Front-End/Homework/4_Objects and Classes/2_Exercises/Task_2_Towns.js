function solve(input) {
    class Town {
        constructor(town, latitude, longitude) {
            this.town = town;
            this.latitude = latitude;
            this.longitude = longitude;
        }
        toString() {
            return `{ town: '${this.town}', latitude: '${this.latitude}', longitude: '${this.longitude}' }`;
        }
    }
    
    let townsList = [];

    for (let line of input) {
        let tokens = line.split(' | ');
        let town = new Town(tokens[0], Number(tokens[1]).toFixed(2),Number(tokens[2]).toFixed(2));
        townsList.push(town);
    }

    for (let town of townsList) {
        console.log(town.toString());
    }
}

solve(['Sofia | 42.696552 | 23.32601', 'Beijing | 39.913818 | 116.363625']);
solve(['Plovdiv | 136.45 | 812.575']);