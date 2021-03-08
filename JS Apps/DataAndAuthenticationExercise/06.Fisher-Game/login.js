function attachEvents() {
    const [registerForm, loginForm] = document.querySelectorAll('form');
    loginForm.addEventListener('submit', loginUser);
    registerForm.addEventListener('submit', registerUser);
}

function registerUser(ev) {
    const url = ' http://localhost:3030/users/register';
    ev.preventDefault();
    const formData = [...new FormData(ev.target).entries()];
    if(formData[1][1]!==formData[2][1]){
        return alert('Passwords don\'t match');
    }
    setUserCredentials(url, formData.slice(0, 2));
}

function loginUser(ev) {
    const url = ' http://localhost:3030/users/login';
    ev.preventDefault();
    const formData = [...new FormData(ev.target).entries()];
    setUserCredentials(url, formData);
}

async function setUserCredentials(url, formData) {
    const body = JSON.stringify(formData.reduce((acc, [k, v]) => {
        acc[k] = v;
        return acc;
    }, {}));
    const response = await fetch(url, {
        method: 'post',
        headers: {
            'Content-Type': 'application/json'
        },
        body
    });
    const parsed = await response.json();
    if (response.ok) {
        sessionStorage.setItem('token', parsed.accessToken);
        window.location.pathname = window.location.pathname.replace('login','index')
    } else {
        alert(parsed.message);
    }
}


attachEvents();