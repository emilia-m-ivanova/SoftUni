import page from "../node_modules/page/page.mjs";
import {render} from "../node_modules/lit-html/lit-html.js";
import {logout} from "./api/data.js";

import {showHome} from "./views/home.js";
import {showLogin} from "./views/login.js";
import {showRegister} from "./views/register.js";
import {showCatalog} from "./views/catalog.js";
import {showDetails} from "./views/details.js";
import {showEdit} from "./views/edit.js";
import {showCreate} from "./views/create.js";
import {showProfile} from "./views/profile.js";
import {showSearch} from "./views/search.js";

const main = document.querySelector('main');
const guest = document.getElementById('guest');
const profile = document.getElementById('profile');

page('/', decorateCtx, showHome);
page('/login', decorateCtx, showLogin);
page('/register', decorateCtx, showRegister);
page('/catalog', decorateCtx, showCatalog);
page('/profile', decorateCtx, showProfile);
page('/create', decorateCtx, showCreate);
page('/details/:id', decorateCtx, showDetails);
page('/edit/:id', decorateCtx, showEdit);
page('/search', decorateCtx, showSearch);

page.start();

function decorateCtx(ctx,next) {
    ctx.render = (view) => render(view, main);
    updateNav();
    next();
}

function updateNav() {
    const username = sessionStorage.getItem('username');

    if (username) {
        guest.style.display = 'none';
        profile.style.display = '';
        profile.querySelector('a').textContent = `Welcome ${username}`;
    } else {
        guest.style.display = '';
        profile.style.display = 'none';
    }
}

document.getElementById('logout').addEventListener('click',async (ev)=>{
    ev.preventDefault();
    await logout();
    updateNav();
    page.redirect('/')
})