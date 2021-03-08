import {userLogin} from "./login.js";
import {setNavDisplay} from "./navDisplay.js";

export {userLogout,setUpLogout}

let addButton;
let loginLink;
let logoutLink;
let registerLink;
let greeting;

function setUpLogout(addParam, loginParam, logoutParam, registerParam, greetingParam) {
    addButton = addParam;
    loginLink = loginParam;
    logoutLink = logoutParam;
    registerLink = registerParam;
    greeting = greetingParam;
}

async function userLogout(ev) {
    ev.preventDefault();
    const url = 'http://localhost:3030/users/logout';
    const response = await fetch(url, {
        method: 'get',
        headers: {
            'X-Authorization': sessionStorage.getItem('userToken'),
        },
    })
    if (response.ok) {
        sessionStorage.clear();
    } else {
        const parsed = await response.json();
        return alert(parsed.message);
    }
    setNavDisplay(addButton, loginLink, logoutLink, registerLink, greeting);
    userLogin();
}