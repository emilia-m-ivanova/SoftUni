import {html} from "../../node_modules/lit-html/lit-html.js";
import {editItem, getItem} from "../api/data.js";


const editView = (car, onSubmit) => html`
    <section id="edit-listing">
        <div class="container">

            <form @submit="${onSubmit}" id="edit-form">
                <h1>Edit Car Listing</h1>
                <p>Please fill in this form to edit an listing.</p>
                <hr>

                <p>Car Brand</p>
                <input type="text" placeholder="Enter Car Brand" name="brand" value="${car.brand}">

                <p>Car Model</p>
                <input type="text" placeholder="Enter Car Model" name="model" value="${car.model}">

                <p>Description</p>
                <input type="text" placeholder="Enter Description" name="description" value="${car.description}">

                <p>Car Year</p>
                <input type="number" placeholder="Enter Car Year" name="year" value="${car.year}">

                <p>Car Image</p>
                <input type="text" placeholder="Enter Car Image" name="imageUrl" value="${car.imageUrl}">

                <p>Car Price</p>
                <input type="number" placeholder="Enter Car Price" name="price" value="${car.price}">

                <hr>
                <input type="submit" class="registerbtn" value="Edit Listing">
            </form>
        </div>
    </section>
`

export async function showEdit(ctx) {
    const id = ctx.params.id;
    const car = await getItem(id);

    ctx.render(editView(car, onSubmit));

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
        await editItem(id, {
            brand: data.brand,
            model: data.model,
            description: data.description,
            year: Number(data.year),
            imageUrl: data.imageUrl,
            price: Number(data.price)
        });
        ctx.page.redirect('/details/' + id);
    }
}