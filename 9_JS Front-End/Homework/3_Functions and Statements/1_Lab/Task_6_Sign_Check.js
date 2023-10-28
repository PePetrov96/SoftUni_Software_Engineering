function solve(a,b,c) {
    let first = a >= 0;
    let second = b >= 0;
    let third = c >= 0;

    if (!first && !second && !third) {
        console.log('Negative');
    } else if (((!first && (!second || !third))
        || (!second && (!first || !third))
        || (!third && (!first || !second))
        || (first && second && third))) {
        console.log('Positive');
    } else {
        console.log('Negative');
    }
}

solve(5,12,-15);
solve(-6,-12,14);
solve(-1,-2,-3);