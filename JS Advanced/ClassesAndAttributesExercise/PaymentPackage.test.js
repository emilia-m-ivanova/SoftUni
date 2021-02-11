const PaymentPackage = require('./13. Payment Package').PaymentPackage;
const expect = require('chai').expect;
const assert = require('chai').assert;

describe('PaymentPackage', () => {
    let package;
    beforeEach(() => package = new PaymentPackage('Name', 10));
    it('constructor', () => {
        expect(package._name).to.equal('Name', 'Wrong name');
        expect(package._value).to.equal(10, 'Wrong value');
        expect(package._VAT).to.equal(20, 'Wrong VAT');
        expect(package._active).to.equal(true, 'Wrong active');
    });
    it('name', () => {
        assert.throws(() => package.name = '', 'Name must be a non-empty string');
        assert.throws(() => package.name = -5, 'Name must be a non-empty string');
        assert.throws(() => package.name = null, 'Name must be a non-empty string');
        assert.throws(() => package.name = [], 'Name must be a non-empty string');
        package.name = 'new name';
        assert(package.name === 'new name','Name didn\'t change');
    });
    it('value', () => {
        assert.throws(() => package.value = '', 'Value must be a non-negative number');
        assert.throws(() => package.value = -5, 'Value must be a non-negative number');
        assert.throws(() => package.value = null, 'Value must be a non-negative number');
        assert.throws(() => package.value = [], 'Value must be a non-negative number');
        package.value = 0;
        assert(package.value === 0,'Value didn\'t change');
    });
    it('VAT', () => {
        assert.throws(() => package.VAT = '', 'VAT must be a non-negative number');
        assert.throws(() => package.VAT = -5, 'VAT must be a non-negative number');
        assert.throws(() => package.VAT = null, 'VAT must be a non-negative number');
        assert.throws(() => package.VAT = [], 'VAT must be a non-negative number');
        package.VAT = 5.5;
        assert(package.VAT === 5.5,'VAT didn\'t change');
    });
    it('active', () => {
        assert.throws(() => package.active = '', 'Active status must be a boolean');
        assert.throws(() => package.active = -5, 'Active status must be a boolean');
        assert.throws(() => package.active = null, 'Active status must be a boolean');
        assert.throws(() => package.active = [], 'Active status must be a boolean');
        package.active = false;
        assert(package.active === false,'Active didn\'t change');
    });
    it('toString', () => {
        function output(name, value, active, VAT) {
            return [`Package: ${name}` + (active === false ? ' (inactive)' : ''),
                `- Value (excl. VAT): ${value}`,
                `- Value (VAT ${VAT}%): ${value * (1 + VAT / 100)}`]
        }

        expect(package.toString()).to.be.equal(output(package.name, package.value, package.active, package.VAT).join('\n'));
        package.name = 'New name';
        package.value = 20;
        expect(package.toString()).to.be.equal(output(package.name, package.value, package.active, package.VAT).join('\n'));
        package.VAT = 30;
        package.active = false;
        expect(package.toString()).to.be.equal(output(package.name, package.value, package.active, package.VAT).join('\n'));
    });
})