function addDestination() {
    const [city, country] = Array.from(document.querySelectorAll('.inputData'));
    const season = document.querySelector('#seasons').value;
    const table = document.getElementById('destinationsList');
    const summary = Array.from(document.querySelectorAll('.summary'));

    if (city.value === '' || country.value === '') {
        return;
    }
    const element = createElement('tr', {},
        createElement('td', {}, city.value + ', ' + country.value),
        createElement('td', {}, season.charAt(0).toUpperCase() + season.slice(1)));
    table.appendChild(element);

    const chosenSeason = summary.find(e => e.id === season.toLowerCase());
    chosenSeason.value = Number(chosenSeason.value) + 1;

    city.value = '';
    country.value = '';


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