function addItem() {
    let text = document.getElementById('newItemText').value;
    let value = document.getElementById('newItemValue').value;

    const optionElement = document.createElement('option');
    optionElement.value = value;
    optionElement.text = text;

    document.getElementById('menu').appendChild(optionElement);

    document.getElementById('newItemText').value = '';
    document.getElementById('newItemValue').value = '';
}