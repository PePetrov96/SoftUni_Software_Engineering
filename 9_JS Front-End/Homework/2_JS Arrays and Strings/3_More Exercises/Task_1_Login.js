function solve(input) {
    let username = input[0];
    let password = username.split('').reverse().join('');

    for (let i = 1; i < input.length; i++) {
        if (input[i] === password) {
            console.log(`User ${username} logged in.`);
            break;
        } else if (i <= 3) {
            console.log(`Incorrect password. Try again.`);
        }

        if (i === 4) {
            console.log(`User ${username} blocked!`);
            break;
        }
    }
}

solve(['Acer','login','go','let me in','recA']);
solve(['momo','omom']);
solve(['sunny','rainy','cloudy','sunny','not sunny']);