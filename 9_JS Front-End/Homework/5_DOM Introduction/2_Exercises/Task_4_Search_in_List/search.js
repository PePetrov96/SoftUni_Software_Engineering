function search() {
    let townsList = document.querySelectorAll("#towns li");

    for (const town of townsList) {
        town.style.fontWeight = "normal";
        town.style.textDecoration = "none";
    }

    let userInput = document.getElementById("searchText").value;

    let count = 0;

    for (const town of townsList) {
        if (town.textContent.toLowerCase().includes(userInput.toLowerCase())) {
            town.style.fontWeight = "bold";
            town.style.textDecoration = "underline";
            count++;
        }
    }

    document.getElementById("result").textContent = `${count} matches found`;
    document.getElementById("searchText").value = "";
}