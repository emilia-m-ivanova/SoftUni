import {getComments} from "./showContent.js";
export {postComment}

async function postComment(ev,initialComment,postId){
    ev.preventDefault();
    const url = 'http://localhost:3030/jsonstore/collections/myboard/comments';
    const currentDate = new Date();
    const date = currentDate.getDate() + "/"
        + (currentDate.getMonth()+1)  + "/"
        + currentDate.getFullYear() + "T"
        + currentDate.getHours().toString().padStart(2,'0') + ":"
        + currentDate.getMinutes().toString().padStart(2,'0') + ":"
        + currentDate.getSeconds().toString().padStart(2,'0');
    const formData = [...new FormData(ev.target).entries()]
        .reduce((acc,[k,v])=>{
            acc[k] = v;
            return acc;
        },{});
    if(Object.values(formData).some(e=>e==='')){
        return alert('All fields are required!');
    }
    formData.date = date;
    formData.postId = postId;
    const response = await fetch(url,{
        method:'post',
        headers:{
            'Content-Type':'application/json',
        },
        body:JSON.stringify(formData),
    })
    if(response.ok){
        ev.target.reset();
    }else{
        const parsed = await response.json();
        alert(parsed.message);
    }

    getComments(initialComment,postId)
}