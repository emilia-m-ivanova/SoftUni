import {html} from "../../node_modules/lit-html/lit-html.js";
import {getItemsByYear} from "../api/data.js";


const searchView = (onClick, cars) => html`
    <section id="search-cars">
        <h1>Filter by year</h1>

        <div class="container">
            <input id="search-input" type="text" name="search" placeholder="Enter desired production year">
            <button @click="${onClick}" class="button-list">Search</button>
        </div>

        <h2>Results:</h2>
        <div class="listings">
            ${cars.length > 0 ? cars.map(car) : html`<p class="no-cars"> No results.</p>`}
        </div>
    </section>
`

const car = (data) => html`
    <div class="listing">
        <div class="preview">
            <img src="${data.imageUrl}">
        </div>
        <h2>${data.brand + ' ' + data.model}</h2>
        <div class="info">
            <div class="data-info">
                <h3>Year: ${data.year}</h3>
                <h3>Price: ${data.price} $</h3>
            </div>
            <div class="data-buttons">
                <a href="/details/${data._id}" class="button-carDetails">Details</a>
            </div>
        </div>
    </div>
`;

export async function showSearch(ctx) {
    const year = ctx.querystring.split('=')[1];
    let cars;
    if(year){
        cars = await getItemsByYear(Number(year));
    }else{
        cars = [];
    }
    ctx.render(searchView(onClick, cars));

    async function onClick() {
        const input = Number(document.getElementById('search-input').value);
        ctx.page.redirect('/search?query=' + input);
    }
}