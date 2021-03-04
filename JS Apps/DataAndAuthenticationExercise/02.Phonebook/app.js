const contactList = document.getElementById('phonebook');
const personName = document.getElementById('person');
const phoneNumber = document.getElementById('phone');

function attachEvents() {
    document.getElementById('btnLoad').addEventListener('click', loadContacts);
    document.getElementById('btnCreate').addEventListener('click', createContact);
}

async function loadContacts() {
    contactList.innerHTML = '';
    const url = 'http://localhost:3030/jsonstore/phonebook';
    const response = await fetch(url);
    const parsed = await response.json();
    Object.values(parsed)
        .forEach(e => {
            const liElement = createElement('li', {}, `${e.person}: ${e.phone}`,
                createElement('button', {onClick: () => deleteContact(e['_id'])}, 'Delete'));
            contactList.appendChild(liElement);
        })
}

async function deleteContact(id) {
    const url = 'http://localhost:3030/jsonstore/phonebook/' + id;
    const response = await fetch(url, {
        method: 'delete',
        headers: {
            'Content-Type': 'application/json'
        }
    });
    const parsed = await response.json();
    console.log(parsed);
    loadContacts();
}

async function createContact() {
    const url = 'http://localhost:3030/jsonstore/phonebook';
    const response = await fetch(url, {
        method: 'post',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            person: personName.value,
            phone: phoneNumber.value,
        })
    });
    personName.value = '';
    phoneNumber.value = '';
    loadContacts();
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

attachEvents();