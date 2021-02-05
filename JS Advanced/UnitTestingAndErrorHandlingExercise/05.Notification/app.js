function notify(message) {
    const box = document.getElementById('notification');
    box.textContent = message;
    box.style.display = 'block';
    box.addEventListener('click',()=>{
      box.style.display = 'none';
  })
}