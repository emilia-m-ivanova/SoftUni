let expect = require('chai').expect;
let isSymmetric = require('../05. Check for Symmetry').isSymmetric;

describe('Check if array is symmetric',()=>{
    it('is symetric with string arr of even length', ()=>{
        expect(isSymmetric(['a','a'])).to.be.true;
    });
    it('is symetric with integer arr of odd length', ()=> {
        expect(isSymmetric([1, 2, 1])).to.be.true;
    });
    it('is not symetric with non-symetric arr', ()=>{
        expect(isSymmetric([1,2,3])).to.be.false;
    });
    it('returns false with invalid input',()=>{
        expect(isSymmetric(1)).to.be.false;
    });
    it('returns true with empty arr',()=>{
        expect(isSymmetric([])).to.be.true;
    });
    it('returns false with mixed-type arr',()=>{
        expect(isSymmetric([1,'1'])).to.be.false;
    });
})