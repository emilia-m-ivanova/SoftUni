const HolidayPackage = require('./HolidayPackage');
const assert = require('chai').assert;

describe('HolidayPackage',()=>{
    let hPackage;
    beforeEach(()=>hPackage = new HolidayPackage('a','Summer'));
    const vac1 = 'Emi Emi';
    const vac2 = 'Ema Ema';
    const invalidVac1 = 'Emi';
    const invalidVac2 = ' ';
    const invalidVac3 = 5;
    const invalidVac4 = null;
    const invalidVac5 = '';


    it('constructor',()=>{
        assert.deepEqual(hPackage.vacationers,[]);
        assert.equal(hPackage.destination,'a');
        assert.equal(hPackage.season,'Summer');
        assert.equal(hPackage.insuranceIncluded,false);
    });

    it('showVacationers',()=>{
        assert.equal(hPackage.showVacationers(),'No vacationers are added yet');
        hPackage.addVacationer(vac1);
        assert.equal(hPackage.showVacationers(),'Vacationers:\n' + 'Emi Emi');
        hPackage.addVacationer(vac2);
        assert.equal(hPackage.showVacationers(),'Vacationers:\n' + 'Emi Emi\n' + 'Ema Ema');

    });

    it('addVacationer',()=>{
        assert.throw(()=>hPackage.addVacationer(invalidVac1),'Name must consist of first name and last name');
        assert.throw(()=>hPackage.addVacationer(invalidVac2),'Vacationer name must be a non-empty string');
        assert.throw(()=>hPackage.addVacationer(invalidVac3),'Vacationer name must be a non-empty string');
        assert.throw(()=>hPackage.addVacationer(invalidVac4),'Vacationer name must be a non-empty string');
        assert.throw(()=>hPackage.addVacationer(invalidVac5),'Name must consist of first name and last name');

        assert.equal(hPackage.vacationers.length,0);
        hPackage.addVacationer(vac1);
        assert.equal(hPackage.vacationers.length,1);
        hPackage.addVacationer(vac2);
        assert.equal(hPackage.vacationers.length,2);
    });

    it('insuranceIncluded', ()=> {
        hPackage.insuranceIncluded = true;
        assert.equal(hPackage.insuranceIncluded,true);
        assert.throw(()=>hPackage.insuranceIncluded = 'yes','Insurance status must be a boolean');
        assert.throw(()=>hPackage.insuranceIncluded = 5,'Insurance status must be a boolean')
        assert.throw(()=>hPackage.insuranceIncluded = null,'Insurance status must be a boolean')

    });

    it('generateHolidayPackage',()=>{
        assert.throw(()=>hPackage.generateHolidayPackage(),'There must be at least 1 vacationer added');
        hPackage.addVacationer(vac1);
        assert.equal(hPackage.generateHolidayPackage(),'Holiday Package Generated\n' +
            'Destination: a\n' +
            'Vacationers:\n' +
            'Emi Emi\n' +
            'Price: 600');
    });
})