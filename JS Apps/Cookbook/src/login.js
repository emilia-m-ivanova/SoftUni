document.querySelector('form').addEventListener('submit', (ev) => {
    ev.preventDefault();
    const formData = [...new FormData(ev.target).entries()];
    const data = formData.reduce((acc, current) => {
        acc[current[0]] = current[1];
        return acc;
    }, {});
    login(data);
})

async function login(data) {
    const url = 'http://localhost:3030/users/login';
    const response = await fetch(url, {
        method: 'post',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });
    const parsed = await response.json();
    if (response.ok) {
        sessionStorage.setItem('userToken', parsed.accessToken);
        location.pathname = location.pathname.replace('login', 'index');
    } else {
        alert(parsed.message);
    }
}