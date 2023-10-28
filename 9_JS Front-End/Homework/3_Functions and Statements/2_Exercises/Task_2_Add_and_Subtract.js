function solve(n1, n2, n3) {
    console.log(subtract(n1, n2, n3));
    function sum(n1, n2) {
        return n1 + n2;
    }

    function subtract(n1, n2, n3) {
        return sum(n1, n2) - n3;
    }
}

solve(23,6,10);
solve(1,17,30);
solve(42,58,100);