function solve(word, start, end) {
    let print = "";

    for (let i = start; i <= end; i++) {
        print += word.charAt(i);
    }

    console.log(print.trim());
}

solve('ASentence', 1, 8);
solve('SkipWord', 4, 7 );