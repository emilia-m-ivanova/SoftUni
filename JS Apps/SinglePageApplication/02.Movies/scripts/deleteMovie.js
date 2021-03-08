import {showHome} from "./loadHome.js";

export {deleteMovie};

async function deleteMovie(ev){
    const confirmation = confirm("Are you sure you want to delete this movie?");
    if(!confirmation){
        return;
    }
    const parent = ev.target.parentNode;
    const url = 'http://localhost:3030/data/movies/' + parent.id;
    const response = await fetch(url,{
        method:'delete',
        headers:{
            'X-Authorization':sessionStorage.userToken,
        }
    });
    const parsed = response.json();
    if(response.ok){
        showHome()
    }else{
        alert(parsed.message);
    }
}