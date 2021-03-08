export {setUpHome, showHome};
import {setNavDisplay} from "./navDisplay.js";

let homeSection;
let sections;
let addButton;
let loginLink;
let logoutLink;
let registerLink;
let greeting;

function setUpHome(homeSectionParam, sectionsParam, addParam, loginParam, logoutParam, registerParam, greetingParam) {
    homeSection = homeSectionParam;
    sections = sectionsParam;
    addButton = addParam;
    loginLink = loginParam;
    logoutLink = logoutParam;
    registerLink = registerParam;
    greeting = greetingParam;
}

async function showHome() {
    sections.forEach(s=>s.style.display = 'none');
    homeSection.style.display = '';
    const url = 'http://localhost:3030/data/movies';
    const response = await fetch(url);
    const data = await response.json();
    if (!response.ok) {
        return alert(data.message);
    }
    const movies = data.map(e => {
        return `<div class="card mb-4">
                            <img class="card-img-top" src="${e.img}"
                                 alt="Card image cap" width="400">
                            <div class="card-body">
                                <h4 class="card-title">${e.title}</h4>
                            </div>
                            <div class="card-footer">
                                <a href="#/details/6lOxMFSMkML09wux6sAF">
                                    <button type="button" class="btn btn-info" id="${e._id}">Details</button>
                                </a>
                            </div>

                        </div>`
    }).join('');
    homeSection.querySelector('.card-deck.d-flex.justify-content-center').innerHTML = movies;
    setNavDisplay(addButton, loginLink, logoutLink, registerLink, greeting);
}