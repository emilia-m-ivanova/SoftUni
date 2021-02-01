function solution() {
    const ingredients = {
        protein: 0,
        carbohydrate: 0,
        fat: 0,
        flavour: 0,
    }

    const meals = {
        apple: {carbohydrate: 1, flavour: 2},
        lemonade: {carbohydrate: 10, flavour: 20},
        burger: {carbohydrate: 5, fat: 7, flavour: 3},
        eggs: {protein: 5, fat: 1, flavour: 1},
        turkey: {protein: 10, carbohydrate: 10, fat: 10, flavour: 10},
    }

    const operations = {
        restock: (microElement, quantity) => {
            ingredients[microElement] = ingredients[microElement] + quantity;
            return 'Success';
        },
        prepare: (recipe, quantity) => {
            const ingrAfterPrep = {};
            Object.entries(meals[recipe]).forEach(e => {
                const [ingredient, value] = e;
                ingrAfterPrep[ingredient] = ingredients[ingredient] - value * quantity;
            })
            for (let key in ingrAfterPrep) {
                if (ingrAfterPrep[key] < 0) {
                    return `Error: not enough ${key} in stock`;
                }
            }
            Object.entries(ingrAfterPrep).forEach(e => {
                const [ingredient, value] = e;
                ingredients[ingredient] = value;
            })
            return 'Success';
        },
        report: () => {
            return Object.entries(ingredients).map(e => e[0] + '=' + e[1]).join(' ');
        },
    }

    return (input) => {
        [operation, product, quantity] = input.split(' ');
        return operations[operation](product, Number(quantity));
    };
}

let manager = solution();
console.log(manager("restock flavour 250"));// Success
console.log(manager("restock protein 250"));
console.log(manager("restock carbohydrate 350"));
console.log(manager("restock fat 250"));
console.log(manager("prepare lemonade 4"));  // Error: not enough carbohydrate in stock
console.log(manager("prepare turkey 4"));
console.log(manager("prepare turkey 42"));
console.log(manager('report'));