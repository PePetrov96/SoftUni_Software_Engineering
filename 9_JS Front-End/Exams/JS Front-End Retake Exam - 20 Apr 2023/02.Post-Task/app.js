window.addEventListener("load", solve);

function solve() {
    const titleInput = document.getElementById('task-title');
    const categoryInput = document.getElementById('task-category');
    const contentInput = document.getElementById('task-content');

    const publishBtn = document.getElementById('publish-btn');

    const reviewList = document.getElementById('review-list');

    const publishList = document.getElementById('published-list');

    function attachEvents() {
        publishBtn.addEventListener('click', publishEventHandler);
    }

    function clearFields() {
        titleInput.value = '';
        categoryInput.value = '';
        contentInput.value = '';
    }

    function publishEventHandler() {
        let title = titleInput.value;
        let category = categoryInput.value;
        let content = contentInput.value;

        if (title === '' || category ===  '' || content === '') {
            return;
        }

        let li = document.createElement('li');
        li.className = 'rpost';

        li.innerHTML = `
                    <article>
                        <h4>${title}</h4>
                        <p>Category: ${category}</p>
                        <p>Content: ${content}</p>
                    </article>
                    <button class="action-btn edit">Edit</button>
                    <button class="action-btn post">Post</button>`;

        li.querySelector('.edit')
            .addEventListener('click', editEventHandler);
        li.querySelector('.post')
            .addEventListener('click', finalPostEventHandler);

        reviewList.appendChild(li);
        clearFields();
    }

    function editEventHandler() {
        const [title, category, content] = Array.from(document.querySelector('.rpost article').children);

        reviewList.innerHTML = '';

        titleInput.value = title.textContent;
        categoryInput.value = category.textContent.replace('Category: ', '');
        contentInput.value = content.textContent.replace('Content: ', '');
    }

    function finalPostEventHandler() {
        const [title, category, content] = Array.from(document.querySelector('.rpost article').children);
        reviewList.innerHTML = '';

        let li = document.createElement('li');
        li.className = 'rpost';

        li.innerHTML = `
                    <article>
                        <h4>${title.textContent}</h4>
                        <p>${category.textContent}</p>
                        <p>${content.textContent}</p>
                    </article>`;

        publishList.appendChild(li);
    }

    attachEvents();
}