const BASE_URL = 'http://localhost:3030/jsonstore/messenger';

const sendBtn = document.getElementById('submit');
const refreshBtn = document.getElementById('refresh');

const nameInput = document.querySelector('input[name="author"]');
const messageInput = document.querySelector('input[name="content"]');

const textOutput = document.getElementById('messages');

function attachEvents() {
    sendBtn.addEventListener('click', sendMessage);
    refreshBtn.addEventListener('click', refreshMessages);
}

function sendMessage() {
    let authorName = nameInput.value;
    let msgText = messageInput.value;

    let message = {author: authorName,content: msgText,};

    return fetch(BASE_URL, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(message)
    })
        .then(response => response.json())
        .then(data => console.log('Success:', data))
        .catch((error) => {
            console.error('Error:', error);
            throw error;
        });
}

function refreshMessages() {
    textOutput.textContent = '';
    return fetch(BASE_URL)
        .then(res => res.json())
        .then((data) => {
            let messages = Object.entries(data);

            for (const [key, message] of messages) {
                textOutput.textContent += `${message.author}: ${message.content}\n`;
            }
            textOutput.textContent = textOutput.textContent.trimEnd();
        })
        .catch((error) => {
           console.error("Error: ", error);
           throw error;
        });
}

attachEvents();