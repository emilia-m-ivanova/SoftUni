import {html} from '../../node_modules/lit-html/lit-html.js';
import {editItem, getItem} from "../api/data.js";
import {showNotification} from "./notification.js";

const view = (meme,onSubmit) => html`
    <section id="edit-meme">
        <form @submit="${onSubmit}" id="edit-form">
            <h1>Edit Meme</h1>
            <div class="container">
                <label for="title">Title</label>
                <input id="title" type="text" placeholder="Enter Title" name="title" .value="${meme.title}">
                <label for="description">Description</label>
                <textarea id="description" placeholder="Enter Description" name="description">
                           ${meme.description} 
                        </textarea>
                <label for="imageUrl">Image Url</label>
                <input id="imageUrl" type="text" placeholder="Enter Meme ImageUrl" name="imageUrl" .value="${meme.imageUrl}">
                <input type="submit" class="registerbtn button" value="Edit Meme">
            </div>
        </form>
    </section>
`

export async function showEdit(ctx) {
    const id = ctx.params.id;
    const meme = await getItem(id);
    ctx.render(view(meme,onSubmit));

    async function onSubmit(ev){
        ev.preventDefault();
        const formData = [...new FormData(ev.target).entries()].reduce((acc,[k,v])=>{
            acc[k] = v;
            return acc;
        },{});
        if(Object.values(formData).some(e=>e.length==0)){
            return showNotification("All fields are required!")
        }
        await editItem(id,formData);
        ctx.page.redirect('/catalog');
    }
}