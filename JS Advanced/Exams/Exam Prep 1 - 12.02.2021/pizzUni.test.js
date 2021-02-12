const pizzUni = require('./03. Pizza Place.js');
const assert = require('chai').assert;
describe('pizzUni', () => {
    const order = {orderedPizza: 'Peperoni', orderedDrink: 'Juice'};
    const wrongOrder = {orderedPizza: '', orderedDrink: 'Juice'};
    const statusArrNotReady = [ {pizzaName: 'Peperoni', status: 'ready'},
                        {pizzaName: 'Capricciosa', status: 'preparing'}];
    const statusArrReady = [ {pizzaName: 'Peperoni', status: 'ready'},
        {pizzaName: 'Capricciosa', status: 'ready'}];
    it('makeAnOrder',()=>{
        assert(pizzUni.makeAnOrder(order)==='You just ordered Peperoni and Juice.','unsuccessful order');
        assert.throw(()=>pizzUni.makeAnOrder(wrongOrder),'You must order at least 1 Pizza to finish the order.');
    });
    it('getRemainingWork',()=>{
        assert(pizzUni.getRemainingWork(statusArrNotReady)==='The following pizzas are still preparing: Capricciosa.','order preparing');
        assert(pizzUni.getRemainingWork(statusArrReady)==='All orders are complete!','All orders are complete');
    });
    it('orderType',()=>{
        assert(pizzUni.orderType(10,'Carry Out')===9,'with discount');
        assert(pizzUni.orderType(10,'Delivery')===10,'no discount');
    })
})