function solve(input) {
    let horses = input.shift().split('|');

    function retake(overtaking, overtaken) {
        let overtakingIndex = horses.indexOf(overtaking);
        let overtakenIndex = horses.indexOf(overtaken);

        if (overtakingIndex === undefined || overtakenIndex === undefined) {
            return;
        }

        if (overtakingIndex < overtakenIndex) {
            [horses[overtakingIndex], horses[overtakenIndex]] = [horses[overtakenIndex], horses[overtakingIndex]];
            console.log(`${overtaking} retakes ${overtaken}.`);
        }
    }

    function trouble(horse) {
        let horseIndex = horses.indexOf(horse);

        if (horseIndex > 0) {
            horses.splice(horses.indexOf(horse) - 1, 0, horse);
            horses.splice(horses.lastIndexOf(horse), 1);
            console.log(`Trouble for ${horse} - drops one position.`);
        }
    }

    function rage(horse) {
        let horseIndex = horses.indexOf(horse);
        let horse1AheadIndex = horseIndex+1;
        let horse2AheadIndex = horseIndex+2;

        if (horseIndex === (horses.length-1)) { //if horse is already 1st
            //nothing
        } else if (horseIndex === (horses.length-2)) {//if horse is 2nd
            [horses[horseIndex], horses[horse1AheadIndex]] = [horses[horse1AheadIndex], horses[horseIndex]];
        } else { //if horse is 3rd or more
            [horses[horseIndex], horses[horse1AheadIndex], horses[horse2AheadIndex]] = [horses[horse1AheadIndex], horses[horse2AheadIndex], horses[horseIndex]];
        }

        console.log(`${horse} rages 2 positions ahead.`);
    }

    function miracle() {
        let horse = horses.shift();
        horses.push(horse);
        console.log(`What a miracle - ${horse} becomes first.`);
    }

    for (let command of input) {
        if (command === 'Finish') break;

        let parts = command.split(' ');
        let action = parts[0];

        switch (action) {
            case 'Retake':
                retake(parts[1], parts[2]);
                break;
            case 'Trouble':
                trouble(parts[1]);
                break;
            case 'Rage':
                rage(parts[1]);
                break;
            case 'Miracle':
                miracle();
                break;
        }
    }

    console.log(horses.join('->'));
    console.log(`The winner is: ${horses[horses.length-1]}`);
}