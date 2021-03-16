import {html, render} from '../node_modules/lit-html/lit-html.js'
import {towns as data} from './towns.js';

document.querySelector('button').addEventListener('click', search);

const towns = (data, match = '') => html`
    <ul>
        ${data.map(e => townTemplate(e, match))}
    </ul>
`

function townTemplate(t, match) {
    return html`
        <li class="${match !== '' && t.toLowerCase().includes(match.toLowerCase()) ? 'active' : ''}">${t}</li>`
}

function resultTemplate(n) {
    return html`
        <p>${n + (n === 1 ? ' match found' : ' matches found')}</p>`
}

const div = document.getElementById('towns');

function search() {
    const input = document.getElementById('searchText').value;
    const result = document.getElementById('result');
    const count = data.filter(e => e.toLowerCase().includes(input.toLowerCase())).length;
    render(resultTemplate(count), result);
    render(towns(data, input), div);
}

render(towns(data), div);


