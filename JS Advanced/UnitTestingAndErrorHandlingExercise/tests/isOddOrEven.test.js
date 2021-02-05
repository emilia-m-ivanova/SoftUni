const isOddOrEven = require('../02. Even Or Odd').isOddOrEven;
const expect = require('chai').expect;

describe('Check whether the length of a string is even or odd',()=>{
    it('returns even with a string with even length',()=>{
        expect(isOddOrEven('ab')).to.be.equal('even');
    });
    it('returns even with an empty string',()=>{
        expect(isOddOrEven('')).to.be.equal('even');
    });
    it('returns odd with a string with odd length',()=>{
        expect(isOddOrEven('a')).to.be.equal('odd');
    });
    it('returns undefined with a number param',()=>{
        expect(isOddOrEven(1)).to.be.undefined;
    });
    it('returns undefined with an array param',()=>{
        expect(isOddOrEven([])).to.be.undefined;
    });
    it('returns undefined with an object param',()=>{
        expect(isOddOrEven({})).to.be.undefined;
    });
})