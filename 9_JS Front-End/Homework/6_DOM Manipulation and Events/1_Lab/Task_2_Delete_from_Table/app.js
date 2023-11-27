function deleteByEmail() {
    let emailInput = document.getElementsByName('email')[0].value;

    let emailsList = document.querySelectorAll('#customers tr td:nth-child(2)');

    for (let email of emailsList) {
        if (email.textContent === emailInput) {
            let row = email.parentNode;
            row.parentNode.removeChild(row);

            document.getElementById('result').textContent = "Deleted.";
            return;
        }
    }
    document.getElementById('result').textContent = "Not found.";
}