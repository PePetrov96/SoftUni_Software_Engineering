function solve(input) {
    let wordsToCount = {};
    let words = input.shift().split(' ');
    let text = input;

    for (let word of words) {
        wordsToCount[word] = 0;
    }

    for (let word of text) {
        if (wordsToCount.hasOwnProperty(word)) {
            wordsToCount[word]++;
        }
    }

    const sortedWords = Object.entries(wordsToCount)
        .sort((a, b) => b[1] - a[1])
        .reduce((acc, [key, value]) => {
            acc[key] = value;
            return acc;
        }, {});

    for (let word in sortedWords) {
        console.log(`${word} - ${sortedWords[word]}`);
    }
}

solve(['this sentence','In', 'this', 'sentence', 'you', 'have','to', 'count', 'the',
    'occurrences', 'of','the', 'words', 'this', 'and', 'sentence','because', 'this', 'is', 'your', 'task']);

solve(['is the','first', 'sentence', 'Here', 'is','another', 'the', 'And', 'finally', 'the','the', 'sentence']);