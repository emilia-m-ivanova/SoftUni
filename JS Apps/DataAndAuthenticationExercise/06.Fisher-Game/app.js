function attachEvents() {
    const buttons = document.querySelectorAll('input[type="submit"]');
    const loadBtn = document.querySelector('.load');
    const loginBtn = document.getElementById('guest');
    const logoutBtn = document.getElementById('loggedUser');
    if (sessionStorage.getItem('token')) {
        loginBtn.style.display = 'none';
        logoutBtn.style.display = 'inline';
        buttons.forEach(b => b.disabled = false);
    } else {
        loginBtn.style.display = 'inline';
        logoutBtn.style.display = 'none';
        buttons.forEach(b => b.disabled = true);
        loadBtn.disabled = false;
    }
    loadBtn.addEventListener('click', loadCatches);
    logoutBtn.addEventListener('click',logoutUser);
    document.getElementById('addForm').addEventListener('submit', addCatch);
    document.getElementById('catches').addEventListener('click', onClickCatches);
}

async function loadCatches() {
    const url = 'http://localhost:3030/data/catches';
    const response = await fetch(url);
    const data = await response.json();
    if (!response.ok) {
        return alert(data.message);
    }
    const catches = data.map(e => {
        console.log(e)
        return `<div class="catch">
            <form id="${e._id}">
            <label>Angler<input type="text" name="angler" value="${e.angler}"/></label>
            <label>Weight<input type="number" name="weight" value="${e.weight}"/></label>
            <label>Species<input type="text" name="species" value="${e.species}"/></label>
            <label>Location<input type="text" name="location" value="${e.location}"/></label>
            <label>Bait <input type="text" name="bait"value="${e.bait}"/></label>
            <label>Capture Time<input type="number" name="captureTime"value="${e.captureTime}"/></label>
            <input type="submit" value="UPDATE"></input>
            <input type="button" id="${e._id}" value="DELETE"></input>
            </form>
            </div>`
    }).join('');
    document.getElementById('catches').innerHTML = catches;
}

async function logoutUser(){
    const url = 'http://localhost:3030/users/logout';
    const response = await fetch(url, {
        method: 'get',
        headers: {
            'X-Authorization': sessionStorage.token,
        },
    });
    if (response.ok) {
        sessionStorage.clear();
        location.reload();
    }else {
        const parsed = response.json();
        alert(parsed.message);
    }

}

async function addCatch(ev) {
    ev.preventDefault();
    const url = 'http://localhost:3030/data/catches';
    const formData = [...new FormData(ev.target).entries()];
    const body = JSON.stringify(formData.reduce((acc, [k, v]) => {
        acc[k] = v;
        return acc
    }, {}))
    const response = await fetch(url, {
        method: 'post',
        headers: {
            'Content-Type': 'application/json',
            'X-Authorization': sessionStorage.token
        },
        body
    });
    const parsed = await response.json();
    if (response.ok) {
        loadCatches();
    } else {
        alert(parsed.message);
    }
}

function onClickCatches(ev) {
    if (ev.target.type === 'button') {
        deleteCatch(ev.target.id)
    } else if (ev.target.type === 'submit') {
        ev.preventDefault();
        updateCatch(ev.target.parentNode)
    }
}

async function deleteCatch(id) {
    const url = 'http://localhost:3030/data/catches/' + id;
    const response = await fetch(url, {
        method: 'delete',
        headers: {
            'Content-Type': 'application/json',
            'X-Authorization': sessionStorage.token
        }
    });
    if (!response.ok) {
        const parsed = await response.json();
        return alert(parsed.message);
    }
    loadCatches();
}

async function updateCatch(form){
    const url = 'http://localhost:3030/data/catches/' + form.id;
    const formData = [...new FormData(form).entries()];
    const body = JSON.stringify(formData.reduce((acc, [k, v]) => {
        acc[k] = v;
        return acc
    }, {}))
    const response = await fetch(url, {
        method: 'put',
        headers: {
            'Content-Type': 'application/json',
            'X-Authorization': sessionStorage.token
        },
        body
    });
    const parsed = await response.json();
    if (response.ok) {
        loadCatches();
    } else {
        alert(parsed.message);
    }
}

attachEvents();

