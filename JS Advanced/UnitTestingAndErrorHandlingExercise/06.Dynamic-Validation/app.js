function validate() {
    const regExp = /[a-z]+@[a-z]+\.[a-z]/;
    const inputField = document.getElementById('email');
    inputField.addEventListener('change',()=>{
        if(inputField.value.match(regExp)){
            inputField.className = '';
        }else{
            inputField.className = 'error'
        }
    })
}