function solve() {
    const BASE_URL = 'http://localhost:3030/jsonstore/bus/schedule';

    const departBtn = document.getElementById('depart');
    const arriveBtn = document.getElementById('arrive');
    const infoBox = document.querySelector('.info');

    let busStop = "depot";

    function depart() {
        fetch(BASE_URL + "/" + busStop)
            .then(response => response.json())
            .then(data => {
                infoBox.textContent = `Next stop ${data.name}`;
                arriveBtn.disabled = false;
                departBtn.disabled = true;
            })
            .catch(error => {
                infoBox.textContent = 'Error'
                console.error('Fetch error:', error);
                throw error;
            });
    }

    async function arrive() {
        fetch(BASE_URL + "/" + busStop)
            .then(response => response.json())
            .then(data => {
                infoBox.textContent = `Arriving at ${data.name}`;
                departBtn.disabled = false;
                arriveBtn.disabled = true;

                busStop = data.next;
            })
            .catch(error => {
                infoBox.textContent = 'Error'
                console.error('Fetch error:', error);
                throw error;
            });
    }

    return {
        depart,
        arrive
    };
}

let result = solve();