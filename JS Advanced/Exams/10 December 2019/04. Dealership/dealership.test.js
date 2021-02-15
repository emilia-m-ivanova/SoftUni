const dealership = require('./dealership');
const assert = require('chai').assert;

describe('dealership', () => {
    it(' newCarCost', () => {
        assert(dealership.newCarCost('Some car model', 1000) === 1000, 'car model not present')
        assert(dealership.newCarCost('Audi A4 B8', 30000) === 15000, 'car model Audi A4 B8')
        assert(dealership.newCarCost('Audi A6 4K', 30000) === 10000, 'car model Audi A6 4K')
        assert(dealership.newCarCost('Audi A8 D5', 30000) === 5000, 'car model Audi A8 D5')
        assert(dealership.newCarCost('Audi TT 8J', 30000) === 16000, 'car model Audi A8 D5')
    });
    it('carEquipment', () => {
        const extras = ['extra1', 'extra2', 'extra3'];
        assert(dealership.carEquipment(extras, [0, 2])[0] === extras[0], 'first extra selected')
        assert(dealership.carEquipment(extras, [0, 2])[1] === extras[2], 'second extra selected')
    });
    it('euroCategory', () => {
        assert(dealership.euroCategory(3) ===
            'Your euro category is low, so there is no discount from the final price!',
            'low category');
        assert(dealership.euroCategory(4) ===
            'We have added 5% discount to the final price: 14250.',
            'category 4');
    })
})