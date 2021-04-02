import {html} from "../../node_modules/lit-html/lit-html.js";
import {addItem} from "../api/data.js";


const createView = (onSubmit) => html`
    <section id="create-listing">
        <div class="container">
            <form @submit="${onSubmit}" id="create-form">
                <h1>Create Car Listing</h1>
                <p>Please fill in this form to create an listing.</p>
                <hr>

                <p>Car Brand</p>
                <input type="text" placeholder="Enter Car Brand" name="brand">

                <p>Car Model</p>
                <input type="text" placeholder="Enter Car Model" name="model">

                <p>Description</p>
                <input type="text" placeholder="Enter Description" name="description">

                <p>Car Year</p>
                <input type="number" placeholder="Enter Car Year" name="year">

                <p>Car Image</p>
                <input type="text" placeholder="Enter Car Image" name="imageUrl">

                <p>Car Price</p>
                <input type="number" placeholder="Enter Car Price" name="price">

                <hr>
                <input type="submit" class="registerbtn" value="Create Listing">
            </form>
        </div>
    </section>
`

export function showCreate(ctx) {
    ctx.render(createView(onSubmit));

    async function onSubmit(ev) {
        ev.preventDefault();
        const data = [...new FormData(ev.target).entries()].reduce((acc, [k, v]) => {
            acc[k] = v;
            return acc;
        }, {});
        if (Object.values(data).some(e => e === '')) {
            return alert('All fields are required!');
        }
        if (Number(data.year) <= 0) {
            return alert('Year cannot be negative!');
        }
        if (Number(data.price) <= 0) {
            return alert('Price cannot be negative!');
        }
        await addItem({
            brand: data.brand,
            model: data.model,
            description: data.description,
            year: Number(data.year),
            imageUrl: data.imageUrl,
            price: Number(data.price)
        });
        ctx.page.redirect('/catalog')
    }
}