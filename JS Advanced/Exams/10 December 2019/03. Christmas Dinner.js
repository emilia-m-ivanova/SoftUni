class ChristmasDinner {
    constructor(budget) {
        this.budget = budget;
        this.dishes = [];
        this.products = [];
        this.guests = {};
    }

    get budget() {
        return this._budget;
    }

    set budget(budget) {
        if(budget<0){
            throw new Error('The budget cannot be a negative number')
        }
        this._budget = budget;
    }

    shopping([type, price]) {
        if (this.budget < price) {
            throw new Error('Not enough money to buy this product')
        }
        this.budget -= price;
        this.products.push(type);
        return `You have successfully bought ${type}!`
    }

    recipes({recipeName, productsList}) {
        productsList.forEach(e => {
            if (!this.products.includes(e)) {
                throw new Error('We do not have this product')
            }
        });
        this.dishes.push({recipeName, productsList});
        return `${recipeName} has been successfully cooked!`
    }

    inviteGuests(name, dish) {
        const dishPresent = this.dishes.find(d=>d.recipeName===dish);
        if (!dishPresent) {
            throw new Error('We do not have this dish');
        }
        if (this.guests[name]) {
            throw new Error('This guest has already been invited');
        }
        this.guests[name] = dish;
        return `You have successfully invited ${name}!`
    }

    showAttendance() {
        return Object.entries(this.guests).map(g=>{
            const products = this.dishes.find(e=>e.recipeName===g[1]).productsList.join(', ')
            return `${g[0]} will eat ${g[1]}, which consists of ${products}`
        }).join('\n');
    }
}
