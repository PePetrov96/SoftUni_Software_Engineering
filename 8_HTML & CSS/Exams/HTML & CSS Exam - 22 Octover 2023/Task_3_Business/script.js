window.onscroll = function() {
    var header = document.getElementById('header-container');
    if (window.scrollY > 630) {
        header.classList.add('updated-class');
    } else {
        header.classList.remove('updated-class');
    }
}

function calculateFibonacci(number) {
    if (number <= 1) {
        return number;
    }

    let fibonacciPrevious = 0;
    let fibonacciCurrent = 1;

    // Calculate Fibonacci sequence up to the nth position
    for (let i = 2; i <= number; i++) {
        const temporary = fibonacciCurrent;
        fibonacciCurrent = fibonacciPrevious + fibonacciCurrent;
        fibonacciPrevious = temporary;
    }

    return fibonacciCurrent;
}