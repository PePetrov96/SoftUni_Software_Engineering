window.addEventListener('load', solve);

const genreInput = document.getElementById('genre');
const nameInput = document.getElementById('name');
const authorInput = document.getElementById('author');
const dateInput = document.getElementById('date');

const addBtn = document.getElementById('add-btn');

const allHitsContainer = document.querySelector('.all-hits-container');
const savedContainer = document.querySelector('.saved-container');

const totalLikes = document.querySelector('.likes p');

function solve() {
    addBtn.addEventListener('click', (event) => addNewSong(event));

    function addNewSong(event) {
        if (event) {
            event.preventDefault();
        }

        let genre = genreInput.value;
        let name = nameInput.value;
        let author = authorInput.value;
        let date = dateInput.value;

        if (genre === '' || name === '' || author === '' || date === '' ||
            typeof genreInput.value !== 'string' ||  typeof nameInput.value !== 'string' ||
            typeof authorInput.value !== 'string' ||  typeof dateInput.value !== 'string') {
            return;
        }

        let div = document.createElement('div');
        div.className = 'hits-info';

        let img = document.createElement('img');
        img.src = './static/img/img.png';
        div.appendChild(img);

        let h2Genre = document.createElement('h2');
        h2Genre.innerText = `Genre: ${genre}`;
        div.appendChild(h2Genre);

        let h2Name = document.createElement('h2');
        h2Name.innerText = `Name: ${name}`;
        div.appendChild(h2Name);

        let h2Author = document.createElement('h2');
        h2Author.innerText = `Author: ${author}`;
        div.appendChild(h2Author);

        let h3Date = document.createElement('h3');
        h3Date.innerText = `Date: ${date}`;
        div.appendChild(h3Date);

        let saveBtn = document.createElement('button');
        saveBtn.textContent = 'Save song';
        saveBtn.addEventListener('click', saveSongEventHandler);
        div.appendChild(saveBtn);

        let likeBtn = document.createElement('button');
        likeBtn.textContent = 'Like song';
        likeBtn.addEventListener('click', (event) => likeSongEventHandler(event));

        div.appendChild(likeBtn);

        let deleteBtn = document.createElement('button');
        deleteBtn.textContent = 'Delete';
        deleteBtn.addEventListener('click', deleteSongEventHandler);
        div.appendChild(deleteBtn);

        console.log(div);

        allHitsContainer.appendChild(div);
    }

    function saveSongEventHandler(event) {}
    function likeSongEventHandler(event) {
        let currentLikes = parseInt(totalLikes.textContent.replace('Total Likes: ', ''));
        totalLikes.textContent = `Total Likes: ${currentLikes + 1}`;
        event.target.disabled = true;
    }
    function deleteSongEventHandler(event) {}
}