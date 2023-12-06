const BASE_URL = 'http://localhost:3030/users/login';

const loginBtn = document.querySelector("#login button");

const homeBtn = document.querySelector('#home');
const logoutBtn = document.querySelector('#logout');

const emailInput = document.querySelector('input[name="email"]');
const passwordInput = document.querySelector('input[name="password"]');

const loginErrorMsg = document.querySelector(".notification");

function login() {
    setFields();

    loginBtn.addEventListener("click", async function (e)  {
        e.preventDefault();
        const email = emailInput.value;
        const password = passwordInput.value;

        const emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;


        if (emailRegex.test(email)) {
            if (await validateUser(email, password)) {
                location.href = `http://localhost:3000/src/index.html?email=${encodeURIComponent(email)}`;
            } else {
                loginErrorMsg.textContent = "User with those credentials does not exist!";
                clearFields();
            }
        } else {
            loginErrorMsg.textContent = "Invalid email!";
            clearFields();
        }
    });
}


function validateUser(email, password) {
    return fetch(BASE_URL, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            email: email,
            password: password
        })
    })
        .then(res => {
            if (!res.ok) {
                throw new Error(`Login failed: ${res.status} ${res.statusText}`);
            }
            return res.json();
        })
        .then(data => {
            // Check for the appropriate field in the response
            sessionStorage.setItem('token', data.accessToken);
            return data.email;
        })
        .catch(error => {
            console.error('Error:', error);
            return false;
        });
}

function clearFields(){
    emailInput.value = '';
    passwordInput.value = '';
}

function setFields() {
    homeBtn.addEventListener('click', function(event) {
        event.preventDefault();
    });

    logoutBtn.style.display = 'none';

    homeBtn.className = '';
    document.querySelector('#login').className = 'active';
}

window.onload = login;