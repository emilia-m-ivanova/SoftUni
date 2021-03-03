function loadPage() {
    if (sessionStorage.getItem('userToken') !== null) {
        document.getElementById('user').style.display = 'inline';
    } else {
        document.getElementById('guest').style.display = 'inline';
    }
    document.getElementById('logoutBtn').addEventListener('click', logOut);
    loadRecipes();
}

async function loadRecipes() {
    const url = 'http://localhost:3030/data/recipes';
    const body = document.querySelector('main');
    try {
        const response = await fetch(url)
        const data = await response.json();
        body.innerHTML = '';
        Object.values(data).forEach(e => {
            const img = createElement('img', {src: e.img});
            const name = createElement('h2', {}, e.name);
            const element = createElement('article', {className: 'preview'},
                createElement('div', {className: 'title'},
                    name),
                createElement('div', {className: 'small'},
                    img));
            element.addEventListener('click', () => showDetails(element, e._id, name, img));
            body.appendChild(element);
        })
    } catch (error) {
        alert(error.message);
    }
}

function showDetails(current, id, name, img) {
    const url = 'http://localhost:3030/data/recipes/' + id;
    current.innerHTML = '';
    current.className = '';
    current.appendChild(name);
    const ulElement = createElement('ul', {});


    const div1 = createElement('div', {className: 'band'},
        createElement('div', {className: 'thumb'}, img),
        createElement('div', {className: 'ingredients'},
            createElement('h3', {}, 'Ingredients'),
            ulElement))
    const div2 = createElement('div', {className: 'description'},
        createElement('h3', {}, 'Preparation:'));


    fetch(url)
        .then(r => r.json())
        .then(r => {
            r.steps.forEach(e => {
                const pElement = createElement('p', {}, e);
                div2.appendChild(pElement);
            })
            r.ingredients.forEach(e => {
                const liElement = createElement('li', {}, e);
                ulElement.appendChild(liElement);
            })
        });


    current.appendChild(div1);
    current.appendChild(div2);
}

async function logOut() {
    const url = 'http://localhost:3030/users/logout';
    const response = await fetch(url, {
        method: 'get',
        headers: {
            'X-Authorization': sessionStorage.userToken,
        },
    });
    if (response.ok) {
        sessionStorage.clear();
        location.pathname = location.pathname.replace('login', 'index');
    }else {
        const parsed = response.json();
        alert(parsed.message);
    }
}

window.addEventListener('load', () => {
    loadPage();
})

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