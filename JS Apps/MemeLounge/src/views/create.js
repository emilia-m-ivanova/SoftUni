import {html} from '../../node_modules/lit-html/lit-html.js';
import {addItem} from "../api/data.js";
import {showNotification} from "./notification.js";

const view = (onSubmit) => html`
    <section id="create-meme">
        <form @submit="${onSubmit}" id="create-form">
            <div class="container">
                <h1>Create Meme</h1>
                <label for="title">Title</label>
                <input id="title" type="text" placeholder="Enter Title" name="title">
                <label for="description">Description</label>
                <textarea id="description" placeholder="Enter Description" name="description"></textarea>
                <label for="imageUrl">Meme Image</label>
                <input id="imageUrl" type="text" placeholder="Enter meme ImageUrl" name="imageUrl">
                <input type="submit" class="registerbtn button" value="Create Meme">
            </div>
        </form>
    </section>

`

export async function showCreate(ctx) {
    ctx.render(view(onSubmit));

    async function onSubmit(ev){
        ev.preventDefault();
        const formData = [...new FormData(ev.target).entries()].reduce((acc,[k,v])=>{
            acc[k] = v;
            return acc;
        },{});
        if(Object.values(formData).some(e=>e.length==0)){
            return showNotification("All fields are required!")
        }
        await addItem(formData);
        ctx.page.redirect('/catalog');
    }
}