function extract(id) {
    const text = document.getElementById(id).textContent;
    const regExp = new RegExp('\\((.+?)\\)','g');
    const output = [];
    let match = regExp.exec(text);
    while (match){
        output.push(match[1]);
        match = regExp.exec(text);
    }
    return output.join('; ')
}