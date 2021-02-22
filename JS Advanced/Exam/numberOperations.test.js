const numberOperations = require('./03. Number Operations_Resources');
const assert = require('chai').assert;

describe('numberOperations',()=>{
    it('powNumber',()=>{
        assert.equal(numberOperations.powNumber(1),1);
        assert.equal(numberOperations.powNumber(2),4);
        assert.equal(numberOperations.powNumber(-2),4);
    });
    it('numberChecker',()=>{
        assert.throw(()=>numberOperations.numberChecker('a'),'The input is not a number!');
        assert.throw(()=>numberOperations.numberChecker({}),'The input is not a number!');
        assert.equal(numberOperations.numberChecker(-1),'The number is lower than 100!');
        assert.equal(numberOperations.numberChecker(99),'The number is lower than 100!');
        assert.equal(numberOperations.numberChecker(100),'The number is greater or equal to 100!');
        assert.equal(numberOperations.numberChecker(101),'The number is greater or equal to 100!');
    });
    it('sumArrays',()=>{
        assert.deepEqual(numberOperations.sumArrays([1,2,3],[3,2,1]),[4,4,4])
        assert.deepEqual(numberOperations.sumArrays([],[]),[]);
        assert.deepEqual(numberOperations.sumArrays([1,2,3,4],[3,2,1]),[4,4,4,4])
        assert.deepEqual(numberOperations.sumArrays([1,2,3],[3,2,1,4]),[4,4,4,4])

    })
})