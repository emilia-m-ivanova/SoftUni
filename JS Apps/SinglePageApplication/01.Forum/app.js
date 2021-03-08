import {onSubmit} from "./createPost.js";
import {appendPosts, setUpLoad} from "./loadPosts.js";
import {setUpShow, show, getComments} from "./showContent.js";

function attachListeners() {
    document.querySelector('form').addEventListener('submit', async (ev) => {
        await onSubmit(ev);
        await appendPosts();
    });
    document.querySelector('.topic-title').addEventListener('click', async (ev) => show(ev));
    document.getElementById('home').addEventListener('click',appendPosts);
}

function initializeParams() {
    const [home, content] = document.querySelectorAll('.container');
    setUpLoad(document.querySelector('.topic-title'),home,content);
    setUpShow(home,content);
}

initializeParams();
attachListeners();
appendPosts();
