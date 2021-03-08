import {showDetails} from "./movieDetails.js";

export {edit, setUpEdit};

let editSection;
let sections;
let id;
const url = 'http://localhost:3030/data/movies/';

function setUpEdit(editParam, sectionsParam) {
    editSection = editParam;
    sections = sectionsParam;
}

async function edit(ev) {
    const parent = ev.target.parentNode;
    id = parent.id;
    sections.forEach(s => s.style.display = 'none');
    editSection.style.display = '';
    const form = editSection.querySelector('form');
    form.addEventListener('submit', onSubmit);
    const response = await fetch(url + id);
    const data = await response.json();
    const [title,img] = [...form.querySelectorAll('input')];
    const description = form.querySelector('textarea');
    title.value = data.title;
    img.value = data.img;
    description.value = data.description;

}


async function onSubmit(ev){
    ev.preventDefault();
    const data = [...new FormData(ev.target).entries()]
        .reduce((acc,[k,v])=>{
            acc[k]=v;
            return acc;
        },{});
    if(Object.values(data).some(e=>e==='')){
        return alert('All fields are required!')
    }
    const response = await fetch(url + id,{
        method:'put',
        headers:{
            'Content-Type':'application/json',
            'X-Authorization':sessionStorage.userToken,
        },
        body:JSON.stringify(data),
    })
    const parsed = await response.json();
    if(response.ok){
        await showDetails(id);
    }else{
        return alert(parsed.message);
    }
}
