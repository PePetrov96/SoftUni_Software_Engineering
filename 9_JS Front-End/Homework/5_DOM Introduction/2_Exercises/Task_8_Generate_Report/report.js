function generateReport() {
    const checkboxes = document.querySelectorAll('th input[type="checkbox"]');
    const tableRows = document.querySelectorAll('tbody tr');
    const data = [];

    for (let i = 0; i < tableRows.length; i++) {
        const row = tableRows[i];
        const rowData = {};

        for (let j = 0; j < checkboxes.length; j++) {
            const checkbox = checkboxes[j];

            if (checkbox.checked) {
                const headerText = checkbox.parentElement.textContent.trim();
                const cellText = row.querySelectorAll('td')[j].textContent.trim();
                rowData[headerText.toLowerCase()] = cellText;
            }
        }

        if (Object.keys(rowData).length > 0) {
            data.push(rowData);
        }
    }

    document.getElementById('output').value = JSON.stringify(data, null, 2);
}
