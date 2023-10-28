function solve(char1, char2) {
    console.log(getCharacters(char1, char2).join(' '));

    function getCharacters(char1, char2) {
        let first = char1.charCodeAt(0);
        let second = char2.charCodeAt(0);

        let characters = [];

        if (first < second) {
            for (let i = first+1; i < second; i++) {
                characters.push(String.fromCharCode(i));
            }
        } else {
            for (let i = second+1; i < first; i++) {
                characters.push(String.fromCharCode(i));
            }
        }

        return characters;
    }
}

solve('a','d');
solve('#',':');
solve('C','#');