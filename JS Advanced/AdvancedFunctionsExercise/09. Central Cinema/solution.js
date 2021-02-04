function solve() {
    document.querySelector('#add-new button').addEventListener('click', onClickAdd);
    const inputFields = Array.from(document.querySelectorAll('#container input'));
    const onScreen = document.querySelector('#movies ul');
    const archived = document.querySelector('#archive ul');

    //add movies to the list
    function onClickAdd(ev) {
        ev.preventDefault();

        const name = inputFields[0].value;
        const hall = inputFields[1].value;
        const ticketPrice = Number(inputFields[2].value);
        if (!name || !hall || !ticketPrice) {
            return;
        }

        function createMovie() {
            const ticketsSold = document.createElement('input');
            ticketsSold.placeholder = 'Tickets Sold';
            const button = el('button', 'Archive');
            button.addEventListener('click', e => onClickArchive(e, name, ticketPrice, ticketsSold));
            return el('li',
                el('span', name),
                el('strong', 'Hall: ' + hall),
                el('div',
                    el('strong', ticketPrice.toFixed(2)),
                    ticketsSold,
                    button,
                )
            );
        }

        onScreen.appendChild(createMovie());
        inputFields.forEach(e => e.value = '');
    }

    //archive movies and sum profit
    function onClickArchive(ev, name, price, ticketsSold) {
        const sold = Number(ticketsSold.value);
        if(!sold){
            return;
        }

        function createArchive() {
            const button = el('button', 'Delete');
            button.addEventListener('click', () => {
                liElement.remove();
            })
            const liElement = el('li',
                el('span', name),
                el('strong', 'Total amount: ' + (sold * price).toFixed(2)),
                button
            );
            return liElement;
        }

        archived.appendChild(createArchive());
        ev.target.parentElement.parentElement.remove();
    }

    //clear archived section
    document.querySelector('#archive button').addEventListener('click',(ev)=>{
        const archivedSection = ev.target.parentNode;
        Array.from(archivedSection.querySelectorAll('li')).forEach(e=>e.remove());
    })

    //create and append dom elements with any type or value
    function el(type, ...value) {
        const newElement = document.createElement(type);
        if (typeof value[0] === 'string') {
            newElement.textContent = value[0];
        } else {
            value.forEach(e => newElement.appendChild(e));
        }
        return newElement;
    }
}