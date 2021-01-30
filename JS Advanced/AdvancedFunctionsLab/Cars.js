function solve(arr) {
    function generateData() {
        const data = {};
        return {
            create: (name, _, parentName) => {
                data[name] = parentName ? Object.create(data[parentName])
                    : {};
            },
            set: (name, key, value) => {
                data[name][key] = value;
            },
            print: (name) => {
                let result = [];
                for (let key in data[name]) {
                    result.push(`${key}:${data[name][key]}`);
                }
                console.log(result.join(', '));
            },
        }
    }

    const factory = generateData();
    arr.map(e => e.split(' ')).forEach(([command, ...args]) => {
        factory[command](...args);
    })
}

solve(['create c1',
    'create c2 inherit c1',
    'set c1 color red',
    'set c2 model new',
    'print c1',
    'print c2']);