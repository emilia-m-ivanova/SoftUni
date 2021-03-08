import {showHome} from "./loadHome.js";

export {addMovie,setUpAdd};

let addSection;
let sections;

function setUpAdd(addParam,sectionsParam){
    addSection = addParam;
    sections = sectionsParam;
}
function addMovie(){
    sections.forEach(s=>s.style.display = 'none');
    addSection.style.display = '';
    addSection.querySelector('form').addEventListener('submit',onSubmit);
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
    const url = 'http://localhost:3030/data/movies';
    const response = await fetch(url,{
        method:'post',
        headers:{
            'Content-Type':'application/json',
            'X-Authorization':sessionStorage.userToken,
        },
        body:JSON.stringify(data),
    })
    const parsed = await response.json();
    if(response.ok){
        showHome();
    }else{
        return alert(parsed.message);
    }
}

