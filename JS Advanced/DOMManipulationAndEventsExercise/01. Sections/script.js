function create(words) {
    words.forEach(word => {
        const divElement = document.createElement('div');
        divElement.appendChild(document.createElement('p'));
        divElement.firstChild.textContent = word;
        divElement.firstChild.style.display = 'none';
        divElement.addEventListener('click',()=>{
            divElement.firstChild.style.display = 'block';
        })
        document.querySelector('#content').appendChild(divElement);
    })
}