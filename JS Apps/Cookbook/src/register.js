const registerForm = document.querySelector('form');
registerForm.addEventListener('submit', (ev)=>{
    ev.preventDefault();
    const input = [...new FormData(ev.target).entries()];
    const data = input.reduce((acc,c)=>{
       acc[c[0]] = c[1];
       return acc;
    },{})
    register(data);
});

async function register(data) {
    if(data.password!==data.rePass){
        return alert('Passwords don\'t match');
    }
    const url = 'http://localhost:3030/users/register';
    const response = await fetch(url, {
        method: 'post',
        headers: {
            'Content-Type': 'application/json'
        },
        body:JSON.stringify({
            email:data.email,
            password:data.password
        })
    });
    const parsed = await response.json();
    if(response.ok){
        sessionStorage.setItem('userToken',parsed.accessToken);
        location.pathname = location.pathname.replace('register','index');
    }else{
        alert(parsed.message);
    }
}
