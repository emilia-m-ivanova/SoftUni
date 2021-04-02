import {html} from "../../node_modules/lit-html/lit-html.js";
import {login} from "../api/data.js";


const loginView = (onSubmit) => html`
    <section id="login">
        <div class="container">
            <form @submit="${onSubmit}" id="login-form" action="#" method="post">
                <h1>Login</h1>
                <p>Please enter your credentials.</p>
                <hr>

                <p>Username</p>
                <input placeholder="Enter Username" name="username" type="text">

                <p>Password</p>
                <input type="password" placeholder="Enter Password" name="password">
                <input type="submit" class="registerbtn" value="Login">
            </form>
            <div class="signin">
                <p>Dont have an account?
                    <a href="/register">Sign up</a>.
                </p>
            </div>
        </div>
    </section>
`

export function showLogin(ctx) {
    ctx.render(loginView(onSubmit));

    async function onSubmit(ev){
        ev.preventDefault();
        const data = [...new FormData(ev.target).entries()].reduce((acc,[k,v])=>{
            acc[k] = v;
            return acc;
        },{});
        if(data.username.trim()===''||data.password.trim()===''){
            return alert('All fields are required!')
        }
        await login(data.username,data.password);
        ctx.page.redirect('/catalog')
    }
}