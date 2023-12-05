const BASE_URL = 'http://localhost:3030/jsonstore/advanced/articles';

const container = document.getElementById('main');

async function solution() {
    try {
        const response = await fetch(`${BASE_URL}/list`);
        const data = await response.json();

        for (const article of data) {
            const articleElement = await createArticle(article); // Await the creation of the article
            container.appendChild(articleElement);
        }
    } catch (error) {
        console.error('Error: ', error);
    }
}

async function createArticle(article) {
    let accordion = document.createElement('div');
    accordion.className = 'accordion';

    let head = document.createElement('div');
    head.className = 'head';

    let span = document.createElement('span');
    span.textContent = `${article.title}`;

    let button = document.createElement('button');
    button.className = 'button';
    button.id = `${article._id}`;
    button.textContent = 'MORE';
    button.addEventListener('click', () => {
        showMoreButton(button);
    });

    head.appendChild(span);
    head.appendChild(button);

    let extra = document.createElement('div');
    extra.className = 'extra';

    let p = document.createElement('p');
    p.textContent = await getDescription(article.title);

    extra.appendChild(p);

    accordion.appendChild(head);
    accordion.appendChild(extra);

    return accordion;
}

function showMoreButton(button) {
    let hiddenFields = button.parentElement.parentElement.querySelector('.extra');

    if (button.textContent === 'MORE') {
        hiddenFields.style.display = 'block';
        button.textContent = 'LESS';
    } else if (button.textContent === 'LESS') {
        hiddenFields.style.display = 'none';
        button.textContent = 'MORE';
    }
}

function getDescription(article) {
    return getIdByLocation(article).then(id =>
    fetch(`${BASE_URL}/details/${id}`))
        .then(res => res.json())
        .then(data => {
            return data.content;
        })
        .catch(error => {
            console.error('Error:', error);
            throw error;
        });

}

function getIdByLocation(task) {
    return fetch(BASE_URL + '/details')
        .then(res => res.json())
        .then(res => Object.entries(res).find(e => e[1].title === task)[1]._id);
}

window.onload = solution();