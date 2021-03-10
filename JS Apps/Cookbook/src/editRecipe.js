import {loadRecipes} from "./loadRecipes.js";

export {showEdit, setupEdit}

let main;
let edit;
let id;

function setupEdit(mainParam, editParam) {
    main = mainParam;
    edit = editParam;
}

async function showEdit(idParam) {
    id = idParam;
    main.innerHTML = edit.innerHTML;
    const form = main.querySelector('form');
    form.addEventListener('submit', onSubmitEdit);
    const url = 'http://localhost:3030/data/recipes/' + idParam;
    const response = await fetch(url)
    const data = await response.json();
    if (!response.ok) {
        return alert(data.message);
    }
    console.log(data)
    form.querySelector('[name="name"]').value = data.name;
    form.querySelector('[name="img"]').value = data.img;
    form.querySelector('[name="steps"]').value = data.steps.join('\n');
    form.querySelector('[name="ingredients"]').value = data.ingredients.join('\n');
}

function onSubmitEdit(ev) {
    ev.preventDefault();
    const formData = [...new FormData(ev.target).entries()];
    const data = formData.reduce((acc, current, index) => {
        if (index > 1) {
            acc[current[0]] = current[1].split('\n');
        } else {
            acc[current[0]] = current[1]
        }
        return acc;
    }, {});
    editRecipe(data);
}

async function editRecipe(data) {
    const url = 'http://localhost:3030/data/recipes/' + id;
    const response = await fetch(url, {
        method: 'put',
        headers: {
            'Content-Type': 'application/json',
            'X-Authorization': sessionStorage.userToken,
        },
        body: JSON.stringify(data),
    });
    if (response.ok) {
        loadRecipes();
    }
}