const LIST_URL = 'http://localhost:3030/jsonstore/advanced/articles/list';
const DETAILS_URL = 'http://localhost:3030/jsonstore/advanced/articles/details';

const main = document.getElementById('main');
function solution() {
    loadEventBoard();
}

async function loadEventBoard() {
    try {
        let res = await fetch(LIST_URL);
        let data = await res.json();

        let entries = Object.entries(data);

        for (const [key, entry] of entries) {
            let mainDiv = document.createElement('div');
            mainDiv.className = 'accordion';

            let innerDiv1 = document.createElement('div');
            innerDiv1.className = 'head';

            let span = document.createElement('span');
            span.innerText = `${entry.title}`;
            innerDiv1.appendChild(span);

            let button = document.createElement('button');
            button.innerText = 'More';
            button.className = 'button';
            button.id = `${entry._id}`;
            button.addEventListener('click', event => showMoreBtnEventHandler(event));
            innerDiv1.appendChild(button);

            let innerDiv2 = document.createElement('div');
            innerDiv2.className = 'extra';

            let p = document.createElement('p');
            // p.textContent = await appendDetails(entry._id);

            innerDiv2.appendChild(p);

            mainDiv.appendChild(innerDiv1);
            mainDiv.appendChild(innerDiv2);

            main.appendChild(mainDiv);
        }
        await appendDetails();
    } catch (error) {
        console.error('Error:', error);
        throw error;
    }
}

async function appendDetails() {
        try {
            let res = await fetch(DETAILS_URL);
            let data = await res.json();

            let entries = Object.entries(data);
            let buttons = document.querySelectorAll('.button');

            for (const button of buttons) {
                let buttonId = button.id;
                let hiddenText = button.parentElement.parentElement.querySelector('.extra p');

                for (const [key, entry] of entries) {
                    if (entry._id === buttonId) {
                        hiddenText.textContent = entry.content;
                    }
                }
            }

        } catch (error) {
            console.error('Error:', error);
            throw error;
        }
}

async function showMoreBtnEventHandler(event) {
    let hiddenFields = event.target.parentElement.parentElement.querySelector('.extra');
    let button = event.target;
    let text = button.innerText;

    switch (text) {
        case 'MORE':
            hiddenFields.style.display = 'block';
            button.innerText = 'LESS';
            break;
        case 'LESS':
            hiddenFields.style.display = 'none';
            button.innerText = 'MORE';
            break;
    }
}

solution();