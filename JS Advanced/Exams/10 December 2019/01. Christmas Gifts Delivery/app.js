function solution() {
    document.querySelector('.card button').addEventListener('click', addPresent);
    const input = document.querySelector('.card input');
    const sections = document.querySelectorAll('.card');

    function addPresent(ev) {
        const text = input.value;
        input.value = '';
        const element = createElement('li', {className: 'gift'}, text,
            createElement('button', {className: 'sendButton', onClick: send}, 'Send'),
            createElement('button', {className: 'discardButton', onClick: discard}, 'Discard'));
        const addSection = sections[1].lastElementChild;
        addSection.appendChild(element);
        Array.from(addSection.childNodes)
            .sort((a, b) => a.textContent.localeCompare(b.textContent))
            .forEach(e => addSection.appendChild(e));
    }

    function send(ev) {
        const gift = ev.target.parentNode;
        sections[2].lastElementChild.appendChild(gift);
        gift.childNodes[2].remove();
        ev.target.remove();
    }

    function discard(ev) {
        const gift = ev.target.parentNode;
        sections[3].lastElementChild.appendChild(gift);
        gift.childNodes[1].remove();
        ev.target.remove();
    }

    function createElement(tagName, attributes, ...content) {
        const element = document.createElement(tagName);

        //add attribute or event listener
        for (let attr in attributes) {
            if (attr.substring(0, 2) === 'on') {
                element.addEventListener(attr.substring(2).toLowerCase(), attributes[attr]);
            } else {
                element[attr] = attributes[attr];
            }
        }

        //add content or append a child element
        content.forEach(c => {
            if (typeof c === "string" || typeof c === 'number') {
                element.textContent = c;
            } else {
                element.appendChild(c)
            }
        });
        return element;
    }
}