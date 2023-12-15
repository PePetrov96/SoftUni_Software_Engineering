function solve(input) {
    class Details {
        constructor(composer, key) {
            this.composer = composer;
            this.key = key;
        }
    }

    function fillMap() {
        let n = input.shift();

        for (let i = 0; i < n; i++) {
            let tokens = input.shift().split('|');

            let piece = tokens[0];
            let composer = tokens[1];
            let key = tokens[2];

            piecesMap.set(piece, new Details(composer, key));
        }
    }
    
    function add(piece, composer, key) {
        if (piecesMap.has(piece)) {
            console.log(`${piece} is already in the collection!`);
        } else {
            piecesMap.set(piece, new Details(composer, key));
            console.log(`${piece} by ${composer} in ${key} added to the collection!`);
        }
    }

    function remove(piece) {
        if (piecesMap.has(piece)) {
            piecesMap.delete(piece);
            console.log(`Successfully removed ${piece}!`);
        } else {
            console.log(`Invalid operation! ${piece} does not exist in the collection.`);
        }
    }

    function changeKey(piece, newKey) {
        if (piecesMap.has(piece)) {
            piecesMap.get(piece).key = newKey;
            console.log(`Changed the key of ${piece} to ${newKey}!`);
        } else {
            console.log(`Invalid operation! ${piece} does not exist in the collection.`);
        }
    }
    function runCommands() {
        let line = input.shift();

        while (line !== 'Stop') {
            let tokens = line.split('|');
            let command = tokens.shift();

            switch (command) {
                case 'Add': add(tokens[0], tokens[1], tokens[2]);
                    break;
                case 'Remove': remove(tokens[0]);
                    break;
                case 'ChangeKey': changeKey(tokens[0], tokens[1]);
                    break;
            }

            line = input.shift();
        }
    }


    let piecesMap = new Map();
    fillMap();

    runCommands();

    piecesMap.forEach((value, key) => {
        console.log(`${key} -> Composer: ${value.composer}, Key: ${value.key}`);
    });
}

solve(['3',
        'Fur Elise|Beethoven|A Minor',
        'Moonlight Sonata|Beethoven|C# Minor',
        'Clair de Lune|Debussy|C# Minor',
        'Add|Sonata No.2|Chopin|B Minor',
        'Add|Hungarian Rhapsody No.2|Liszt|C# Minor',
        'Add|Fur Elise|Beethoven|C# Minor',
        'Remove|Clair de Lune',
        'ChangeKey|Moonlight Sonata|C# Major',
        'Stop']);

// solve(['4',
//         'Eine kleine Nachtmusik|Mozart|G Major',
//         'La Campanella|Liszt|G# Minor',
//         'The Marriage of Figaro|Mozart|G Major',
//         'Hungarian Dance No.5|Brahms|G Minor',
//         'Add|Spring|Vivaldi|E Major',
//         'Remove|The Marriage of Figaro',
//         'Remove|Turkish March',
//         'ChangeKey|Spring|C Major',
//         'Add|Nocturne|Chopin|C# Minor',
//         'Stop']);