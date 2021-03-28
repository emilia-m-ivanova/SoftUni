import {html} from '../../node_modules/lit-html/lit-html.js';
import {getItemsByOwner} from "../api/data.js";

const view = (memes) => html`
    <section id="user-profile-page" class="user-profile">
        <article class="user-info">
            <img id="user-avatar-url" alt="user-profile" src="/images/${sessionStorage.getItem('gender')}.png">
            <div class="user-content">
                <p>Username: ${sessionStorage.getItem('username')}</p>
                <p>Email: ${sessionStorage.getItem('email')}</p>
                <p>My memes count: ${memes.length}</p>
            </div>
        </article>
        <h1 id="user-listings-title">User Memes</h1>
        <div class="user-meme-listings">
            ${memes.length > 0 ? memes.map(meme)
                    : html`<p class="no-memes">No memes in database.</p>`}
        </div>
    </section>
`

const meme = (data) => html`
    <div class="user-meme">
        <p class="user-meme-title">${data.title}</p>
        <img class="userProfileImage" alt="meme-img" src="${data.imageUrl}">
        <a class="button" href="/details/${data._id}">Details</a>
    </div>
`

export async function showProfile(ctx) {
    const id = sessionStorage.getItem('userId');
    const memes = await getItemsByOwner(id);
    ctx.render(view(memes));
}