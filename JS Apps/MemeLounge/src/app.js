import page from '../node_modules/page/page.mjs'
import {render} from '../node_modules/lit-html/lit-html.js';
import {logout} from "./api/data.js";

import {showHome} from "./views/home.js";
import {showLogin} from "./views/login.js";
import {showRegister} from "./views/register.js";
import {showCatalog} from "./views/catalog.js";
import {showCreate} from "./views/create.js";
import {showDetails} from "./views/details.js";
import {showEdit} from "./views/edit.js";
import {showProfile} from "./views/userPrrofile.js";

const main = document.querySelector('main');

page('/', decorateCtx, showHome);
page('/login', decorateCtx, showLogin);
page('/register', decorateCtx, showRegister);
page('/catalog', decorateCtx, showCatalog);
page('/create', decorateCtx, showCreate);
page('/details/:id', decorateCtx, showDetails);
page('/edit/:id', decorateCtx, showEdit);
page('/profile', decorateCtx, showProfile);

function decorateCtx(ctx,next) {
    ctx.render = (view) => render(view, main);
    setUserNav();
    next();
}

function setUserNav(){
    const userNav = document.querySelector('.user');
    const guestNav = document.querySelector('.guest');
    if(sessionStorage.getItem('email')){
        guestNav.style.display = 'none';
        userNav.style.display = '';
        userNav.querySelector('span').textContent = 'Welcome, ' + sessionStorage.getItem('email');
    }else{
        guestNav.style.display = '';
        userNav.style.display = 'none';
    }
}

document.getElementById("logout").addEventListener('click',async (ev)=>{
    ev.preventDefault();
    await logout();
    sessionStorage.clear();
    setUserNav();
    page.redirect('/')
})

page.start();