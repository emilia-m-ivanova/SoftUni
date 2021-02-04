const createCalculator = require('../07. Add Subtract');
const expect = require('chai').expect;

describe('Creates a calculator object',()=>{
    let calc;
    beforeEach(function () {
        calc = createCalculator();
    });
    it('returns an object',()=>{
        expect(calc).to.be.an('object');
    })
    it('has a functionality add',()=>{
       expect(calc).to.haveOwnProperty('add');
    });
    it('has a functionality subtract',()=>{
        expect(calc).to.haveOwnProperty('subtract');
    });
    it('has a functionality get',()=>{
        expect(calc).to.haveOwnProperty('get');
    });
    it('has sum of 0 the first time being called',()=>{
        expect(calc.get()).to.be.equal(0);
    });
    it('sums correctly with positive value',()=>{
        calc.add(5);
        expect(calc.get()).to.be.equal(5);
    });
    it('sums correctly with negative value',()=>{
        calc.add(-4);
        expect(calc.get()).to.be.equal(-4);
    });
    it('subtracts correctly with positive value',()=>{
        calc.subtract(4)
        expect(calc.get()).to.be.equal(-4);
    });
    it('subtracts correctly with negative value',()=>{
        calc.subtract(-3)
        expect(calc.get()).to.be.equal(3);
    });
    it('subtracts correctly with a positive number as string',()=>{
        calc.subtract('3')
        expect(calc.get()).to.be.equal(-3);
    });
    it('adds correctly with a positive number as string',()=>{
        calc.add('3')
        expect(calc.get()).to.be.equal(3);
    });
    it('subtracts correctly with a negative number as string',()=>{
        calc.subtract('-3')
        expect(calc.get()).to.be.equal(3);
    });
    it('adds correctly with a negative number as string',()=>{
        calc.add('-3')
        expect(calc.get()).to.be.equal(-3);
    });
    it('works correctly when several functions are called with integer values',()=>{
        calc.add(3)
        calc.subtract(3)
        expect(calc.get()).to.be.equal(0);
    });
    it('works correctly when several functions are called with a floating and an integer value',()=>{
        calc.add(3)
        calc.subtract(3.5)
        expect(calc.get()).to.be.equal(-0.5);
    });
    it('subtracts correctly with a floating point number',()=>{
        calc.subtract(3.5)
        expect(calc.get()).to.be.equal(-3.5);
    });
    it('adds correctly with a floating point number',()=>{
        calc.add(3.5)
        expect(calc.get()).to.be.equal(3.5);
    });
    it('the sum is not a property',()=>{
        expect(calc.value).to.be.undefined;
    });
    it('the sum cannot be modified',()=>{
        calc.value = 2;
        expect(calc.get()).to.be.equal(0);
    });
    it('add returns NaN with a string value',()=>{
        calc.add('a');
        expect(calc.get()).to.be.NaN;
    });
    it('add returns NaN with an objet value',()=>{
        calc.add({});
        expect(calc.get()).to.be.NaN;
    });
    it('subtract returns NaN with a string value',()=>{
        calc.subtract('a');
        expect(calc.get()).to.be.NaN;
    });
    it('subtract returns NaN with an objet value',()=>{
        calc.subtract({});
        expect(calc.get()).to.be.NaN;
    });
    it('subtract returns NaN without input value',()=>{
        calc.subtract();
        expect(calc.get()).to.be.NaN;
    });
    it('add returns NaN without input value',()=>{
        calc.add();
        expect(calc.get()).to.be.NaN;
    });
})