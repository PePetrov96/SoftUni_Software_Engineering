function attachEventsListeners() {
    const buttons = document.querySelectorAll('input[type="button"]');

    for (const button of buttons) {
        button.addEventListener('click', () => {
            // Get the input field associated with the clicked button
            const inputField = button.previousElementSibling;
            const inputValue = parseFloat(inputField.value);

            switch (button.id) {
                case 'daysBtn':
                    document.getElementById('hours').value = inputValue * 24;
                    document.getElementById('minutes').value = inputValue * 24 * 60;
                    document.getElementById('seconds').value = inputValue * 24 * 60 * 60;
                    break;
                case 'hoursBtn':
                    document.getElementById('days').value = inputValue / 24;
                    document.getElementById('minutes').value = inputValue * 60;
                    document.getElementById('seconds').value = inputValue * 60 * 60;
                    break;
                case 'minutesBtn':
                    document.getElementById('days').value = inputValue / (24 * 60);
                    document.getElementById('hours').value = inputValue / 60;
                    document.getElementById('seconds').value = inputValue * 60;
                    break;
                case 'secondsBtn':
                    document.getElementById('days').value = inputValue / (24 * 60 * 60);
                    document.getElementById('hours').value = inputValue / (60 * 60);
                    document.getElementById('minutes').value = inputValue / 60;
                    break;
                default:
                    break;
            }
        });
    }
}