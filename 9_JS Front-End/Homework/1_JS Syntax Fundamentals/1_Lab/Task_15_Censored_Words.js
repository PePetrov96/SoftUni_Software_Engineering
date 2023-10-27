function solve(text, word) {
    let censored = text.replace(word, repeat(word));

    while (censored.includes(word)) {
        censored = text.replace(word, repeat(word));
    }
    function repeat(word) {
        let finalWord = "";

        for (let i = 0; i < word.length; i++) {
            finalWord += "*"
        }

        return finalWord;
    }

    console.log(censored);
}

solve('A small sentence with some words', 'small');
solve('Find the hidden word', 'hidden');