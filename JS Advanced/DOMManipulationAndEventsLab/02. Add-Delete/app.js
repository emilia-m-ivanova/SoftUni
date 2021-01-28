function addItem() {
    const input = document.querySelector('#newText').value;
    if (input.length === 0 ){
        return;
    }
    document.querySelector('#newText').value = '';

    const newElement = document.createElement('li');
    newElement.appendChild(document.createTextNode(input));

    const aElement = document.createElement("a");
    aElement.appendChild(document.createTextNode("[Delete]"));
    aElement.href = '#';
    aElement.addEventListener('click',()=>newElement.remove());

    newElement.appendChild(aElement);
    document.querySelector('#items').appendChild(newElement);
}