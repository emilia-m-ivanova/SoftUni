const rgbToHexColor = require('../06. RGB to Hex').rgbToHexColor;
const expect = require('chai').expect;

describe('Converts RGB to Hex',()=>{
    it('converts black color to hex',()=>{
        expect(rgbToHexColor(0,0,0)).to.equal('#000000');
    });
    it('converts white color to hex',()=>{
        expect(rgbToHexColor(255,255,255)).to.equal('#FFFFFF');
    });
    it('converts white color to hex',()=>{
        expect(rgbToHexColor(12, 52, 36)).to.equal('#0C3424');
    });
    it('returns undefined with missing parameters',()=>{
        expect(rgbToHexColor(12, 52)).to.be.undefined;
    });
    it('returns undefined with wrong blue parameter type',()=>{
        expect(rgbToHexColor(12, 52,'a')).to.be.undefined;
    });
    it('returns undefined with wrong green parameter type',()=>{
        expect(rgbToHexColor(12, 'a',6)).to.be.undefined;
    });
    it('returns undefined with wrong red parameter type',()=>{
        expect(rgbToHexColor('a', 52,6)).to.be.undefined;
    });
    it('returns undefined with negative blue parameter',()=>{
        expect(rgbToHexColor(12, 52,-1)).to.be.undefined;
    });
    it('returns undefined with negative green parameter',()=>{
        expect(rgbToHexColor(12, -1,0)).to.be.undefined;
    });
    it('returns undefined with negative red parameter',()=>{
        expect(rgbToHexColor(-1, 52,9)).to.be.undefined;
    });
    it('returns undefined with red parameter>255',()=>{
        expect(rgbToHexColor(256, 52,9)).to.be.undefined;
    });
    it('returns undefined with green parameter>255',()=>{
        expect(rgbToHexColor(255, 256,9)).to.be.undefined;
    });
    it('returns undefined with blue parameter>255',()=>{
        expect(rgbToHexColor(250, 52,256)).to.be.undefined;
    });
})