import {createElement} from "./dom.js";
import {showEdit} from "./editRecipe.js";

export {showDetails};

function showDetails(body, id, name, img) {
    const url = 'http://localhost:3030/data/recipes/' + id;
    body.innerHTML = '';
    const ulElement = createElement('ul', {});

    const div1 = createElement('div', {className: 'band'},
        createElement('div', {className: 'thumb'}, img),
        createElement('div', {className: 'ingredients'},
            createElement('h3', {}, 'Ingredients'),
            ulElement))
    const div2 = createElement('div', {className: 'description'},
        createElement('h3', {}, 'Preparation:'));
    const section = createElement('section', {id: 'details'},
        createElement('article', {}, name, div1, div2,
            createElement('div', {className: 'controls'},
                createElement('button', {onClick: () => showEdit(id)}, '✎ Edit'),
                createElement('button', {onClick: () => remove(body, id)}, '✖ Delete'))));

    fetch(url)
        .then(r => r.json())
        .then(r => {
            r.steps.forEach(e => {
                const pElement = createElement('p', {}, e);
                div2.appendChild(pElement);
            });
            r.ingredients.forEach(e => {
                const liElement = createElement('li', {}, e);
                ulElement.appendChild(liElement);
            })
            showButtons(body, r._ownerId);
        });


    body.appendChild(section);
}

function showButtons(body, ownerId) {
    if (ownerId !== sessionStorage.id) {
        body.querySelector('.controls').style.display = 'none';
    }
}

async function remove(body, id) {
    const confirmation = confirm('Are you sure you want to delete this recipe?');
    if(!confirmation){
        return;
    }

    const url = 'http://localhost:3030/data/recipes/' + id;
    const response = await fetch(url, {
        method: 'delete',
        headers: {
            'X-Authorization': sessionStorage.userToken,
        },
    });
    if (response.ok) {
        body.innerHTML = '';
        body.appendChild(createElement('section', {id: 'details'},
            createElement('article',{},createElement('h2', {}, 'Recipe deleted'))));
    }
}