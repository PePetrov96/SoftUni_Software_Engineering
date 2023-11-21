function solve() {
    let input = document.getElementById('input').value;

    let text = input.split('.').filter((p) => p.length > 0);

    for (let i = 0; i < text.length; i += 3) {
        let arrayParagraph = [];

        for (let y = 0; y < 3; y++) {
            if (text[i + y]) {
                arrayParagraph.push(text[i + y]);
            }
        }

        let paragraph = arrayParagraph.join('. ') + '.';

        document.getElementById('output').innerHTML += `<p>${paragraph}</p>`;
    }
}