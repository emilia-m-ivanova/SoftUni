import {showDetails} from "./movieDetails.js";

export {like};

async function like(ev) {
    const parent = ev.target.parentNode;
    const id = parent.id;
    const url = 'http://localhost:3030/data/likes';
    const response = await fetch(url, {
        method: 'post',
        headers: {
            'Content-Type': 'application/json',
            'X-Authorization': sessionStorage.userToken,
        },
        body: JSON.stringify({movieId: id})
    });
    if (response.ok) {
        await showDetails(id);
    } else {
        const parsed = await response.json();
        alert(parsed.message);
    }
}