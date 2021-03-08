import {showHome} from "./loadHome.js";

export {userLogin,setUpLogin}

let loginSection;
let sections;

function setUpLogin(loginParam,sectionsParam){
    loginSection = loginParam;
    sections = sectionsParam;
}
function userLogin(){
    sections.forEach(s=>s.style.display = 'none');
    loginSection.style.display = '';
    loginSection.querySelector('form').addEventListener('submit',onSubmit);
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
    const url = 'http://localhost:3030/users/login';
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
