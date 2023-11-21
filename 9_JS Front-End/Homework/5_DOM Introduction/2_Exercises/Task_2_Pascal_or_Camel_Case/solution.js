function solve() {
    function transformToCamel(text) {
        let words = text.split(' ');

        return (words.shift().toLowerCase() + updateWord(words));
    }
    function transformToPascal(text) {
        let words = text.split(' ');

        return updateWord(words);
    }

    function updateWord(words) {
        let result = "";

        for (let i = 0; i < words.length; i++) {
            let updatedWord = words[i].charAt(0).toUpperCase() + words[i].slice(1).toLowerCase();
            result += updatedWord + '';
        }

        return result;
    }

    let text = document.getElementById("text").value;
    let format = document.getElementById("naming-convention").value;

    let result = "";

    switch (format) {
        case "Camel Case": result = transformToCamel(text); break;
        case "Pascal Case": result = transformToPascal(text); break;
        default: result = "Error!";
    }

    document.getElementById("result").textContent = result;
}