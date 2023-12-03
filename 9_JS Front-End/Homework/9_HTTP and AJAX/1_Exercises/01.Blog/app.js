const POSTS_URL = 'http://localhost:3030/jsonstore/blog/posts';
const COMMENTS_URL = 'http://localhost:3030/jsonstore/blog/comments';

const loadPostsBtn = document.getElementById('btnLoadPosts');
const viewBtn = document.getElementById('btnViewPost');

const postsList = document.getElementById('posts');

const postTitle = document.getElementById('post-title');
const postDescription = document.getElementById('post-body');

const postComments = document.getElementById('post-comments');

function attachEvents() {
    loadPostsBtn.addEventListener('click', loadPosts);
    viewBtn.addEventListener('click', setComments);
    postsList.addEventListener('change', viewPost);
}

function loadPosts() {
    return fetch(POSTS_URL)
        .then(res => res.json())
        .then((data) => {
            let posts = Object.entries(data);
            postsList.innerHTML = ''; // Clear existing options if any

            for (const [key, post] of posts) {
                postsList.innerHTML += `<option value="${post.id}">${post.title.toUpperCase()}</option>`;
            }

            // Check if there are posts and load the first post's details
            if (posts.length > 0) {
                viewPost();
            }
        })
        .catch((error) => {
            console.error('Error: ', error);
            throw error;
        });
}

function viewPost() {
    return fetch(`${POSTS_URL}/${postsList.value}`)
        .then(res => res.json())
        .then((data) => {
            postTitle.textContent = data.title.toUpperCase();
            postDescription.textContent = data.body;
        })
        .catch((error) => {
            console.error('Error: ', error);
            throw error;
        });
}

function setComments() {
    postComments.innerHTML = '';
    let postID = postsList.value;

    fetch(COMMENTS_URL)
        .then(res => res.json())
        .then((data) => {
            let comments = Object.entries(data);

            for (const [key, comment] of comments) {
                if (comment.postId === postID) {
                    postComments.innerHTML += `<li id="${comment.id}">${comment.text}</li>`;
                }
            }

        })
        .catch((error) => {
            console.error('Error: ', error);
            throw error;
        });
}

attachEvents();