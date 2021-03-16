import {html, render} from '../node_modules/lit-html/lit-html.js';
import {cats as catsData} from './catSeeder.js'


const cat = (data) => html`
    <li>
        <img src="./images/${data.imageLocation}.jpg" width="250" height="250" alt="Card image cap">
        <div class="info">
            <button class="showBtn">${(data.visible ? 'Hide' : 'Show') + ' status code'}</button>
            <div class="status" style="display: ${data.visible ? '' : 'none'}" id="${data.id}">
                <h4>Status Code: ${data.statusCode}</h4>
                <p>${data.statusMessage}</p>
            </div>
        </div>
    </li>`

const cats = (catsData) => html`
    <ul>
        ${catsData.map(cat)}
    </ul>
`

const mainEl = document.getElementById('allCats');
mainEl.addEventListener('click', (ev) => {
    if (ev.target.tagName === 'BUTTON') {
        const details = ev.target.parentNode.querySelector('.status');
        const id = details.id;
        const cat = catsData.find(c => c.id === id);
        cat.visible = !cat.visible;
        render(cats(catsData), mainEl);
    }
})

catsData.forEach(c => {
    c.visible = false
});
render(cats(catsData), mainEl);