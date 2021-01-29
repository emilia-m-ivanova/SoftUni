function addItem() {
    const text = document.querySelector('#newItemText');
    const value = document.querySelector('#newItemValue');
    const select = document.querySelector('#menu');
    const newOption = document.createElement('option');
    newOption.textContent = text.value;
    newOption.value = value.value;
    text.value = '';
    value.value = '';
    select.appendChild(newOption);
}