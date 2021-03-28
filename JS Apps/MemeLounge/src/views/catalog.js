import {html} from '../../node_modules/lit-html/lit-html.js';
import {getItems} from "../api/data.js";

const view = (memes) => html`
    <section id="meme-feed">
        <h1>All Memes</h1>
        <div id="memes">
            ${memes ? memes.map(e => meme(e)) :
                    html`<p class="no-memes">No memes in database.</p>`}
        </div>
    </section>
`

const meme = (meme) => html`
    <div class="meme">
        <div class="card">
            <div class="info">
                <p class="meme-title">${meme.title}</p>
                <img class="meme-image" alt="meme-img" src="${meme.imageUrl}">
            </div>
            <div id="data-buttons">
                <a class="button" href="/details/${meme._id}">Details</a>
            </div>
        </div>
    </div>
`

export async function showCatalog(ctx) {
    const memes = await getItems()
    ctx.render(view(memes));
}