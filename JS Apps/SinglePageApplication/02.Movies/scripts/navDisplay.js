export {setNavDisplay};

function setNavDisplay(addButton,loginLink,logoutLink,registerLink,greeting){
    if(sessionStorage.getItem('userToken')){
        addButton.style.display = '';
        logoutLink.style.display = '';
        loginLink.style.display = 'none';
        registerLink.style.display = 'none';
        greeting.style.display = '';
        greeting.textContent = 'Welcome, ' + sessionStorage.email;
    }else {
        addButton.style.display = 'none';
        logoutLink.style.display = 'none';
        loginLink.style.display = '';
        registerLink.style.display = '';
        greeting.style.display = 'none';
    }
}