function solve(input) {
    function fillLeaders(input) {
        let leaders = new Map();
        for (let line of input) {
            if (line.includes('arrives')) { // add a new leader
                let leaderName = line.replace(' arrives', '');
                leaders.set(leaderName, []);

            } else if (line.includes(': ')) { // add an army to a leader
                let firstTokens = line.split(': ');
                let leaderName = firstTokens[0];

                let secondTokens = firstTokens[1].split(', ');
                let armyName = secondTokens[0];
                let armyCount = Number(secondTokens[1]);

                if (leaders.has(leaderName)) {
                    let army = {armyName: armyName, armyCount: armyCount};
                    leaders.get(leaderName).push(army);
                }

            } else if (line.includes('+')) { // add more numbers to the army
                let tokens = line.split(' + ');
                let armyName = tokens[0];
                let armyAddition = Number(tokens[1]);

                let isReady = false

                for (let [leader, armies] of leaders ) {
                    let armyToUpdate = armies.find(army => army.armyName === armyName);

                    if (armyToUpdate) {
                        armyToUpdate.armyCount += armyAddition;
                        break;
                    }
                }

            } else if (line.includes('defeated')) { // delete a leader and his armies
                let leaderName = line.replace(' defeated', '');
                leaders.delete(leaderName);
            }
        }
        return leaders;
    }

    let leaders = fillLeaders(input);

    function sortAndPrint(leaders) {
        const sortedLeaders = new Map([...leaders.entries()].sort((a, b) => {
            const totalArmyCountA = a[1].reduce((total, army) => total + army.armyCount, 0);
            const totalArmyCountB = b[1].reduce((total, army) => total + army.armyCount, 0);

            return totalArmyCountB - totalArmyCountA;
        }));

        sortedLeaders.forEach((armies, leader) => {
            armies.sort((a, b) => b.armyCount - a.armyCount);

            console.log(`${leader}: ${armies.reduce((total, army) => total + army.armyCount, 0)}`);
            armies.forEach(army =>
            console.log(`>>> ${army.armyName} - ${army.armyCount}`));
        });
    }

    sortAndPrint(leaders);
}

solve(['Rick Burr arrives', 'Fergus: Wexamp, 30245', 'Rick Burr: Juard, 50000',
    'Findlay arrives', 'Findlay: Britox, 34540', 'Wexamp + 6000', 'Juard + 1350', 'Britox + 4500',
    'Porter arrives', 'Porter: Legion, 55000', 'Legion + 302', 'Rick Burr defeated', 'Porter: Retix, 3205']);

solve(['Rick Burr arrives', 'Findlay arrives', 'Rick Burr: Juard, 1500', 'Wexamp arrives',
    'Findlay: Wexamp, 34540', 'Wexamp + 340', 'Wexamp: Britox, 1155', 'Wexamp: Juard, 43423']);