import {html, render} from '../node_modules/lit-html/lit-html.js'

const menu = document.getElementById('menu');
document.querySelector('form').addEventListener('submit', addItem);

let options = await getOptions();
render(optionTemplate(Object.values(options)), menu);

async function getOptions() {
    const url = 'http://localhost:3030/jsonstore/advanced/dropdown';
    const response = await fetch(url);
    if (response.ok) {
        return await response.json();
    }
}

function optionTemplate(options) {
    return html`
        ${options.map(e => html`
            <option value="${e._id}">${e.text}</option>`)}
    `
}

async function addItem(ev) {
    ev.preventDefault();
    const input = document.getElementById('itemText');
    const url = 'http://localhost:3030/jsonstore/advanced/dropdown';
    const response = await fetch(url, {
        method: 'post',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({text: input.value})
    });
    input.value = '';
    if (response.ok) {
        options = await getOptions();
        render(optionTemplate(Object.values(options)), menu);
    }
}
