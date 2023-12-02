const BASE_URL = 'http://localhost:3030/jsonstore/bus/businfo';

const busIdInput = document.getElementById('stopId');
const stopNameOutput = document.getElementById('stopName');
const bussesOutput = document.getElementById('buses');

function getInfo() {
    bussesOutput.innerHTML = '';
    stopNameOutput.innerHTML = '';

    getBusStopID(busIdInput.value)
        .then(busStop => {
            stopNameOutput.innerHTML = `${busStop.name}`;

            let busStopArr = Object.entries(busStop.buses);

            for (const bus of busStopArr) {
                bussesOutput.innerHTML += `<li>Bus ${bus[0]} arrives in ${bus[1]} minutes</li>`;
            }
        })
        .catch(() => {
            stopNameOutput.innerHTML = `Error`;
        });
}

function getBusStopID(busStopID) {
    return fetch(`${BASE_URL}/${busStopID}`)
        .then(res => res.json())
        .then(data => {
            return data;
        })
        .catch(error => {
            console.error('Fetch error:', error);
            throw error;
        });
}
