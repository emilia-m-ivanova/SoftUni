let expect = require('chai').expect;
let sum = require('../04. Sum of Numbers').sum;

describe("sum array",()=>{
    it('returns sum',()=>{
        expect(sum([2,3])).to.be.equal(5);
    })
    it('returns sum',()=>{
        expect(sum([1])).to.be.equal(1);
    })
    it('returns sum',()=>{
        expect(sum([])).to.be.equal(0);
    })
});
