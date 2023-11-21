function solve(input) {
    function fillBookshelves(input) {
        let bookshelves = new Map();
        for (const line of input) {

            if (/^\d/.test(line)) { // is a bookshelf
                let tokens = line.split(' -> ');
                let bookshelfNumber = tokens[0];
                let genre = tokens[1];

                let hasBookshelf = false;

                for (const [key, value] of bookshelves) {
                    if (key.number === bookshelfNumber) {
                        hasBookshelf = true;
                    }
                }

                if (!hasBookshelf) {
                    bookshelves.set({number: bookshelfNumber, genre: genre}, []);
                }

            } else { // is a book
                let tokens = line.split(', ');
                let bookName = tokens[0];
                let genre = tokens[1];

                for (let [key, value] of bookshelves) {
                    if (key.genre === genre) {
                        value.push(bookName);
                        break;
                    }
                }
            }


        }
        return bookshelves;
    }

    let bookshelves = fillBookshelves(input);

    function sortAndPrint(bookshelves) {
        const sortedBookshelves = new Map([...bookshelves.entries()].sort((a,b) => {
            let countA = a[1].length;
            let countB = b[1].length;

            return countB - countA;
        }));

        sortedBookshelves.forEach((value, key) => {
            console.log(`${key.number} ${key.genre}: ${value.length}`);

            value.forEach(book => console.log(`--> ${book}`));
        });
    }

    sortAndPrint(bookshelves);
}

solve(['1 -> history', '1 -> action', 'Death in Time: Criss Bell, mystery', '2 -> mystery', '3 -> sci-fi',
    'Child of Silver: Bruce Rich, mystery', 'Hurting Secrets: Dustin Bolt, action',
    'Future of Dawn: Aiden Rose, sci-fi', 'Lions and Rats: Gabe Roads, history', '2 -> romance',
    'Effect of the Void: Shay B, romance', 'Losing Dreams: Gail Starr, sci-fi', 'Name of Earth: Jo Bell, sci-fi',
    'Pilots of Stone: Brook Jay, history']);

solve(['1 -> mystery', '2 -> sci-fi', 'Child of Silver: Bruce Rich, mystery',
    'Lions and Rats: Gabe Roads, history', 'Effect of the Void: Shay B, romance',
    'Losing Dreams: Gail Starr, sci-fi', 'Name of Earth: Jo Bell, sci-fi']);