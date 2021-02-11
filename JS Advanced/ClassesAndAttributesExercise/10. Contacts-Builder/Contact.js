class Contact {
    constructor(firstName, lastName, phone, email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this._online = false;
    }

    set online(value) {
        this._online = value;
        if (this._online && this.title) {
            this.title.classList.add('online');
        } else if (this.title) {
            this.title.classList.remove('online');
        }
    }

    get online() {
        return this._online;
    }

    render(id) {
        const button = createElement('button', 'ℹ');
        const title = createElement('div', `${this.firstName} ${this.lastName}`, button);
        title.classList.add('title');
        if (this._online) {
            title.classList.add('online');
        }
        this.title = title;
        const info = createElement('div',
            createElement('span', '☎' + `${this.phone}`),
            createElement('span', '✉' + `${this.email}`));
        info.className = "info";
        info.style.display = 'none';
        button.addEventListener('click', () => info.style.display = info.style.display === 'block' ? 'none' : 'block');
        const article = createElement('article', title, info);

        document.getElementById(id).appendChild(article);


        function createElement(tagName, ...content) {
            const element = document.createElement(tagName);
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

}

function solve() {
    let contacts = [
        new Contact("Ivan", "Ivanov", "0888 123 456", "i.ivanov@gmail.com"),
        new Contact("Maria", "Petrova", "0899 987 654", "mar4eto@abv.bg"),
        new Contact("Jordan", "Kirov", "0988 456 789", "jordk@gmail.com")
    ];
    contacts.forEach(c => c.render('main'));

// After 1 second, change the online status to true
    setTimeout(() => contacts[1].online = true, 2000);
}