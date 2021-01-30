function solve(arr) {
    function generateData() {
        const data = {};
        return {
            create: (name, inherit, parentName) => {
                data[name] = inherit ? Object.create(data[parentName])
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

solve(['create pesho',
    'create gosho inherit pesho',
    'create stamat inherit gosho',
    'set pesho rank number1',
    'set gosho nick goshko',
    'print stamat']);