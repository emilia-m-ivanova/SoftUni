function solve() {
    const selectMenu = document.querySelector('#selectMenuTo');
    const hexa = document.createElement('option');
    hexa.setAttribute('value','hexadecimal');
    hexa.textContent = 'Hexadecimal';
    selectMenu.appendChild(hexa);
    const binary = document.createElement('option');
    binary.setAttribute('value','binary');
    binary.textContent = 'Binary';
    selectMenu.appendChild(binary);

    function onClick() {
        let number = Number(document.querySelector('#input').value);
        if(selectMenu.value ==='hexadecimal'){
            number = number.toString(16).toUpperCase();
        }else{
            number = number.toString(2);
        }
        document.querySelector('#result').value = number;
    }
    document.querySelector('button').addEventListener("click", onClick);
}