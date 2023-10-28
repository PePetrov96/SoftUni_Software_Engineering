function solve(percent) {
    let filled = percent / 10;

    printFirstRow(filled);
    printSecondRow(10-filled);

    function printFirstRow(n) {
        if (n === 10) {
            console.log(`100% Complete!`);
        } else {
            let loadingBar = ['['];

            for (let i = 1; i <= n; i++) {
                loadingBar.push('%');
            }
            for (let i = n+1; i <= 10; i++) {
                loadingBar.push('.');
            }
            loadingBar.push(']');

            console.log((n*10) + '% ' + loadingBar.join(''));
        }
    }

    function printSecondRow(n) {
        if (n === 0) {
            console.log(`[%%%%%%%%%%]`);
        } else {
            console.log(`Still loading...`);
        }
    }
}

solve(30);
solve(50);
solve(100);