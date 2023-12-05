const BASE_URL = 'http://localhost:3030/jsonstore/advanced/profiles';

const container = document.getElementById('main');

const profile = document.getElementById('profile');

const lockBtn = document.querySelector('input[value="lock"]');
const unlockBtn = document.querySelector('input[value="unlock"]');

const usernameField = document.querySelector('input[name="user1Username"]');

const hiddenFields = document.getElementsByClassName('user1Username');

const emailField = document.querySelector('input[name="user1Email"]');
const ageField = document.querySelector('input[name="user1Age"]');


function lockedProfile() {
    loadProfiles();
}

function loadProfiles() {
    fetch(BASE_URL)
        .then(res => {
            if (!res.ok) {
                throw new Error(`HTTP error! status: ${res.status}`);
            }
            return res.json();
        })
        .then((data) => {
            let profiles = Object.entries(data);
            container.innerHTML = '';

            let index = 1;

            for (const [key, profile] of profiles) {
                container.appendChild(createProfile(profile, index++));
            }
        })
        .catch((error) => {
            console.error("Error loading profiles: ", error);
        });
}

function createProfile(user, index) {
    let userOutput = document.createElement('div');
    userOutput.className = "profile";

    let radioName = `user${index}Locked`;

    userOutput.innerHTML = `
        <img src="./iconProfile2.png" class="userIcon" />
        <label>Lock</label>
        <input type="radio" name="${radioName}" value="lock" checked>
        <label>Unlock</label>
        <input type="radio" name="${radioName}" value="unlock"><br>
        <hr>
        <label>Username</label>
        <input type="text" name="user${index}Username" value="${user.username}" disabled readonly />
        <div id="user${index}HiddenFields" class="user1Username" style="display: none">
            <hr>
            <label>Email:</label>
            <input type="email" name="user${index}Email" value="${user.email}" disabled readonly />
            <label>Age:</label>
            <input type="email" name="user${index}Age" value="${user.age}" disabled readonly />
        </div>`;

    let btn = document.createElement('button');
    btn.textContent = 'Show more';
    btn.addEventListener('click', () => showMoreButton(index));
    userOutput.appendChild(btn);

    return userOutput;
}

function showMoreButton(index) {
    let hiddenFields = document.getElementById(`user${index}HiddenFields`);
    let radioUnlock = document.querySelector(`input[name="user${index}Locked"][value="unlock"]`);

    let profileDiv = hiddenFields.closest('.profile');
    let button = profileDiv.querySelector('button');

    if (radioUnlock.checked) {
        if (hiddenFields.style.display === 'block') {
            button.textContent = 'Hide it';
            hiddenFields.style.display = 'none';
        } else {
            button.textContent = 'Show more';
            hiddenFields.style.display = 'block';
        }

    }
}

window.onload = lockedProfile;
