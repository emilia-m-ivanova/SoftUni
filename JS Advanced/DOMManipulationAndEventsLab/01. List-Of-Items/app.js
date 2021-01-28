function addItem() {
    const input = document.querySelector('#newItemText').value;
    document.querySelector('#newItemText').value = '';
    const newElement = document.createElement('li');
    newElement.appendChild(document.createTextNode(input));
    document.querySelector('#items').appendChild(newElement);
}