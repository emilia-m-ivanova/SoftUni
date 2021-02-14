function solve() {
    const instance = {};
    instance.extend = function (template) {
        Object.entries(template).forEach(([key, value]) => {
            if (typeof value === 'function') {
                Object.getPrototypeOf(instance)[key] = value;
            } else {
                instance[key] = value;
            }
        });
    }
    return instance;
}


let template = {
    extensionMethod: function () {
    },
    extensionProperty: 'someString'
}

let result = solve();
result.extend(template)
console.log(result);


