const BASE_URL = 'http://localhost:3030/jsonstore/forecaster'

const locationInput = document.getElementById('location');
const submitBtn = document.getElementById('submit');

const forecastBox = document.getElementById('forecast');
const currentForecastBox = document.getElementById('current');
const upcomingForecastBox = document.getElementById('upcoming');

function attachEvents() {
    submitBtn.addEventListener('click', getWeather);
}

function getWeather() {
    getLocation()
        .then(locationCode => {
            if (locationCode) {
                prepareFields();
                getCurrent(locationCode);
                getUpcoming(locationCode);
            } else {
                prepareFields();
                currentForecastBox.innerHTML += 'Error';
                upcomingForecastBox.innerHTML += 'Error';
                throw new Error('Error here');
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });
}

function getLocation() {
    return fetch(BASE_URL + '/locations')
        .then(res => res.json())
        .then(data => {
            for (const location of data) {
                if (location.name.toLowerCase() === locationInput.value.toLowerCase()) {
                    return location.code;
                }
            }
            return null;
        })
        .catch(error => {
            console.error('Fetch error:', error);
            throw error;
        });
}

function getCurrent(locationCode) {
    fetch(BASE_URL + "/today/" + locationCode)
        .then(res => res.json())
        .then(data => {
            setCurrent(data);
        })
        .catch(error => {
            console.error('Fetch error:',error);
            throw error;
        });
}

function getUpcoming(locationCode) {
    fetch(BASE_URL + "/upcoming/" + locationCode)
        .then(res => res.json())
        .then(data => {
            let forecasts = data.forecast;
            setUpcoming(forecasts);
        })
        .catch(error => {
            console.error('Fetch error:',error);
            throw error;
        });
}

function setCurrent(data) {
    currentForecastBox.innerHTML += `
    <div class="forecasts">
        <span class="condition symbol">${getSymbol(data.forecast.condition)}</span>
        <span class="condition">
            <span class="forecast-data">${data.name}</span>
            <span class="forecast-data">${data.forecast.low}&#176;/${data.forecast.high}&#176;</span>
            <span class="forecast-data">${data.forecast.condition}</span>
        </span>
    </div>`
}

function setUpcoming(forecasts) {
    upcomingForecastBox.innerHTML += `
    <div class="forecast-info">
    </div>`;

    let rows = upcomingForecastBox.querySelector('.forecast-info');

    for (const data of forecasts) {
        rows.innerHTML += `    
                <span class="upcoming">
                    <span class="symbol">${getSymbol(data.condition)}</span>
                    <span class="forecast-data">${data.low}&#176;/${data.high}&#176;</span>
                    <span class="forecast-data">${data.condition}</span>
                </span>`;
    }


}

function getSymbol(condition) {
    switch (condition) {
        case 'Sunny': return '&#x2600;'; // ☀
        case 'Partly sunny': return '&#x26C5;';// ⛅
        case 'Overcast': return '&#x2601;'; // ☁
        case 'Rain': return '&#x2614;'; // ☂
    }
}

function prepareFields() {
    forecastBox.style.display = 'block';
    currentForecastBox.innerHTML = `<div class="label">Current conditions</div>`;
    upcomingForecastBox.innerHTML = `<div class="label">Three-day forecast</div>`;
}

attachEvents();
//"forecast": [
//    {
//        "condition": "Partly sunny",
//        "high": "17",
//        "low": "6"
//    },
//    {
//        "condition": "Overcast",
//        "high": "9",
//        "low": "3"
//    },
//    {
//        "condition": "Overcast",
//        "high": "7",
//        "low": "3"
//    }
//],
//"name": "New York"
