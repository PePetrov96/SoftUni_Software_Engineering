window.addEventListener("load", solve);

function solve() {
  const previewList = document.getElementById('preview-list');

  const firstNameInput = document.getElementById('first-name');
  const lastNameInput = document.getElementById('last-name');
  const ageInput = document.getElementById('age');
  const titleInput = document.getElementById('story-title');
  const genreInput = document.getElementById('genre');
  const storyInput = document.getElementById('story');

  const publishBtn = document.getElementById('form-btn');

  function clearAllFields() {
      firstNameInput.value = '';
      lastNameInput.value = '';
      ageInput.value = '';
      titleInput.value = '';
      genreInput.selectedIndex = 0;
      storyInput.value = '';
  }

  function saveStoryEventHandler() {
      document.getElementById('main').innerHTML = '<h1>Your scary story is saved!</h1>';
  }

  function editStoryEventHandler(event) {
      let elements = event.target.parentElement.querySelector('article').children;

      console.log(elements);

      let names = elements[0].textContent.substring("Name: ".length). split(' ');

      firstNameInput.value = names[0];
      lastNameInput.value = names[1];
      ageInput.value = Number(elements[1].textContent.substring("Age: ".length));
      titleInput.value = elements[2].textContent.substring("Title: ".length);
      genreInput.value = elements[3].textContent.substring("Genre: ".length);
      storyInput.value = elements[4].textContent;

      publishBtn.disabled = false;
      previewList.removeChild(event.target.parentElement);
  }

  function deleteStoryEventHandler(event) {
      previewList.removeChild(event.target.parentElement);
      publishBtn.disabled = false;
  }

  function publishEventHandler() {
      let firstName = firstNameInput.value;
      let lastName = lastNameInput.value;
      let age = ageInput.value;
      let title = titleInput.value;
      let genre = genreInput.value;
      let story = storyInput.value;

      if (firstName === '' || lastName === '' || age === '' || title === '' || story === '') {
          return;
      }

      let li = document.createElement('li');
      li.className = 'story-info';

      li.innerHTML = `
                    <article>
                        <h4>Name: ${firstName} ${lastName}</h4>
                        <p>Age: ${age}</p>
                        <p>Title: ${title}</p>
                        <p>Genre: ${genre}</p>
                        <p>${story}</p>
                    </article>`;

      let saveBtn = document.createElement('button');
      saveBtn.className = 'save-btn';
      saveBtn.textContent = 'Save Story';
      saveBtn.addEventListener('click', saveStoryEventHandler);
      li.appendChild(saveBtn);

      let editBtn = document.createElement('button');
      editBtn.className = 'edit-btn';
      editBtn.textContent = 'Edit Story';
      editBtn.addEventListener('click', event => editStoryEventHandler(event));
      li.appendChild(editBtn);

      let deleteBtn = document.createElement('button');
      deleteBtn.className = 'delete-btn';
      deleteBtn.textContent = 'Delete Story';
      deleteBtn.addEventListener('click', event => deleteStoryEventHandler(event));
      li.appendChild(deleteBtn);

      previewList.appendChild(li);
      clearAllFields();
      publishBtn.disabled = true;
  }

  publishBtn.addEventListener('click', publishEventHandler);
}