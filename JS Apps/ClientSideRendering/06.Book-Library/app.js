import {html, render} from '../node_modules/lit-html/lit-html.js';
import * as api from './api.js';

let data;

function mainTemplate(data, selectedBook) {
    return html`
        <button @click="${onClick}" id="loadBooks">LOAD ALL BOOKS</button>
        <table>
            <thead>
            <tr>
                <th>Title</th>
                <th>Author</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            ${data ? data.map(rowTemplate) : ''}
            </tbody>
        </table>
        ${formTemplate(selectedBook)}`
}

function rowTemplate(book) {
    return html`
        <tr>
            <td>${Object.values(book)[0].title}</td>
            <td>${Object.values(book)[0].author}</td>
            <td>
                <button @click="${() => onEdit(book)}">Edit</button>
                <button @click="${()=>onDelete(Object.keys(book)[0])}" >Delete</button>
            </td>
        </tr>
    `
}

function formTemplate(item) {
    return html`
        <form id="${item ? 'edit-form' : 'add-form'}">
            <h3>${item ? 'Edit book' : 'Add book'}</h3>
            <label>TITLE</label>
            <input type="text" name="title" .value=${item ? Object.values(item)[0].title : ''} placeholder="Title...">
            <label>AUTHOR</label>
            <input type="text" name="author" .value=${item ? Object.values(item)[0].author : ''}
                   placeholder="Author...">
            <input type="submit" @click=${(ev) => onSubmit(ev, item ? Object.keys(item)[0] : '')}
                   value="${item ? 'Save' : 'Submit'}">
        </form>`
}

async function onSubmit(ev, id) {
    ev.preventDefault();
    const form = ev.target.parentNode;
    const formData = [...new FormData(form).entries()].reduce((acc, [k, v]) => {
        acc[k] = v;
        return acc;
    }, {});
    if (id) {
        await api.editBook(formData, id);
    } else {
        await api.addBook(formData);
    }
    form.reset();
    data = await api.getAllBooks();
    render(mainTemplate(data), body);
}

async function onClick() {
    data = await api.getAllBooks();
    render(mainTemplate(data), body);
}

function onEdit(book) {
    render(mainTemplate(data, book), body);
}

async function onDelete(id) {
    const confirmation = confirm('Are you sure you want to delete this book?');
    if(!confirmation){
        return;
    }
    await api.del(id);
    data = await api.getAllBooks();
    render(mainTemplate(data), body);
}

const body = document.querySelector('body');

render(mainTemplate(), body);