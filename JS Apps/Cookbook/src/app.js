import {loadRecipes, setupLoad} from './loadRecipes.js';
import {setupLogin, showLogin} from "./login.js";
import {setupRegister, showRegister} from "./register.js";
import {logOut} from "./logOut.js";
import {setupCreate, showCreate} from "./create.js";
import {setupEdit} from "./editRecipe.js";

function loadPage() {
    document.getElementById('logoutBtn').addEventListener('click', logOut);
    document.getElementById('catalog').addEventListener('click', loadRecipes);
    document.getElementById('loginBtn').addEventListener('click', showLogin);
    document.getElementById('registerBtn').addEventListener('click', showRegister)
    document.getElementById('createBtn').addEventListener('click', showCreate);
    loadRecipes();
}

function setUp() {
    const main = document.querySelector('main');
    setupLoad(main);
    setupLogin(main, document.getElementById('login'));
    setupRegister(main, document.getElementById('register'));
    setupCreate(main, document.getElementById('create'));
    setupEdit(main, document.getElementById('edit'))
}

setUp();
loadPage();
