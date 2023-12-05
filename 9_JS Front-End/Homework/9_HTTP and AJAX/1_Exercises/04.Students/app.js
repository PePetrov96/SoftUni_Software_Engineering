const BASE_URL = 'http://localhost:3030/jsonstore/collections/students';

const firstNameInput = document.querySelector('.inputs input[name="firstName"]');
const lastNameInput = document.querySelector('.inputs input[name="lastName"]');
const facultyNumberInput = document.querySelector('.inputs input[name="facultyNumber"]');
const gradeInput = document.querySelector('.inputs input[name="grade"]');

const tableOutput = document.querySelector('#results tbody');

const submitBtn = document.getElementById('submit');

function attachEvents() {
    loadStudents();
    submitBtn.addEventListener('click', submitStudent);
}

function loadStudents() {
    fetch(BASE_URL)
        .then(res => res.json())
        .then((data) => {
            let students = Object.entries(data);

            for (const [key, student] of students) {
                let studentEntry = convertStudent(student);
                if (studentEntry) {
                    tableOutput.innerHTML += studentEntry;
                }
            }
        })
        .catch((error) => {
            console.error('Error: ', error);
            throw error;
        })
}

function submitStudent() {
    let firstName = firstNameInput.value;
    let lastName = lastNameInput.value;
    let facultyNumber = facultyNumberInput.value;
    let grade = gradeInput.value;

    let student = {firstName: firstName, lastName: lastName, facultyNumber: facultyNumber, grade: grade};

    return fetch(BASE_URL, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(student)
    })
        .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok ' + response.statusText);
        }
        return response.json();
    })
        .then(data => {
            console.log('Success:', data);
            tableOutput.innerHTML += convertStudent(data);
        })
        .catch((error) => {
            console.error('Error:', error);
        });
}

function convertStudent(student) {
    let firstName = student.firstName;
    let lastName = student.lastName;
    let facultyNumber = student.facultyNumber;
    let grade = student.grade;

    if (firstName.length === 0 || lastName.length === 0 || facultyNumber.length === 0 || grade.length === 0) {
        return null;
    }

    return `
            <tr>
                <td>${firstName}</td>
                <td>${lastName}</td>
                <td>${facultyNumber}</td>
                <td>${Number(grade).toFixed(2)}</td>
            </tr>`;
}

attachEvents();
// attachEvents();