function solve(input) {
    let meetings = {};

    for (let element of input) {
        let tokens = element.split(' ');
        let day = tokens[0];
        let person = tokens[1];

        if (meetings.hasOwnProperty(day)) {
            console.log(`Conflict on ${day}!`);
        } else {
            meetings[day] = person;
            console.log(`Scheduled for ${day}`);
        }
    }

    for (let meeting in meetings) {
        console.log(`${meeting} -> ${meetings[meeting]}`);
    }

}

solve(['Monday Peter', 'Wednesday Bill', 'Monday Tim', 'Friday Tim']);
solve(['Friday Bob','Saturday Ted','Monday Bill','Monday John','Wednesday George']);