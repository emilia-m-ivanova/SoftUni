document.getElementById('loadBooks').addEventListener('click', loadBooks);
const submitBtn = document.getElementById('submitBtn');
submitBtn.addEventListener('click', addBook);
const title = document.querySelector('input[name="title"]');
const author = document.querySelector('input[name="author"]');

async function loadBooks() {
    const table = document.querySelector('tbody');
    table.innerHTML = '';
    const url = 'http://localhost:3030/jsonstore/collections/books';
    const response = await fetch(url);
    const parsed = await response.json();
    Object.entries(parsed)
        .map(e => {
            return createElement('tr', {},
                createElement('td', {}, e[1].title),
                createElement('td', {}, e[1].author),
                createElement('button', {onClick: () => editBook(e[0], e[1].title, e[1].author)}, 'Edit'),
                createElement('button', {onClick: () => deleteBook(e[0])}, 'Delete'))
        })
        .forEach(e => table.appendChild(e));
}

async function editBook(id, currentTitle, currentAuthor) {
    title.value = currentTitle;
    author.value = currentAuthor;
    const url = 'http://localhost:3030/jsonstore/collections/books/' + id;
    const saveBtn = createElement('button', {onClick: (ev) => saveChanges(ev, url)}, 'Save');
    submitBtn.replaceWith(saveBtn);
    document.getElementById('formHeading').textContent = 'Edit FORM';
}

async function saveChanges(ev, url) {
    ev.preventDefault();
    const response = await fetch(url, {
        method: 'put',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            author: author.value,
            title: title.value,
        },)
    });
    if (!response.ok) {
        return alert(response.message);
    }
    title.value = '';
    author.value = '';
    ev.target.replaceWith(submitBtn);
    document.getElementById('formHeading').textContent = 'FORM';
    await loadBooks();
}

async function deleteBook(id) {
    const url = 'http://localhost:3030/jsonstore/collections/books/' + id;
    const response = await fetch(url, {
        method: 'delete',
        headers: {
            'Content-Type': 'application/json'
        }
    });
    if (!response.ok) {
        return alert(response.message);
    }
    await loadBooks();
}

async function addBook(ev) {
    ev.preventDefault();
    const url = 'http://localhost:3030/jsonstore/collections/books';
    const response = await fetch(url, {
        method: 'post',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            author: author.value,
            title: title.value,
        },)
    });
    if (!response.ok) {
        return alert(response.message);
    }
    title.value = '';
    author.value = '';

    await loadBooks();
}

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