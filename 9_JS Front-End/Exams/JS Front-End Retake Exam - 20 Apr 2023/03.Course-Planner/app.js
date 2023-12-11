const BASE_URL = 'http://localhost:3030/jsonstore/tasks';

const endpoints = {
    update: (id) => `${BASE_URL}/${id}`,
    delete: (id) => `${BASE_URL}/${id}`
}

let currentTaskId = '';

const titleInput = document.getElementById('course-name');
const typeInput = document.getElementById('course-type');
const descriptionInput = document.getElementById('description');
const teacherInput = document.getElementById('teacher-name');

const loadCoursesBtn = document.getElementById('load-course');
const addCourseBtn = document.getElementById('add-course');
const editCourseBtn = document.getElementById('edit-course');

const courseList = document.getElementById('list');

function attachEvents() {
    loadCoursesBtn.addEventListener('click', loadCoursesEventHandler);
    addCourseBtn.addEventListener('click', addCourseEventHandler);
    editCourseBtn.addEventListener('click', editCourseEventHandler);
}

async function editCourseEventHandler() {
    if (currentTaskId === '') return;

    const course = {
        title: titleInput.value,
        type: typeInput.value,
        description: descriptionInput.value,
        teacher: teacherInput.value
    };

    await fetch(endpoints.update(currentTaskId), {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(course)
    });

    clearFields();
    await loadCoursesEventHandler();
    enableAddBtn();
}

async function addCourseEventHandler() {
    let title = titleInput.value;
    let type = typeInput.value;
    let description = descriptionInput.value;
    let teacher = teacherInput.value;

    // if (title === '' || type === '' || description === '' || teacher === '') {
    //     return;
    // }

    await fetch(BASE_URL, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            title: title,
            type: type,
            description: description,
            teacher: teacher
        })
    });

    clearFields();
    await loadCoursesEventHandler();
}

async function loadCoursesEventHandler() {
    clearList();

    try {
        let res = await fetch(BASE_URL);
        let data = await res.json();

        let entries = Object.entries(data);

        for (const [key, course] of entries) {
            let container = document.createElement('div');
            container.className = 'container';

            container.innerHTML = `
                        <h2>${course.title}</h2>
                        <h3>${course.teacher}</h3>
                        <h3>${course.type}</h3>
                        <h4>${course.description}</h4>
                        <button class="edit-btn">Edit Course</button>
                        <button class="finish-btn">Finish Course</button>`;

            container
                .querySelector('.edit-btn')
                .addEventListener('click', (event) => editCourse(event, course._id));

            container
                .querySelector('.finish-btn')
                .addEventListener('click', (event) => deleteCourse(event, course._id));

            courseList.appendChild(container);
        }

    } catch (error) {
        console.error('Error:', error);
        throw error;
    }
}

async function editCourse(event, courseID) {
    event.preventDefault();
    enableEditBtn();
    currentTaskId = courseID;

    let course = event.target.parentElement;
    let [title, teacher, type, description] = Array.from(course.children);

    titleInput.value = title.textContent;
    typeInput.value = type.textContent;
    descriptionInput.value = description.textContent;
    teacherInput.value = teacher.textContent;

    course.style.display = 'none';
}

async function deleteCourse(event, courseID) {
    event.preventDefault();

    await fetch(endpoints.delete(courseID), {
        method: 'DELETE'
    });

    await loadCoursesEventHandler();
}

function clearList() {
    courseList.innerHTML = '';
}

function clearFields() {
    titleInput.value = '';
    typeInput.value = '';
    descriptionInput.value = '';
    teacherInput.value = '';
}

function enableEditBtn() {
    editCourseBtn.disabled = false;
    addCourseBtn.disabled = true;
}

function enableAddBtn() {
    editCourseBtn.disabled = true;
    addCourseBtn.disabled = false;
}

attachEvents();