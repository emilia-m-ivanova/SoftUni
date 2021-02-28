async function getInfo() {
    const busStop = document.getElementById('stopId').value;
    const stopName = document.getElementById('stopName');
    const ulElement = document.getElementById('buses');
    const url = 'http://localhost:3030/jsonstore/bus/businfo/' + busStop;

    try {
        ulElement.innerHTML = '';
        const promise = await fetch(url);
        const stop = await promise.json();
        stopName.textContent = stop.name;
        Object.entries(stop.buses).map(s=>{
            const busNumber = s[0];
            const arrival = s[1];
            const liElement = document.createElement('li');
            liElement.textContent = `Bus ${busNumber} arrives in ${arrival} minutes`;
            ulElement.appendChild(liElement);
        })
    }catch (err){
        stopName.textContent = 'Error';
    }
}