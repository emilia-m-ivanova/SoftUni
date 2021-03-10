import {loadRecipes} from "./loadRecipes.js";

export {showLogin,setupLogin};

let main;
let loginSection;

function setupLogin(mainParam, loginParam){
    main = mainParam;
    loginSection = loginParam;
}

function showLogin(){
    main.innerHTML = loginSection.innerHTML;
    main.querySelector('form').addEventListener('submit', onSubmitLogin);
}

function onSubmitLogin (ev) {
    ev.preventDefault();
    const formData = [...new FormData(ev.target).entries()];
    const data = formData.reduce((acc, current) => {
        acc[current[0]] = current[1];
        return acc;
    }, {});
    login(data);
}

async function login(data) {
    const url = 'http://localhost:3030/users/login';
    const response = await fetch(url, {
        method: 'post',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });
    const parsed = await response.json();
    if (response.ok) {
        sessionStorage.setItem('userToken', parsed.accessToken);
        sessionStorage.setItem('id', parsed._id);
        loadRecipes();
    } else {
        alert(parsed.message);
    }
}