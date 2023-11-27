function focused() {
    const inputs = document.querySelectorAll('input[type="text"]');
    const inputsLength = inputs.length;

    for (let i = 0; i < inputsLength; i++) {
        inputs[i].addEventListener('focus', function (e) {
            e.target.parentElement.classList.add("focused");
        });

        inputs[i].addEventListener('blur', function (e) {
            e.target.parentElement.classList.remove("focused");
        });
    }
}