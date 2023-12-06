const BASE_URL = 'http://localhost:3030/users/register';

const registerBtn = document.querySelector("#register button");

const homeBtn = document.querySelector('#home');
const logoutBtn = document.querySelector('#logout');

const emailInput = document.querySelector('input[name="email"]');
const passwordInput = document.querySelector('input[name="password"]');
const rePasswordInput = document.querySelector('input[name="rePass"]');

const loginErrorMsg = document.querySelector(".notification");

function register() {
    setFields();

    registerBtn.addEventListener("click", async function (e)  {
        e.preventDefault();
        const email = emailInput.value;
        const password = passwordInput.value;
        const rePassword = rePasswordInput.value;

        const emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;

        if (emailRegex.test(email)) {
            if (password === rePassword) {
                await registerUser(email, password);
                location.href = 'http://localhost:3000/src/login.html';
            } else {
                loginErrorMsg.textContent = "Passwords do not match!";
                clearFields();
            }
        } else {
            loginErrorMsg.textContent = "Invalid email!";
            clearFields();
        }
    });
}

async function registerUser(email, password) {
    try {
        const response = await fetch(BASE_URL,
            {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                email: email,
                password: password
            })
        }
        );

        if (!response.ok) {
            throw new Error('Registration failed');
        }

        // Handle success, then redirect
        location.href = 'http://localhost:3000/src/login.html';
    } catch (error) {
        console.error('Error:', error);
        loginErrorMsg.textContent = "Registration failed!";
        clearFields();
    }
}

function clearFields(){
    emailInput.value = '';
    passwordInput.value = '';
    rePasswordInput.value = '';
}

function setFields() {
    homeBtn.addEventListener('click', function(event) {
        event.preventDefault();
    });

    logoutBtn.style.display = 'none';

    homeBtn.className = '';
    document.querySelector('#register').className = 'active';
}

window.onload = register;