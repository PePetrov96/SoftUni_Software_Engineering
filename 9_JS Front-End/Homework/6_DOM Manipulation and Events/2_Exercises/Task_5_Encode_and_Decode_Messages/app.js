function encodeAndDecodeMessages() {
    function encodeText(text) {
        let convertedText = '';
        for (let i = 0; i < text.length; i++) {
            const charCode = text.charCodeAt(i) + 1;
            convertedText += String.fromCharCode(charCode);
        }
        return convertedText;
    }
    function decodeText(text) {
        let convertedText = '';
        for (let i = 0; i < text.length; i++) {
            const charCode = text.charCodeAt(i) - 1;
            convertedText += String.fromCharCode(charCode);
        }
        return convertedText;
    }

    let encodeButton = document.querySelector('#main div:nth-child(1) button');
    let decodeButton = document.querySelector('#main div:nth-of-type(2) button');
    const senderTextarea = document.querySelector('#main div:nth-child(1) textarea');
    const receiverTextarea = document.querySelector('#main div:nth-of-type(2) textarea');

    encodeButton.addEventListener('click', () => {
        // send message and encode it
        receiverTextarea.value = encodeText(senderTextarea.value);

        // clear sender text area
        senderTextarea.value = '';
    });

    decodeButton.addEventListener('click', () => {
        // decode message
        receiverTextarea.value = decodeText(receiverTextarea.value);
    });
}