function solve(n) {
    printDNAStructure(n);
    function printDNAStructure(length) {
        const sequence = "ATCGTTAGGG"; // A-T (0-1) | C-G (2-3) | T-T (4-5) | A-G (6-7) | G-G (8-9)
        const helix = [];

        let count = 1;
        let element = 0;

        for (let i = 0; i < length; i++) {
            if (count === 5) {
                count = 1;
            }

            if (element === 10) {
                element = 0;
            }

            let row = "";

            if (count === 1) {
                row = `**${sequence[element]}${sequence[(element + 1) % sequence.length]}**`;
            } else if (count === 2) {
                row = `*${sequence[element]}--${sequence[(element + 1) % sequence.length]}*`;
            } else if (count === 3) {
                row = `${sequence[element]}----${sequence[(element + 1) % sequence.length]}`;
            } else if (count === 4) {
                row = `*${sequence[element]}--${sequence[(element + 1) % sequence.length]}*`;
            }

            count++;
            element += 2;

            helix.push(row);
        }

        helix.forEach(row => console.log(row));
    }
}

solve(4);
solve(10);