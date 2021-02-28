async function lockedProfile() {
    const main = document.getElementById('main');
    const url = 'http://localhost:3030/jsonstore/advanced/profiles';
    const promise = await fetch(url);
    const users = await promise.json();
    Object.values(users).map((user, index) => {
        return createElement('div', {className: 'profile'},
            createElement('img', {src: './iconProfile2.png', className: 'userIcon'}),
            createElement('label', {}, 'Lock'),
            createElement('input', {type: 'radio', name: `user${index + 1}Locked`, value: 'lock', checked: true}),
            createElement('label', {}, 'Unlock'),
            createElement('input', {type: 'radio', name: `user${index + 1}Locked`, value: 'unlock'}),
            createElement('br', {}),
            createElement('hr', {}),
            createElement('label', {}, 'Username'),
            createElement('input', {
                type: 'text',
                name: `user${index + 1}Username`,
                value: user.username,
                disabled: true,
                readOnly: true
            }),
            createElement('div', {id: `user${index + 1}HiddenFields`},
                createElement('hr', {}),
                createElement('hr'),
                createElement('label', {}, 'Email'),
                createElement('input', {
                    type: 'email',
                    name: `user${index + 1}Email`,
                    value: user.email,
                    disabled: true,
                    readOnly: true
                }),
                createElement('label', {}, 'Age:'),
                createElement('input', {
                    type: 'email',
                    name: `user${index + 1}Age`,
                    value: user.age,
                    disabled: true,
                    readOnly: true
                })
            ),
            createElement('button', {onClick: (ev) => showHidden(ev,index)}, 'Show more')
        );
    }).forEach(e => main.appendChild(e));

    function showHidden(ev,index) {
        const [locked, unlocked] = Array.from(document.getElementsByName(`user${index + 1}Locked`));
        if (locked.checked) {
            return;
        }
        const userHidden = document.getElementById(`user${index + 1}HiddenFields`);
        userHidden.style.display = userHidden.style.display === 'inline-block' ? 'none' : 'inline-block';
        ev.target.textContent = ev.target.textContent==='Show more'?'Hide it':'Show more';
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