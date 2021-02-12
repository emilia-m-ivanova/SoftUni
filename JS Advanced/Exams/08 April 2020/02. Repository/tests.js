let {Repository} = require("./solution.js");
const assert = require('chai').assert;

describe("Tests …", () => {
    let properties = {
        name: "string",
        age: "number",
        birthday: "object"
    };
    let correctEntity1 = {
        name: "Pesho",
        age: 22,
        birthday: new Date(1998, 0, 7)
    };
    let correctEntity2 = {
        name: "Emi",
        age: 22,
        birthday: new Date(1998, 0, 7)
    };
    let wrongEntity1 = {
        name1: "Pesho",
        age: 22,
        birthday: new Date(1998, 0, 7)
    };
    let wrongEntity2 = {
        name: 22,
        age: 22,
        birthday: new Date(1998, 0, 7)
    };
    let rep;
    beforeEach(() => rep = new Repository(properties));
    it('constructor', () => {
        assert.isObject(rep.props, 'Prop object not created');
        assert.typeOf(rep.data, 'map', 'Map data not created');
    });
    it('count', () => {
        assert(rep.count === 0, 'Empty rep')
        rep.add(correctEntity1);
        assert(rep.count === 1, 'Rep with 1 entity')
    });
    it('add', () => {
        assert(rep.add(correctEntity1) === 0, 'First entity added');
        assert(rep.data.get(0) === correctEntity1, 'Entity added to data');
        assert.throw(() => rep.add(wrongEntity1), 'Property name is missing from the entity!');
        assert.throw(() => rep.add(wrongEntity2), 'Property name is not of correct type!')
    });
    it('getId', () => {
        assert.throw(() => rep.getId(0), 'Entity with id: 0 does not exist!');
        rep.add(correctEntity1);
        assert(rep.getId(0) === correctEntity1, 'First entity added')
        assert.throw(() => rep.getId(-1), 'Entity with id: -1 does not exist!');
    });
    it('update', () => {
        assert.throw(() => rep.update(0, correctEntity1), 'Entity with id: 0 does not exist!');
        rep.add(correctEntity1);
        assert.throw(() => rep.update(0, wrongEntity1), 'Property name is missing from the entity!');
        assert.throw(() => rep.update(0, wrongEntity2), 'Property name is not of correct type!');
        rep.update(0, correctEntity2);
        assert(rep.data.get(0) === correctEntity2, 'First entity updated with new value')
    });
    it('del', () => {
        assert.throw(() => rep.del(0), 'Entity with id: 0 does not exist!');
        rep.add(correctEntity1);
        rep.del(0);
        assert(rep.count === 0, 'first entity deleted');
        assert.throw(() => rep.del(-1), 'Entity with id: -1 does not exist!');
        assert.throw(() => rep.del(1.5), 'Entity with id: 1.5 does not exist!');
    });
});
