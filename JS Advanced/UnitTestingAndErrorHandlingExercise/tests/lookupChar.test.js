const lookupChar = require('../03. Char Lookup').lookupChar;
const expect = require('chai').expect;

describe('Returns a char from a given string on a passed on index',()=>{
    it('returns undefined when first param is a number',()=>{
        expect(lookupChar(4,5)).to.be.undefined;
    })
    it('returns undefined when second param is a string',()=>{
        expect(lookupChar('abc','a')).to.be.undefined;
    })
    it('returns undefined when second param is a floating point number',()=>{
        expect(lookupChar('abc',3.14)).to.be.undefined;
    })
    it('returns incorrect index when passed on a negative value',()=>{
        expect(lookupChar('abc',-1)).to.be.equal('Incorrect index');
    })
    it('returns incorrect index when passed on an index, greater than the string length',()=>{
        expect(lookupChar('abc',4)).to.be.equal('Incorrect index');
    })
    it('returns correctly a char at a index 0',()=>{
        expect(lookupChar('abc',0)).to.be.equal('a');
    })
    it('returns correctly a char at a index length-1',()=>{
        expect(lookupChar('abc',2)).to.be.equal('c');
    })
})