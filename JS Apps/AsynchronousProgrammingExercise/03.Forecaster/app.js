async function attachEvents() {
    const input = document.getElementById('location');
    const current = document.getElementById('current')
    const upcoming = document.getElementById('upcoming')
    document.getElementById('submit').addEventListener('click', generateForecast);
    const urlLocations = 'http://localhost:3030/jsonstore/forecaster/locations/';

    async function generateForecast() {
        document.getElementById('forecast').style.display = 'block';
        const [cFirst, cSecond] = Array.from(current.children);
        const [uFirst, uSecond] = Array.from(upcoming.children);
        if (cSecond !== undefined) {
            cSecond.remove();
            uSecond.remove();
        }
        try {
            const promise = await fetch(urlLocations);
            const locations = await promise.json();
            const location = locations.find(e => e.name.toLowerCase() === input.value.toLowerCase());
            if (location === undefined) {
                throw new Error();
            }
            const urlToday = 'http://localhost:3030/jsonstore/forecaster/today/' + location.code;
            const url3days = 'http://localhost:3030/jsonstore/forecaster/upcoming/' + location.code;
            await Promise.all([
                showToday(urlToday),
                showUpcoming(url3days)
            ]);
        } catch (err) {
            current.appendChild(createElement('span', {className: 'forecast-data'}, 'ERROR'))
            upcoming.appendChild(createElement('span', {className: 'forecast-data'}, 'ERROR'))
        }
    }

    async function showToday(url) {
        const promise = await fetch(url);
        const data = await promise.json();
        const divElement = createElement('div', {className: 'forecasts'},
            createElement('span', {className: 'condition symbol'}, symbols[data.forecast.condition]),
            createElement('span', {className: 'condition'},
                createElement('span', {className: 'forecast-data'}, data.name),
                createElement('span', {className: 'forecast-data'}, data.forecast.low + symbols.Degrees + '/' + data.forecast.high + symbols.Degrees),
                createElement('span', {className: 'forecast-data'}, data.forecast.condition)));
        current.appendChild(divElement);
    }

    async function showUpcoming(url) {
        const promise = await fetch(url);
        const data = await promise.json();
        const divElement = createElement('div', {className: 'forecast-info'});
        data.forecast.map(e => {
            return createElement('span', {className: 'upcoming'},
                createElement('span', {className: 'symbol'}, symbols[e.condition]),
                createElement('span', {className: 'forecast-data'}, e.low + symbols.Degrees + '/' + e.high + symbols.Degrees),
                createElement('span', {className: 'forecast-data'}, e.condition));
        }).forEach(e => divElement.appendChild(e));
        upcoming.appendChild(divElement);
    }

    const symbols = {
        'Sunny': '☀',
        'Partly sunny': '⛅',
        'Overcast': '☁',
        'Rain': '☂',
        'Degrees': '°',
    }

    function createElement(tagName, attributes, ...content) {
        const element = document.createElement(tagName);

        //add attribute or event listener
        for (let attr in attributes) {
            if (attr.substring(0, 2) === 'on') {
                element.addEventListener(attr.substring(2).toLowerCase(), attributes[attr]);
            } else {
                element[attr] = attributes[attr];
            }
        }

        //add content or append a child element
        content.forEach(c => {
            if (typeof c === "string" || typeof c === 'number') {
                element.textContent = c;
            } else {
                element.appendChild(c)
            }
        });
        return element;
    }
}

attachEvents();