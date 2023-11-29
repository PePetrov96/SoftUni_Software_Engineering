function lockedProfile() {
    let profiles = document.querySelectorAll('.profile');

    for (let profile of profiles) {
        let showMoreButton = profile.querySelector('button');
        let lockRadio = profile.querySelector('input[value="lock"]');
        let hiddenFields = profile.querySelector('.profile > div');

        showMoreButton.addEventListener('click', () => {
            if (!lockRadio.checked) {
                if (showMoreButton.innerText === "Show more") {
                    hiddenFields.style.display = 'block';
                    showMoreButton.innerText = "Hide it";
                } else {
                    hiddenFields.style.display = 'none';
                    showMoreButton.innerText = "Show more";
                }
            }
        });
    }
}