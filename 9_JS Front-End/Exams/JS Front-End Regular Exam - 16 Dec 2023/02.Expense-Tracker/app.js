window.addEventListener("load", solve);

function solve() {
    const expenseInput = document.getElementById('expense');
    const amountInput = document.getElementById('amount');
    const dateInput = document.getElementById('date');

    const addBtn = document.getElementById('add-btn');
    const deleteBtn = document.querySelector('.btn.delete');

    const previewList = document.getElementById('preview-list');
    const expensesList = document.getElementById('expenses-list');

    function attachEventListeners() {
        addBtn.addEventListener('click', addEventHandler);
        deleteBtn.addEventListener('click', () => {
            window.location.reload();
        });
    }

    function addEventHandler() {
        let expense = expenseInput.value;
        let amount = amountInput.value;
        let date = dateInput.value;

        if (expense === '' || amount === '' || date === '') return;

        let li = document.createElement('li');
        li.className = 'expense-item';

        let article = document.createElement('article');
        article.innerHTML = `<p>Type: ${expense}</p>
                             <p>Amount: ${amount}$</p>
                             <p>Date: ${date}</p>`;
        li.appendChild(article);

        let buttonDiv = document.createElement('div');
        buttonDiv.className = 'buttons';

        let editBtn = document.createElement('button');
        editBtn.className = 'btn edit';
        editBtn.textContent = 'edit';
        editBtn.addEventListener('click', event => editEventHandler(event));
        buttonDiv.appendChild(editBtn);

        let okBtn = document.createElement('button');
        okBtn.className = 'btn ok';
        okBtn.textContent = 'ok';
        okBtn.addEventListener('click', event => saveEventHandler(event));
        buttonDiv.appendChild(okBtn);

        li.appendChild(buttonDiv);
        previewList.appendChild(li);

        clearFields();
        disableAddBtn();
    }

    function editEventHandler(event) {
        let li = event.target.parentElement.parentElement;

        let info = li.querySelector('article').children;

        expenseInput.value = info[0].textContent.replace('Type: ', '');
        amountInput.value = info[1].textContent.replace('Amount: ', '').replace('$','');
        dateInput.value = info[2].textContent.replace('Date: ', '');

        previewList.removeChild(li);
        enableAddBtn();
    }

    function saveEventHandler(event) {
        let liItem = event.target.parentElement.parentElement;
        let info = liItem.querySelector('article').children;

        let li = document.createElement('li');
        li.className = 'expense-item';

        let article = document.createElement('article');
        article.innerHTML = `<p>${info[0].textContent}</p>
                             <p>${info[1].textContent}</p>
                             <p>${info[2].textContent}</p>`;

        li.appendChild(article);
        expensesList.appendChild(li);

        previewList.removeChild(liItem);
        enableAddBtn();
    }

    function clearFields() {
        expenseInput.value = '';
        amountInput.value = '';
        dateInput.value = '';
    }

    function disableAddBtn() {
        addBtn.disabled = true;
    }

    function enableAddBtn() {
        addBtn.disabled = false;
    }

    attachEventListeners();
}