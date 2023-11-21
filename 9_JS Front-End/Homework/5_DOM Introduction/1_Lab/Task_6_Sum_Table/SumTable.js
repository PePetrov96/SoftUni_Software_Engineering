function sumTable() {
    let table = document.querySelectorAll("table tr");

    let total = 0;

    for (let i = 1; i < table.length; i++) {
        let columns = table[i].children;

        let cost = columns[columns.length - 1].textContent;

        total += Number(cost);

    }

    document.getElementById("sum").textContent = total.toFixed(2);
}