export {logOut}
import {loadRecipes} from "./loadRecipes.js";

async function logOut() {
    const url = 'http://localhost:3030/users/logout';
    const response = await fetch(url, {
        method: 'get',
        headers: {
            'X-Authorization': sessionStorage.userToken,
        },
    });
    if (response.ok) {
        sessionStorage.clear();
        loadRecipes();
    } else {
        const parsed = response.json();
        alert(parsed.message);
    }
}