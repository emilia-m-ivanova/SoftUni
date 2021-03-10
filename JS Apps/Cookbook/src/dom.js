export {createElement}

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