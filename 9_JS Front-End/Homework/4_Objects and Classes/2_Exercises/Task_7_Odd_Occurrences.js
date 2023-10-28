function solve(input) {
    let words = input.toLowerCase().split(' ');

    let wordCount = {};

    for (let word of words) {
        if (wordCount.hasOwnProperty(word)) {
            wordCount[word]++;
        } else {
            wordCount[word] = 1;
        }
    }

    const filteredWordCount = [];

    for (let word of words) {
        if (wordCount[word] % 2 !== 0 && !filteredWordCount.includes(word)) {
            filteredWordCount.push(word);
        }
    }

    console.log(filteredWordCount.join(' '));
}

solve('Java C# Php PHP Java PhP 3 C# 3 1 5 C#');
solve('Cake IS SWEET is Soft CAKE sweet Food');