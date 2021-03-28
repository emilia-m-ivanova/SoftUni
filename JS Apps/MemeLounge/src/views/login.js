import {html} from '../../node_modules/lit-html/lit-html.js';
import {login} from "../api/data.js";
import {showNotification} from "./notification.js";

const view = (onSubmit) => html`
    <section id="login">
        <form @submit="${onSubmit}" id="login-form">
            <div class="container">
                <h1>Login</h1>
                <label for="email">Email</label>
                <input id="email" placeholder="Enter Email" name="email" type="text">
                <label for="password">Password</label>
                <input id="password" type="password" placeholder="Enter Password" name="password">
                <input type="submit" class="registerbtn button" value="Login">
                <div class="container signin">
                    <p>Dont have an account?<a href="/register">Sign up</a>.</p>
                </div>
            </div>
        </form>
    </section>
`

export async function showLogin(ctx) {
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
        await login(formData.email, formData.password);
        ctx.page.redirect('/catalog');
    }
}
