import {postComment} from "./postComment.js";

export {setUpShow, show, getComments}

let homePage;
let contentPage;

function setUpShow(homeParam, contentParam) {
    homePage = homeParam;
    contentPage = contentParam;
}


async function show(ev) {
    ev.preventDefault();
    if (ev.target.tagName !== 'H2') {
        return;
    }
    const url = 'http://localhost:3030/jsonstore/collections/myboard/posts/' + ev.target.id;
    homePage.style.display = 'none';
    contentPage.style.display = '';
    const response = await fetch(url);
    const data = await response.json();
    if (!response.ok) {
        return alert(data.message);
    }
    contentPage.querySelector('.theme-name h2').textContent = data.topicName;
    contentPage.querySelector('.theme-name p time').textContent = data.date;
    await getComments(data,ev.target.id);
    contentPage.querySelector('.answer form').addEventListener('submit',async (e)=>postComment(e,data,ev.target.id))

}

async function getComments(initialComment,id) {
    const url = 'http://localhost:3030/jsonstore/collections/myboard/comments';
    const response = await fetch(url);
    const data = await response.json();
    if (!response.ok) {
        return alert(data.message);
    }
    let comments = Object.values(data)
        .filter(e => e.postId === id);
    comments.unshift(initialComment);
    comments = comments.map(e => {
        return `<div class="comment">
                        <header class="header">
                             <p><span>${e.username}</span> posted on <time>${e.date}</time></p>
                         </header>
                         <div class="comment-main">
                            <div class="userdetails">
                                 <img src="./static/profile.png" alt="avatar">
                             </div>
                            <div class="post-content">
                                 <p>${e.postText}</p>
                            </div>
                         </div>
                    </div>`
    }).join('');
    contentPage.querySelector('#comments').innerHTML = comments;
}
