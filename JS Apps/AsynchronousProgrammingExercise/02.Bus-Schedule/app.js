function solve() {

    const domElements = {
        depart: document.getElementById('depart'),
        arrive: document.getElementById('arrive'),
        info: document.querySelector('#info span'),
    }

    let stop = {
        "name": "Depot",
        "next": "0361"
    }

    function depart() {
        domElements.info.textContent = 'Next stop: ' + stop.name;
        domElements.arrive.disabled = false;
        domElements.depart.disabled = true;

    }

    async function arrive() {
        domElements.info.textContent = 'Arriving at: ' + stop.name;
        const url = 'http://localhost:3030/jsonstore/bus/schedule/' + stop.next;
        try{
            const promise = await fetch(url);
            if(!promise.ok){
                throw new Error();
            }
            const nextStop = await promise.json();
            stop = nextStop;
        }catch (err){
            window.alert('Internal error');
        }
        domElements.arrive.disabled = true;
        domElements.depart.disabled = false;

    }

    return {
        depart,
        arrive,
    };
}

let result = solve();