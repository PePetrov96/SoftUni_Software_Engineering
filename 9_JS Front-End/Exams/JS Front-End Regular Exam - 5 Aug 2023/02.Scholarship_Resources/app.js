window.addEventListener("load", solve);

function solve() {
    const studentInput = document.getElementById('student');
    const universityInput = document.getElementById('university');
    const scoreInput = document.getElementById('score');

    const nextBtn = document.getElementById('next-btn');

    const previewList = document.getElementById('preview-list');
    const finalList = document.getElementById('candidates-list');

    nextBtn.addEventListener('click', nextBtnEventHandler);

    function nextBtnEventHandler() {
        let student = studentInput.value;
        let university = universityInput.value;
        let score = scoreInput.value;

        if (student === '' || university === '' || score === '') {
            return;
        }

        disableAndClear();

        let li = document.createElement('li');
        li.className = 'application';

        li.innerHTML = `<article>
                            <h4>${student}</h4>
                            <p>University: ${university}</p>
                            <p>Score: ${score}</p>
                        </article>`;

        let btn1 = document.createElement('button');
        btn1.className = 'action-btn edit';
        btn1.innerText = 'edit';
        btn1.addEventListener('click', editBtnEventHandler);
        li.appendChild(btn1);

        let btn2 = document.createElement('button');
        btn2.className = 'action-btn apply';
        btn2.textContent = 'apply';
        btn2.addEventListener('click', (event) => actionBtnEventHandler(event));
        li.appendChild(btn2);

        previewList.appendChild(li);

        disableForm();
    }

    function disableForm() {
        nextBtn.disabled = true;
    }

    function enableForm() {
        nextBtn.disabled = false;
    }

    function editBtnEventHandler(event) {
        let item = event.target.parentElement;
        let values = item.children.item(0);

        studentInput.value = values.children.item(0).textContent;
        universityInput.value = values.children.item(1).textContent.replace('University: ', '');
        scoreInput.value = values.children.item(2).textContent.replace('Score: ', '');

        previewList.innerHTML = '';
        enableForm();
    }

    function actionBtnEventHandler(event) {
        let item = event.target.parentElement;
        let values = item.children.item(0);

        let li = document.createElement('li');
        li.className = 'application';

        li.appendChild(values);

        finalList.appendChild(li);

        previewList.innerHTML = '';
        enableForm();
    }

    function disableAndClear() {
        nextBtn.disabled = true;
        studentInput.value = '';
        universityInput.value = '';
        scoreInput.value = '';
    }
}