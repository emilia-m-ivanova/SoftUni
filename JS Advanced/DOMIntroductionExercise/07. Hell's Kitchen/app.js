function solve() {
    document.querySelector('#btnSend').addEventListener('click', onClick);

    function onClick() {
        let inputArray = JSON.parse(document.querySelector('#inputs textarea').value);
        const restaurants = {};
        inputArray.forEach(e => {
            e = e.split(' - ')
            const name = e[0];
            const workers = e[1].split(', ');
            if (!restaurants[name]) {
                restaurants[name] = {workers: []};
            }
            workers.forEach(worker => {
                worker = worker.split(' ');
                restaurants[name].workers.push({[worker[0]]: Number(worker[1])});
            })
            restaurants[name].workers.sort((a, b) => {
                return Object.values(b) - Object.values(a);
            })
            restaurants[name].average = restaurants[name].workers.reduce((acc, el) => {
                return acc + Object.values(el)[0];
            }, 0) / restaurants[name].workers.length;
        });
        let max = 0;
        let bestRestaurant = '';
        Object.entries(restaurants).forEach(([key, value]) => {
            if (value.average > max) {
                max = value.average;
                bestRestaurant = key;
            }
        })
        document.querySelector('#outputs #bestRestaurant p').textContent = 'Name: ' + bestRestaurant
            + ' Average Salary: ' + restaurants[bestRestaurant].average.toFixed(2)
            + ' Best Salary: ' + Number(Object.values(restaurants[bestRestaurant].workers[0])).toFixed(2);
        restaurants[bestRestaurant].workers.forEach(worker => {
            document.querySelector('#outputs #workers p').textContent +=
                `Name: ${Object.keys(worker)} With Salary: ${Object.values(worker)} `
        })
    }
}