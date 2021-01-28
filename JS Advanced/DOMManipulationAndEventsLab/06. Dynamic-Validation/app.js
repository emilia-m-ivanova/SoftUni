function validate() {
   const regExp = /^[a-z]+@[a-z]+.[a-z]+$/;
   const email = document.querySelector('#email');

    function onChange() {
        if(email.value.match(regExp)){
            email.className = '';
        }else{
            email.className = 'error';
        }
    }
    email.addEventListener('change',onChange)
}