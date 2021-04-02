import {html} from "../../node_modules/lit-html/lit-html.js";
import {getItems} from "../api/data.js";


const catalogView = (cars) => html`
    <section id="car-listings">
        <h1>Car Listings</h1>
        <div class="listings">
            ${cars.length > 0 ? cars.map(car) : html`<p class="no-cars">No cars in database.</p>`}
        </div>
    </section>
`;
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

export async function showCatalog(ctx) {
    const items = await getItems();
    ctx.render(catalogView(items));
}