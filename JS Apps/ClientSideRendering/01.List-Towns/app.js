import {html, render} from '../node_modules/lit-html/lit-html.js';

const towns = (input) => html`
    <ul>
        ${input.map(e => html`<li>${e}</li>`)}
    </ul>
`;

document.getElementById('btnLoadTowns').addEventListener('click',(ev)=>{
    ev.preventDefault();
    const input = document.getElementById('towns').value
        .split(/\s*,\s*/);
    render(towns(input),document.getElementById('root'));
})