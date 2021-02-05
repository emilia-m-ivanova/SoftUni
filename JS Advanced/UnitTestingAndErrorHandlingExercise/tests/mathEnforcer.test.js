const mathEnforcer = require('../04. Math Enforcer').mathEnforcer;
const expect = require('chai').expect;

describe('The math enforcer object performs mathematical operations',()=>{
    it('addFive returns undefined when passed on a string',()=>{
        expect(mathEnforcer.addFive('a')).to.be.undefined;
    });
    it('addFive returns the passed on positive integer +5',()=>{
        expect(mathEnforcer.addFive(1)).to.be.equal(6);
    });
    it('addFive returns the passed on negative integer +5',()=>{
        expect(mathEnforcer.addFive(-1)).to.be.equal(4);
    });
    it('addFive returns the passed on positive floating point number +5',()=>{
        expect(mathEnforcer.addFive(1.5)).to.be.equal(6.5);
    });
    it('subtractTen returns undefined when passed on a string',()=>{
        expect(mathEnforcer.subtractTen('a')).to.be.undefined;
    });
    it('subtractTen returns the passed on positive integer -10',()=>{
        expect(mathEnforcer.subtractTen(10)).to.be.equal(0);
    });
    it('subtractTen returns the passed on negative integer -10',()=>{
        expect(mathEnforcer.subtractTen(-10)).to.be.equal(-20);
    });
    it('subtractTen returns the passed on positive floating point number -10',()=>{
        expect(mathEnforcer.subtractTen(10.5)).to.be.equal(0.5);
    });
    it('sum returns undefined when passed on a string as first param',()=>{
        expect(mathEnforcer.sum('a',1)).to.be.undefined;
    });
    it('sum returns undefined when passed on a string as second param',()=>{
        expect(mathEnforcer.sum(1,'a')).to.be.undefined;
    });
    it('sum returns the sum of the two positive integers are passed',()=>{
        expect(mathEnforcer.sum(1,2)).to.be.equal(3);
    });
    it('sum returns the sum of the two negative integers are passed',()=>{
        expect(mathEnforcer.sum(-1,-2)).to.be.equal(-3);
    });
    it('sum returns the sum of the two positive floating point numbers are passed',()=>{
        expect(mathEnforcer.sum(1.5,2.5)).to.be.equal(4.0);
    });
})