function solve(inputArray) {
    function createRegister(input) {
        let map = new Map();

        for (const line of input) {
            let tokens = line.split(/,\s*/);
            let studentName = tokens[0].split(': ')[1];
            let grade = Number(tokens[1].split(': ')[1]) + 1;
            let studentScore = Number(tokens[2].split(': ')[1]);

            if (studentScore < 3.00) {
                continue;
            }

            if (map.has(grade)) {
                let currentNames = map.get(grade).studentNames;
                currentNames.push(studentName);

                let currentAverageScore = map.get(grade).averageScore;
                currentAverageScore.push(studentScore);
            } else {
                map.set(grade, {studentNames: [studentName], averageScore: [studentScore]});
            }
        }
        return map;
    }

    let register = createRegister(inputArray);

    function updateRegister(register) {
        let map = new Map();

        register.forEach((value, key) => {
            let total = 0;
            value.averageScore.forEach(value => total += value);
            let averageScore = total / value.averageScore.length;

            let names = value.studentNames.join(', ');

            map.set(key, {score: averageScore.toFixed(2), names: names});
        })

        return map;
    }

    let updatedRegister = updateRegister(register);
    function sortAndPrint(updatedRegister) {
        let sortedRegister = new Map(
            Array.from(updatedRegister)
                .sort((a, b) => a[0] - b[0]));

        sortedRegister.forEach((value,key) => {
            console.log(`${key} Grade`);
            console.log(`List of students: ${value.names}`);
            console.log(`Average annual score from last year: ${value.score}`);
            console.log();
        });
    }

    sortAndPrint(updatedRegister);

}

solve(["Student name: Mark, Grade: 8, Graduated with an average score: 4.75",
    "Student name: Ethan, Grade: 9,Graduated with an average score: 5.66",
    "Student name: George, Grade: 8,Graduated with an average score: 2.83",
    "Student name: Steven, Grade: 10,Graduated with an average score: 4.20",
    "Student name: Joey, Grade: 9,Graduated with an average score: 4.90",
    "Student name: Angus, Grade: 11,Graduated with an average score: 2.90",
    "Student name: Bob, Grade: 11,Graduated with an average score: 5.15",
    "Student name: Daryl, Grade: 8,Graduated with an average score: 5.95",
    "Student name: Bill, Grade: 9,Graduated with an average score: 6.00",
    "Student name: Philip, Grade: 10,Graduated with an average score: 5.05",
    "Student name: Peter, Grade: 11,Graduated with an average score: 4.88",
    "Student name: Gavin, Grade: 10,Graduated with an average score: 4.00"]);

// solve(['Student name: George, Grade: 5, Graduated with an average score: 2.75',
//     'Student name: Alex, Grade: 9, Graduated with an average score: 3.66',
//     'Student name: Peter, Grade: 8, Graduated with an average score: 2.83',
//     'Student name: Boby, Grade: 5, Graduated with an average score: 4.20',
//     'Student name: John, Grade: 9, Graduated with an average score: 2.90',
//     'Student name: Steven, Grade: 2, Graduated with an average score: 4.90',
//     'Student name: Darsy, Grade: 1, Graduated with an average score: 5.15' ]);