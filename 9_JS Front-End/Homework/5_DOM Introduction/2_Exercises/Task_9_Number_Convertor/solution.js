function solve() {
    function convertToBinary(number) {
        if (number === 0) {
            return '0';
        }

        let binary = '';
        while (number > 0) {
            binary = (number % 2) + binary;
            number = Math.floor(number / 2);
        }

        return binary;
    }

    function convertToHexadecimal(number) {
        if (number === 0) {
            return '0';
        }

        const hexChars = '0123456789ABCDEF';
        let hexadecimal = '';

        while (number > 0) {
            hexadecimal = hexChars[number % 16] + hexadecimal;
            number = Math.floor(number / 16);
        }

        return hexadecimal;
    }
    function addDropDownOptions() {
        const selectMenuTo = document.getElementById('selectMenuTo');

        const valuesToAdd = [
            { value: 'binary', label: 'Binary' },
            { value: 'hexadecimal', label: 'Hexadecimal' }
        ];

        for (const option of valuesToAdd) {
            const newOption = document.createElement('option');
            newOption.value = option.value;
            newOption.textContent = option.label;
            selectMenuTo.add(newOption);
        }
    }

    function convertAndDisplay() {
        const input = document.getElementById('input').value;
        const selectMenuTo = document.getElementById('selectMenuTo');
        const resultOutput = document.getElementById('result');

        const selectedOption = selectMenuTo.value;
        let result = '';

        if (selectedOption === 'binary') {
            result = convertToBinary(Number(input));
        } else if (selectedOption === 'hexadecimal') {
            result = convertToHexadecimal(Number(input));
        }

        resultOutput.value = result;
    }

    function attachConversionHandler() {
        const convertButton = document.querySelector('button');
        convertButton.addEventListener('click', convertAndDisplay);
    }

    addDropDownOptions();

    attachConversionHandler();
}