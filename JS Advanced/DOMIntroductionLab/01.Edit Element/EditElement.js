function editElement(element, match, replace) {
    const matcher = new RegExp(match,'g');
    element.textContent = element.textContent.replace(matcher,replace);
}