function loadRecipes() {
    const url = 'http://localhost:3030/jsonstore/cookbook/recipes';
    const body = document.querySelector('main');

    fetch(url)
        .then(r => r.json())
        .then(r => {
            body.innerHTML = '';
            Object.entries(r).forEach(e => {
                const img = createElement('img', {src: e[1].img});
                const name = createElement('h2', {}, e[1].name);
                const element = createElement('article', {className: 'preview'},
                    createElement('div', {className: 'title'},
                        name),
                    createElement('div', {className: 'small'},
                        img));
                element.addEventListener('click', () => showDetails(element, e[0], name, img));
                body.appendChild(element);
            })
        })
        .catch(error=>alert(error.message));
}

function showDetails(current, id, name, img) {
    const url = 'http://localhost:3030/jsonstore/cookbook/details/' + id;
    current.innerHTML = '';
    current.className = '';
    current.appendChild(name);
    const ulElement = createElement('ul', {});


    const div1 = createElement('div', {className: 'band'},
        createElement('div', {className: 'thumb'}, img),
        createElement('div', {className: 'ingredients'},
            createElement('h3', {}, 'Ingredients'),
            ulElement))
    const div2 = createElement('div', {className: 'description'},
        createElement('h3', {}, 'Preparation:'));


    fetch(url)
        .then(r => r.json())
        .then(r => {
            r.steps.forEach(e => {
                const pElement = createElement('p', {}, e);
                div2.appendChild(pElement);
            })
            r.ingredients.forEach(e => {
                const liElement = createElement('li', {}, e);
                ulElement.appendChild(liElement);
            })
        });


    current.appendChild(div1);
    current.appendChild(div2);
}

window.addEventListener('load', () => {
    loadRecipes();
})

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