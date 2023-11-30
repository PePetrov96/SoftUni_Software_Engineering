function loadRepos() {
	// Get the username as input
	let username = document.getElementById('username').value;

	// Get the repo of that user. Make sure to return it as a JSON with .json()
	fetch(`https://api.github.com/users/${username}/repos`)
		.then(res => res.json())
		.then(data => {
			listRepos(data);
		})
		.catch(error => {
			listRepos(error);
		});

	function listRepos(data) {
		// Get the list
		let list = document.getElementById('repos');

		// Remove the current element (clear the list)
		list.innerHTML = '';

		// For each repo, append the name and link as an <a> element inside a <li> element
		for (const entry of data) {
			let li = document.createElement('li');
			let a = document.createElement('a');

			// Make use of the non-changeable JSON format GitHub provides
			a.href = entry.url;
			a.text = entry.full_name;

			li.appendChild(a);

			list.appendChild(li);
		}
	}
}
