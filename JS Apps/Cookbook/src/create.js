import {loadRecipes} from "./loadRecipes.js";

export {showCreate, setupCreate};

let main;
let createSection;

function setupCreate(mainParam, createParam) {
    main = mainParam;
    createSection = createParam;
}

function showCreate() {
    main.innerHTML = createSection.innerHTML;
    main.querySelector('form').addEventListener('submit', onSubmitCreate);
}

function onSubmitCreate(ev) {
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
    postRecipe(data);
}

async function postRecipe(data) {
    const url = 'http://localhost:3030/data/recipes';
    const response = await fetch(url, {
        method: 'post',
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