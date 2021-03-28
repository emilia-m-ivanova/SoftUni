import {html} from '../../node_modules/lit-html/lit-html.js';
import {register} from "../api/data.js";
import {showNotification} from "./notification.js";

const view = (onSubmit) => html`
    <section id="register">
        <form @submit="${onSubmit}" id="register-form">
            <div class="container">
                <h1>Register</h1>
                <label for="username">Username</label>
                <input id="username" type="text" placeholder="Enter Username" name="username">
                <label for="email">Email</label>
                <input id="email" type="text" placeholder="Enter Email" name="email">
                <label for="password">Password</label>
                <input id="password" type="password" placeholder="Enter Password" name="password">
                <label for="repeatPass">Repeat Password</label>
                <input id="repeatPass" type="password" placeholder="Repeat Password" name="repeatPass">
                <div class="gender">
                    <input type="radio" name="gender" id="female" value="female">
                    <label for="female">Female</label>
                    <input type="radio" name="gender" id="male" value="male" checked>
                    <label for="male">Male</label>
                </div>
                <input type="submit" class="registerbtn button" value="Register">
                <div class="container signin">
                    <p>Already have an account?<a href="/login">Sign in</a>.</p>
                </div>
            </div>
        </form>
    </section>
`

export async function showRegister(ctx) {
    ctx.render(view(onSubmit));

    async function onSubmit(ev){
        ev.preventDefault();
        const formData = [...new FormData(ev.target).entries()].reduce((acc,[k,v])=>{
            acc[k] = v;
            return acc;
        },{});
        if(!formData.email|| !formData.password ||!formData.repeatPass || !formData.gender){
            return showNotification('All fields are required!')
        }
        if(formData.password!==formData.repeatPass){
            return showNotification('Passwords don\'t match!')
        }
        await register(formData.email, formData.password, formData.gender);
        ctx.page.redirect('/catalog');
    }
}