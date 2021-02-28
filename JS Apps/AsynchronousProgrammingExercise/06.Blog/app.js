function attachEvents() {
    const dropDown = document.getElementById('posts');
    const title = document.getElementById('post-title');
    const body = document.getElementById('post-body');
    const comments = document.getElementById('post-comments');
    document.getElementById('btnLoadPosts').addEventListener('click',(ev)=>loadPosts(ev,dropDown));
    document.getElementById('btnViewPost').addEventListener('click',()=>viewPost(dropDown,title,body,comments));
}

async function loadPosts(ev,dropDown){
    ev.target.disabled = true;
    const postsURL = 'http://localhost:3030/jsonstore/blog/posts';
    const promise = await fetch(postsURL);
    const posts = await promise.json();
    Object.values(posts).map(p=>{
        return createElement('option',{value:p.id},p.title.toUpperCase());
    }).forEach(e=>dropDown.appendChild(e));
}

async function viewPost(dropDown,title,body,comments){
    const postURL = 'http://localhost:3030/jsonstore/blog/posts/' + dropDown.value;
    const commentsURL = 'http://localhost:3030/jsonstore/blog/comments';
    const [postPromise,commentsPromise] = await Promise.all([
        fetch(postURL),
        fetch(commentsURL)
    ]);
    const [post,commentsAll] = await Promise.all([
        postPromise.json(),
        commentsPromise.json()
    ]);
    title.textContent = post.title;
    body.textContent = post.body;
    comments.innerHTML = '';
    Object.values(commentsAll).filter(c=>c.postId===dropDown.value)
        .forEach(e=>comments.appendChild(createElement('li',{id:e.id},e.text)));

}

function createElement(tagName,attributes,...content) {
    const element = document.createElement(tagName);

    //add attribute or event listener
    for (let attr in attributes) {
        if (attr.substring(0,2) === 'on') {
            element.addEventListener(attr.substring(2).toLowerCase(), attributes[attr]);
        } else {
            element[attr] = attributes[attr];
        }
    }

    //add content or append a child element
    content.forEach(c => {
        if (typeof c === "string"|| typeof c === 'number') {
            element.textContent = c;
        } else {
            element.appendChild(c)
        }
    });
    return element;
}

attachEvents();