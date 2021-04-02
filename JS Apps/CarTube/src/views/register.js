import {html} from "../../node_modules/lit-html/lit-html.js";
import {register} from "../api/data.js";


const registerView = (onSubmit) => html`
    <section id="register">
        <div class="container">
            <form @submit="${onSubmit}" id="register-form">
                <h1>Register</h1>
                <p>Please fill in this form to create an account.</p>
                <hr>

                <p>Username</p>
                <input type="text" placeholder="Enter Username" name="username" required>

                <p>Password</p>
                <input type="password" placeholder="Enter Password" name="password" required>

                <p>Repeat Password</p>
                <input type="password" placeholder="Repeat Password" name="repeatPass" required>
                <hr>

                <input type="submit" class="registerbtn" value="Register">
            </form>
            <div class="signin">
                <p>Already have an account?
                    <a href="/login">Sign in</a>.
                </p>
            </div>
        </div>
    </section>
`

export function showRegister(ctx) {
    ctx.render(registerView(onSubmit));

    async function onSubmit(ev){
        ev.preventDefault();
        const data = [...new FormData(ev.target).entries()].reduce((acc,[k,v])=>{
            acc[k] = v;
            return acc;
        },{});
        if(data.username.trim()===''||data.password.trim()===''||data.repeatPass.trim()===''){
            return alert('All fields are required!')
        }
        if(data.password!==data.repeatPass){
            return alert('Passwords don\'t match!')
        }
        await register(data.username,data.password);
        ctx.page.redirect('/catalog')
    }
}