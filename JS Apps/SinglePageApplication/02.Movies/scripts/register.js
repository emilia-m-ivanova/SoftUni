import {showHome} from "./loadHome.js";

export {userRegister,setUpRegister}

let registerSection;
let sections;

function setUpRegister(registerParam,sectionsParam){
    registerSection = registerParam;
    sections = sectionsParam;
}
function userRegister(){
    sections.forEach(s=>s.style.display = 'none');
    registerSection.style.display = '';
    registerSection.querySelector('form').addEventListener('submit',onSubmit);
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
    if(data.password.length<6){
        return alert('Password must be at least 6 symbols long!')
    }
    if(data.password!==data.repeatPassword){
        return alert('Passwords don\'t match!')
    }
    const url = 'http://localhost:3030/users/register';
    const response = await fetch(url,{
        method:'post',
        headers:{
            'Content-Type':'application/json'
        },
        body:JSON.stringify(data),
    })
    const parsed = await response.json();
    if(response.ok){
        sessionStorage.userToken = parsed.accessToken;
        sessionStorage.email = parsed.email;
        sessionStorage.id = parsed._id;
    }else{
        return alert(parsed.message);
    }
    showHome();
}