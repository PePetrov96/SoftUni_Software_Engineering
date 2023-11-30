function loadCommits() {
    // Get the username and repo from the input fields
    let username = document.getElementById('username').value;
    let repo = document.getElementById('repo').value;

    // Get output list and clear previous content
    let commitsList = document.getElementById('commits');
    commitsList.innerHTML  = '';

    // Fetch data from GitHub API
    fetch(`https://api.github.com/repos/${username}/${repo}/commits`)
        .then(res => {
            if (!res.ok) {
                throw new Error(`Error: ${res.status} (Not Found)`);
            }
            return res.json();
        })
        .then(commits => {
            // Process each commit and add it to the list
            for (const commit of commits) {
                let li = document.createElement('li');
                li.textContent = `${commit.commit.author.name}: ${commit.commit.message}`;
                commitsList.appendChild(li);
            }
        })
        .catch(error => {
            let li = document.createElement('li');
            li.textContent = error.message;
            commitsList.appendChild(li);
        })
}
