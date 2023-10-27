function solve(text, index, count) {
    let word = text.substring(index, index + count);
    console.log(word);
}

solve('ASentence', 1, 8);
solve('SkipWord', 4, 7);