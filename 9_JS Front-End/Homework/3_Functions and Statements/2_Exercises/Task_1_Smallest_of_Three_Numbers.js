function smallestNumber(n1, n2, n3) {
    if (n1 <= n2 && n1 <= n3) {
        console.log(n1);
    } else if (n2 <= n1 && n2 <= n3) {
        console.log(n2);
    } else {
        console.log(n3);
    }
}

smallestNumber(2, 5, 3);
smallestNumber(600, 342, 123);
smallestNumber(25, 21, 4);
smallestNumber(2, 2, 2);