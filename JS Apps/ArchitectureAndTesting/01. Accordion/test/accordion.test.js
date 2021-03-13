const {chromium} = require('playwright-chromium');
const {assert} = require('chai');
let browser, page; // Declare reusable variables

describe('E2E test', () => {
    before(async () => {
        browser = await chromium.launch();
    });
    after(async () => {
        await browser.close();
    });
    beforeEach(async () => {
        page = await browser.newPage();
    });
    afterEach(async () => {
        await page.close();
    });

    it('loads static page', async function () {
        await page.goto('http://localhost:3000');
        const mainText = await page.content('#main');
        assert.include(mainText, 'Scalable Vector Graphics');
        assert.include(mainText, 'Open standard');
        assert.include(mainText, 'Unix');
        assert.include(mainText, 'ALGOL');
    }).timeout(5000);;

    it('shows article content on click', async () => {
        const thirdArticle = 'Unix (trademarked as UNIX) is a family of multitasking, multiuser computer operating systems that derive from the original AT&T Unix, development starting in the 1970s at the Bell Labs research center by Ken Thompson, Dennis Ritchie, and others.'
        await page.goto('http://localhost:3000');
        await page.click('#main :nth-child(3) button');
        const mainText = await page.textContent('#main');
        assert.include(mainText, thirdArticle);
    }).timeout(5000);;

    it('hides article content on click', async () => {
        await page.goto('http://localhost:3000');
        await page.click('#main :nth-child(3) button');
        await page.click('#main :nth-child(3) button');
        const isVisible = await page.isVisible('#main :nth-child(3) div[class="extra"]');
        assert.isFalse(isVisible);
    }).timeout(5000);

});
