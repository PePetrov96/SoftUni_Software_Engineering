window.addEventListener("load", solve);

function solve() {
  function clearEntireList() {
    location.reload();
  }

  function addItemToEditList() {
    let name = nameInput.value;
    let score = scoreInput.value;
    let round = roundInput.value;

    if (name.length === 0 || score.length === 0 || round.length === 0) {
      return;
    }

    let li = document.createElement('li');
    li.className = 'dart-item';

    li.innerHTML += `
        <article>
            <p>${name}</p>
            <p>Score: ${score}</p>
            <p>Round: ${round}</p>
        </article>`;

    let editBtn = document.createElement('button');
    editBtn.className = 'btn edit';
    editBtn.textContent = 'edit';
    editBtn.addEventListener('click', editBtnListener);

    let okBtn = document.createElement('button');
    okBtn.className = 'btn ok';
    okBtn.textContent = 'ok';
    okBtn.addEventListener('click', okBtnListener);

    li.appendChild(editBtn);
    li.appendChild(okBtn);

    sureList.appendChild(li);

    disableAndClear();
  }

  function editBtnListener(event) {
    let element = findParentWithClass(event.target, 'dart-item');

    nameInput.value = element.querySelector('p:nth-of-type(1)').textContent;
    scoreInput.value = element.querySelector('p:nth-of-type(2)').textContent.replace('Score: ', '');
    roundInput.value = element.querySelector('p:nth-of-type(3)').textContent.replace('Round: ', '');

    removeAndEnable(element);
  }

  function okBtnListener(event) {
    let element = findParentWithClass(event.target, 'dart-item');
    let btn1 = element.querySelector('.edit');
    let btn2 = element.querySelector('.ok');

    removeAndEnable(element);

    element.removeChild(btn1);
    element.removeChild(btn2);

    scoreboardList.appendChild(element);
  }

  function removeAndEnable(element) {
    sureList.removeChild(element);
    addBtn.disabled = false;
  }

  function disableAndClear() {
    addBtn.disabled = true;
    nameInput.value = '';
    scoreInput.value = '';
    roundInput.value = '';
  }

  function findParentWithClass(element, className) {
    while (element && !element.classList.contains(className)) {
      element = element.parentElement;
    }
    return element;
  }

  const sureList = document.getElementById('sure-list');
  const scoreboardList = document.getElementById('scoreboard-list');

  const nameInput = document.querySelector('input[id="player"]');
  const scoreInput = document.querySelector('input[id="score"]');
  const roundInput = document.querySelector('input[id="round"]');

  const addBtn = document.getElementById('add-btn');
  const clearBtn = document.querySelector('.clear');

  addBtn.addEventListener('click', addItemToEditList);
  clearBtn.addEventListener('click', clearEntireList);
}