function loadRepos() {
    fetch('https://api.github.com/users/testnakov/repos')
        .then(res => res.text())
        .then(data => {
            document.getElementById('res').textContent = data;
        })
        .catch(error => {
            console.error('Error:', error);
        });
}
