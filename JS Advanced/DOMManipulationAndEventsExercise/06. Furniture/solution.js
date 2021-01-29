function solve() {
    const [inputArea, output] = document.querySelectorAll('textarea');
    const [generateBtn, buyBtn] = document.querySelectorAll('#exercise button');
    generateBtn.addEventListener('click', generate);
    buyBtn.addEventListener('click', buyProducts);
    const added = [];

    function buyProducts() {
        let bought = [];
        added.forEach(f => {
            if (f.isChecked() === true) {
                bought.push(f.values());
            }
        })
        bought = bought.reduce((acc, el) => {
            acc.name.push(el.name);
            acc.price += Number(el.price);
            acc.decFactor += Number(el.decFactor);
            return acc;
        }, {name: [], price: 0, decFactor: 0});
        console.log(bought);
        output.value += `Bought furniture: ${bought.name.join(', ')}\nTotal price: ${bought.price.toFixed(2)}\nAverage decoration factor: ${bought.decFactor / bought.name.length}`;
    }

    function generate() {
        const furniture = JSON.parse(inputArea.value);
        furniture.forEach(f => {
            const row = createRow(f);
            added.push(row);
            document.querySelector('tbody').appendChild(row.el);
        });
    }

    function createRow(inputLine) {
        const picture = createElement('img');
        picture.src = inputLine.img;
        const checkBox = createElement('input')
        checkBox.type = 'checkbox';
        const el = createElement('tr',
            createElement('td', picture),
            createElement('td', createElement('p', inputLine.name)),
            createElement('td', createElement('p', inputLine.price)),
            createElement('td', createElement('p', inputLine.decFactor)),
            createElement('td', checkBox)
        );

        return{el, isChecked,values};

        function isChecked() {
            return checkBox.checked;
        }

        function values(){
            return inputLine;
        }
    }

    function createElement(tagName, ...content) {
        const element = document.createElement(tagName);
        content.forEach(c => {
            if (typeof c === "string"|| typeof c === 'number') {
                element.textContent = c;
            } else {
                element.appendChild(c)
            }
        });
        return element;
    }
}