function solve(number, c1, c2, c3, c4, c5) {
    let input = [c1, c2, c3, c4, c5];

    for (let i = 0; i < input.length; i++) {
        switch (input[i]) {
            case 'chop': number /= 2;
                break;
            case 'dice': number = Math.sqrt(number);
                break
            case 'spice': number += 1;
                break;
            case 'bake': number *= 3;
                break
            case 'fillet': number = (number * 0.8);
                break
        }
        console.log(number);
    }
}

solve('32', 'chop', 'chop', 'chop', 'chop', 'chop');
solve('9', 'dice', 'spice', 'chop', 'bake', 'fillet');