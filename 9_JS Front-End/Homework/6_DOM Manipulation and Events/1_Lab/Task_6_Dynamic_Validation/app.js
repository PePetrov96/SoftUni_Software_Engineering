function validate() {
    const emailInput = document.getElementById('email');

    emailInput.addEventListener('change', function () {
        const emailValue = emailInput.value.trim();
        const emailRegex = /^[a-z]+@[a-z]+\.[a-z]+$/g;

        if (!emailRegex.test(emailValue)) {
            emailInput.classList.add('error');
        } else {
            emailInput.classList.remove('error');
        }
    });
}