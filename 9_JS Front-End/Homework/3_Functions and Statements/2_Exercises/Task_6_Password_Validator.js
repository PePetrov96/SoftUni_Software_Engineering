function solve(password) {
    printCheck(password);
    function printCheck(password) {
        if (checkLength(password) && checkLettersAndDigits(password) && checkDigitsCount(password)) {
            console.log(`Password is valid`);
            return;
        }

        if (!checkLength(password)) {
            console.log(`Password must be between 6 and 10 characters`);
        }
        if (!checkLettersAndDigits(password)) {
            console.log(`Password must consist only of letters and digits`);
        }
        if (!checkDigitsCount(password)) {
            console.log(`Password must have at least 2 digits`);
        }
    }

    function checkLength(password) {
        return password.length >= 6 && password.length <= 10;
    }
    function checkLettersAndDigits(password) {
        return /^[A-Za-z0-9]*$/.test(password);
    }
    function checkDigitsCount(password) {
        return /[0-9]{2}/.test(password);
    }
}

solve('logIn');
solve('MyPass123');
solve('Pa$s$s');