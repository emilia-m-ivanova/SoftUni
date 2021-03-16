import {html, render} from '../node_modules/lit-html/lit-html.js'

async function solve() {
    const input = document.querySelector('#searchField');
    const table = document.querySelector('tbody');
    let data = await getData();
    document.querySelector('#searchBtn').addEventListener('click', () => onClick(input, data, table));
    render(tableTemplate(Object.values(data)), table)
}

function tableTemplate(data) {
    return html`
        ${data.map(e => html`
            <tr class=${e.active ? 'select' : ''}>
                <td>${e.firstName} ${e.lastName}</td>
                <td>${e.email}</td>
                <td>${e.course}</td>
            </tr>`)}
    `
}

async function getData() {
    const url = 'http://localhost:3030/jsonstore/advanced/table';
    const response = await fetch(url);
    if (response.ok) {
        return await response.json();
    }
}

function onClick(input, data, table) {
    Object.entries(data).map(([k, v]) => {
        Object.values(v).some(e =>
            typeof e !== 'boolean' && e.toLowerCase().includes(input.value.toLowerCase()) ?
                data[k].active = true :
                data[k].active = false)
    });
    render(tableTemplate(Object.values(data)), table)
}

solve();