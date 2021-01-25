function toggle() {
    const button = document.querySelector('.button');
    const text = document.querySelector('#extra');
    if (button.textContent.toLowerCase() === 'more') {
        text.style.display = 'block';
        button.textContent = 'Less'
    } else {
        text.style.display = 'none';
        button.textContent = 'More'
    }
}