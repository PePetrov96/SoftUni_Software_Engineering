const LOGOUT_URL = 'http://localhost:3030/users/logout';
const CATCH_URL = 'http://localhost:3030/data/catches';

const logoutBtn = document.querySelector('#logout');
const loginBtn = document.querySelector('#login');
const registerBtn = document.querySelector('#register');

const loadCatches = document.querySelector('.load');
const addCatch = document.querySelector('.add');

const catchesContainer = document.getElementById('catches');
function solve() {
    setPage();
    logoutBtn.addEventListener('click', logout);
    loadCatches.addEventListener('click', loadCatchesListener);
    addCatch.addEventListener('click', addCatchListener)
}

function loadCatchesListener() {
    fetch(CATCH_URL)
        .then(res => res.json())
        .then(data => {
            let catches = Object.entries(data);

            catchesContainer.innerHTML = '';

            for (const [key, catch1] of catches) {
                catchesContainer.appendChild(createCatch(key, catch1));
            }
        })
        .catch(error => {
            console.error('Error: ',error);
            throw error;
        })
}

function createCatch(key, catchInput) {
    let catch1 = document.createElement('div');
    catch1.className = 'catch';

    catch1.innerHTML = `<label>Angler</label>
                        <input type="text" class="angler" value="${catchInput.angler}">
                        
                        <label>Weight</label>
                        <input type="text" class="weight" value="${catchInput.weight}">
                        
                        <label>Species</label>
                        <input type="text" class="species" value="${catchInput.species}">
                        
                        <label>Location</label>
                        <input type="text" class="location" value="${catchInput.location}">
                        
                        <label>Bait</label>
                        <input type="text" class="bait" value="${catchInput.bait}">
                        
                        <label>Capture Time</label>
                        <input type="number" class="captureTime" value="${catchInput.captureTime}">`;

    let updateBtn = document.createElement('button');
    updateBtn.className = 'update';
    updateBtn.textContent = 'Update';
    updateBtn.setAttribute('data-id', `${catchInput._id}`);
    updateBtn.addEventListener('click', updateBtnListener);

    let deleteBtn = document.createElement('button');
    deleteBtn.className = 'delete';
    deleteBtn.textContent = 'Delete';
    deleteBtn.setAttribute('data-id', `${catchInput._id}`);
    deleteBtn.addEventListener('click', deleteBtnListener);

    catch1.appendChild(updateBtn);
    catch1.appendChild(deleteBtn);

    return catch1;
}
function addCatchListener() {}

async function updateBtnListener(event) {
    const catchId = event.target.getAttribute('data-id');
    const catchDiv = event.target.parentElement;
    const updatedCatch = {
        angler: catchDiv.querySelector('.angler').value,
        weight: catchDiv.querySelector('.weight').value,
        species: catchDiv.querySelector('.species').value,
        location: catchDiv.querySelector('.location').value,
        bait: catchDiv.querySelector('.bait').value,
        captureTime: catchDiv.querySelector('.captureTime').value
    };

    try {
        const token = sessionStorage.getItem('token');
        if (!token) {
            throw new Error("User is not logged in.");
        }

        const response = await fetch(`${CATCH_URL}/${catchId}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
                'X-Authorization': token
            },
            body: JSON.stringify(updatedCatch)
        });

        if (!response.ok) {
            throw new Error('Failed to update catch');
        }
        loadCatchesListener();
    } catch (error) {
        console.error('Error:', error);
    }
}

async function deleteBtnListener(event) {
    const catchId = event.target.getAttribute('data-id');

    try {
        const token = sessionStorage.getItem('token');
        if (!token) {
            throw new Error("User is not logged in.");
        }

        const response = await fetch(`${CATCH_URL}/${catchId}`, {
            method: 'DELETE',
            headers: {
                'X-Authorization': token
            }
        });

        if (!response.ok) {
            throw new Error('Failed to delete catch');
        }
        loadCatchesListener();
    } catch (error) {
        console.error('Error:', error);
    }
}




function setPage() {
    const urlParams = new URLSearchParams(window.location.search);
    const email = urlParams.get('email');

    if (email) {
        document.querySelector('.email span').textContent = email;
        loginBtn.style.display = 'none';
        registerBtn.style.display = 'none';
    } else {
        logoutBtn.style.display = 'none';
        loginBtn.style.display = 'block';
    }
}
async function logout() {
    try {
        // Retrieve the stored token
        const token = sessionStorage.getItem('token');

        if (!token) {
            throw new Error("No user is currently logged in.");
        }

        const response = await fetch(LOGOUT_URL, {
            method: 'GET',
            headers: {
                // Use the token directly without Bearer if the server does not expect it
                'X-Authorization': token
            }
        });

        if (response.status === 204) { // Check for no content status
            sessionStorage.clear();
            location.href = 'http://localhost:3000';
        } else {
            throw new Error('Logout failed with status: ' + response.status);
        }
    } catch (error) {
        console.error('Error:', error);
    }
}

window.onload = solve;