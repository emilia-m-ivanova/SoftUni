import {createElement} from "./dom.js";
import {showDetails} from "./details.js";

export {loadRecipes,setupLoad};

let body;

function setupLoad(bodyParam){
    body = bodyParam;
}

async function loadRecipes() {
    if (sessionStorage.getItem('userToken') !== null) {
        document.getElementById('user').style.display = 'inline';
        document.getElementById('guest').style.display = 'none';
    } else {
        document.getElementById('guest').style.display = 'inline';
        document.getElementById('user').style.display = 'none';
    }

    const url = 'http://localhost:3030/data/recipes';
    try {
        const response = await fetch(url)
        const data = await response.json();
        body.innerHTML = '';
        Object.values(data).forEach(e => {
            const img = createElement('img', {src: e.img});
            const name = createElement('h2', {}, e.name);
            const element = createElement('article', {className: 'preview'},
                createElement('div', {className: 'title'},
                    name),
                createElement('div', {className: 'small'},
                    img));
            element.addEventListener('click', () => showDetails(body, e._id, name, img));
            body.appendChild(element);
        })
    } catch (error) {
        alert(error.message);
    }
}