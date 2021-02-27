function loadRepos() {
    const list = document.getElementById('repos');
    const user = document.getElementById('username').value;
    list.innerHTML = '';
    const url = ' https://api.github.com/users/' + user + '/repos';
    fetch(url)
        .then(r => {
            if (r.status != 200) {
                throw new Error('404 “Not Found”');
            }
            return r.json();
        })
        .then(repos => {
            repos.forEach(e => {
                let element = createElement('li', {},
                    createElement('a', {href: e['html_url']}, e['full_name']))
                list.appendChild(element);
            });
        })
        .catch(error => {
            let element = createElement('li', {}, error.message);
            list.appendChild(element);
        })


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