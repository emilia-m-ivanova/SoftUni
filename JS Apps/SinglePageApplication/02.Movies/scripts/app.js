import {showHome, setUpHome} from './loadHome.js';
import {setUpLogin, userLogin} from "./login.js";
import {setUpLogout, userLogout} from "./logout.js";
import {setUpRegister, userRegister} from "./register.js";
import {addMovie, setUpAdd} from "./addMovie.js";
import {setUpDetails, showDetails} from "./movieDetails.js";
import {like} from "./likeMovie.js";
import {deleteMovie} from "./deleteMovie.js";
import {edit, setUpEdit} from "./editMovie.js";

async function startApp() {
    await showHome();
    document.querySelector('.navbar-brand.text-light').addEventListener('click', async (ev) => {
        ev.preventDefault();
        await showHome();
    });
    document.getElementById('add-movie-button').addEventListener('click', addMovie);
    document.getElementById('loginLink').addEventListener('click', userLogin);
    document.getElementById('logoutLink').addEventListener('click', userLogout);
    document.getElementById('registerLink').addEventListener('click', userRegister);
    document.getElementById('movie').addEventListener('click', (ev)=>{
        if (ev.target.tagName !== 'BUTTON') {
            return;
        }
        showDetails(ev.target.id)
    });
    document.getElementById('likeBtn').addEventListener('click',like)
    document.getElementById('deleteBtn').addEventListener('click',deleteMovie)
    document.getElementById('editBtn').addEventListener('click',edit)
}

function setUp() {
    const sections = [...document.querySelectorAll('section')];
    setUpHome(document.getElementById('home-page'), sections, document.getElementById('add-movie-button'),
        document.getElementById('loginLink'), document.getElementById('logoutLink'),
        document.getElementById('registerLink'), document.getElementById('welcome'));

    setUpAdd(document.getElementById('add-movie'), sections);

    setUpLogin(document.getElementById('form-login'), sections);

    setUpRegister(document.getElementById('form-sign-up'), sections);

    setUpLogout(document.getElementById('add-movie-button'),
        document.getElementById('loginLink'), document.getElementById('logoutLink'),
        document.getElementById('registerLink'), document.getElementById('welcome'))

    setUpDetails(document.getElementById('movie-example'),sections,
        document.getElementById('deleteBtn'), document.getElementById('editBtn'),
        document.getElementById('likeBtn'));

    setUpEdit(document.getElementById('edit-movie'), sections)
}

setUp();
startApp();