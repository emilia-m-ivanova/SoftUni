async function solution() {
    const url = 'http://localhost:3030/jsonstore/advanced/articles/list';
    const main = document.getElementById('main');
    const promise = await fetch(url);
    const articles = await promise.json();
    articles.map(a => {
        return createElement('div', {className: 'accordion'},
            createElement('div', {className: 'head'},
                createElement('span', {}, a.title),
                createElement('button', {className: 'button', id: a._id, onClick: toggle}, 'MORE')),
            createElement('div', {className: 'extra'}))
    }).forEach(e => main.appendChild(e));

}

async function toggle(ev) {
    const parent = ev.target.parentNode.parentNode;
    const content = parent.querySelector('.extra');
    if (ev.target.textContent === 'LESS') {
        ev.target.textContent = 'MORE';
        content.style.display = 'none';
    }else{
        ev.target.textContent = 'LESS';
        content.style.display = 'block';
    }
    if(content.hasChildNodes()){
        return;
    }
    const url = 'http://localhost:3030/jsonstore/advanced/articles/details/' + ev.target.id;
    const articlePromise = await fetch(url);
    const article = await articlePromise.json();
    const pElement = createElement('p',{},article.content);
    content.appendChild(pElement);

}

window.addEventListener('load', solution);

function createElement(tagName, attributes, ...content) {
    const element = document.createElement(tagName);

    //add attribute or event listener
    for (let attr in attributes) {
        if (attr.substring(0, 2) === 'on') {
            element.addEventListener(attr.substring(2).toLowerCase(), attributes[attr]);
        } else {
            element[attr] = attributes[attr];
        }
    }

    //add content or append a child element
    content.forEach(c => {
        if (typeof c === "string" || typeof c === 'number') {
            element.textContent = c;
        } else {
            element.appendChild(c)
        }
    });
    return element;
}
