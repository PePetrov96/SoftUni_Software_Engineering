function solve() {
    let textarea = document.querySelectorAll('textarea'); // Get all Text areas
    let tbody = document.querySelector('tbody'); // Get the body (with all the rows of the table)
    let buttons = document.querySelectorAll('button'); // Get all buttons

    for (const button of buttons) { // For each button, add an event listener
        button.addEventListener('click', execute);
    }
    function execute(button) {
        if (button.target.textContent === 'Generate') { // if the button is "Generate" add this event listener
            let input = JSON.parse(textarea[0].value); // Get the input and parse to a JSON array

            for (const furniture of input) { // For each element of the array - add it as an item
                tbody.innerHTML += `<tr>
                                        <td><img src=${furniture.img}></td>
                                        <td><p>${furniture.name}</p></td>
                                        <td><p>${furniture.price}</p></td>
                                        <td><p>${furniture.decFactor}</p></td>
                                        <td><input type="checkbox"/></td>
                                    </tr>`;
            }

            textarea[0].value = ''; // clear the text area

        } else { // if the button is "Buy" add this event listener
            let furnitureNames = [];
            let totalPrice = 0;
            let totalDecFactor = 0;

            let rows = document.querySelectorAll('input:checked'); // Get all the rows with >CHECKED< checkboxes (this actually only gets the checked checkbox's field

            for (const row of rows) { // For each checked checkbox, add it to the calculation
                let parentRow = row.parentNode.parentNode; // get the whole row (furniture) of the checked checkbox

                furnitureNames.push(parentRow.children[1].textContent);
                totalPrice += Number(parentRow.children[2].textContent);
                totalDecFactor += Number(parentRow.children[3].textContent);
            }

            if (textarea[1].textContent) { // If there is already text in the textarea - delete it
                textarea[1].textContent = '';
            }

            textarea[1].textContent += `Bought furniture: ${furnitureNames.join(', ')}\n`;
            textarea[1].textContent += `Total price: ${totalPrice.toFixed(2)}\n`;
            textarea[1].textContent += `Average decoration factor: ${totalDecFactor / furnitureNames.length}`;
        }
    }
}