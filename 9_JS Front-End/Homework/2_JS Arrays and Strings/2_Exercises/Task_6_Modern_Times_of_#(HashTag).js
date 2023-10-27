function solve(text) {
    const regex = /#[a-zA-Z]+/g;
    let words = text.match(regex);

    for (const word of words) {
        console.log(word.replace('#',''));
    }
}

solve('Nowadays everyone uses # to tag a #special word in #socialMedia');
solve('The symbol # is known #variously in English-speaking #regions as the #number sign');