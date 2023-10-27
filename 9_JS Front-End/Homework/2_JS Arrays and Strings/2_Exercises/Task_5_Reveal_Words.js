function solve(wordInput, text) {
    let words = wordInput.split(', ');
    let regex;

    for (let word of words) {
        regex = new RegExp('\\' + '*{' + word.length + '}');
        text = text.replace(regex, word);
    }

    console.log(text);
}

solve('great','softuni is ***** place for learning new programming languages');
solve('great, learning', 'softuni is ***** place for ******** new programming languages');