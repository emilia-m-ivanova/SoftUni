function solve(arr) {
    const fruits = new Map;
    const bottles = new Map;
    arr.map(e => e.split(' => '))
        .forEach(e => {
            let value = fruits.has(e[0]) ? fruits.get(e[0]) + Number(e[1]) : Number(e[1]);
            if (value >= 1000) {
                const bottle = bottles.has(e[0]) ? bottles.get(e[0]) + Math.floor(value / 1000) : Math.floor(value / 1000);
                bottles.set(e[0], bottle);
                value = value % 1000;
            }
            fruits.set(e[0], value);
        });
    return Array.from(bottles.entries())
        .map(e=>{
            return e[0] + ' => ' + e[1];
        })
        .join(('\n'));
}