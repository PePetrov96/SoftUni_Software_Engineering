function solve(text) {
    let pattern = /(?=[A-Z])/g;
    let array = text.split(pattern);

    console.log(array.join(', '));
}

solve('SplitMeIfYouCanHaHaYouCantOrYouCan');
solve('HoldTheDoor');
solve('ThisIsSoAnnoyingToDo');