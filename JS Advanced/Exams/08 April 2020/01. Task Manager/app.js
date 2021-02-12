function solve() {
    document.getElementById('add').addEventListener('click',add);
    const task = document.getElementById('task');
    const description = document.getElementById('description');
    const date = document.getElementById('date');
    const sections = Array.from(document.querySelectorAll('.wrapper section'));
    function add(ev){
        ev.preventDefault();
        if(!task.value || !description.value || !date.value){
            return;
        }
        const btn1 = createElement('button','Start');
        btn1.className = 'green';
        btn1.addEventListener('click',start);
        const btn2 = createElement('button','Delete');
        btn2.className = 'red';
        btn2.addEventListener('click',remove);
        const div = createElement('div',btn1,btn2);
        div.className = 'flex';
        let article = createElement('article',
            createElement('h3',task.value),
            createElement('p','Description: '+ description.value),
            createElement('p','Due Date: ' + date.value),
            div);
        Array.from(sections[1].querySelectorAll('div'))[1].appendChild(article);
    }

    function start(ev){
        const article = ev.target.parentNode.parentNode;
        const [btn1,btn2] = Array.from(article.querySelectorAll('button'));
        btn1.textContent = 'Delete';
        btn1.className = 'red';
        btn1.addEventListener('click',remove);
        btn2.textContent = 'Finish';
        btn2.className = 'orange';
        btn2.addEventListener('click',finish);
        Array.from(sections[2].querySelectorAll('div'))[1].appendChild(article);
    }

    function remove(ev){
        ev.target.parentNode.parentNode.remove();
    }

    function finish(ev){
        const article = ev.target.parentNode.parentNode;
        article.querySelector('.flex').remove();
        Array.from(sections[3].querySelectorAll('div'))[1].appendChild(article);
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