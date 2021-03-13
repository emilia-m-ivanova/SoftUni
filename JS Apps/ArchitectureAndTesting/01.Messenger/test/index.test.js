const assert = require('chai').assert;
const chromium = require('playwright-chromium').chromium;
const data = require('../mock-data.json');

describe('E2E test', () => {
    let browser;
    let page;
    const pageUrl = 'http://localhost:3000';
    const serverUrl = 'http://localhost:3030/jsonstore/messenger'
    const json = (data) => {
        return {
            status: 200,
            headers: {
                'Access-Control-Allow-Origin': '*',
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data),
        }
    }
    before(async () => {
        browser = await chromium.launch();
    });
    beforeEach(async () => {
        page = await browser.newPage();
    })
    afterEach(async () => {
        await page.close();
    })
    after(async () => {
        await browser.close();
    })

    it('loads messages when clicking Refresh', async () => {
        const messages = 'Spami: Hello, are you there?\n' +
            'Garry: Yep, whats up :?\n' +
            'Spami: How are you? Long time no see? :)\n' +
            'George: Hello, guys! :))\n' +
            'Spami: Hello, George nice to see you! :)))'
        await page.goto(pageUrl);
        await page.waitForSelector('input');

        await Promise.all([
            page.route(serverUrl, route => route.fulfill(json(data))),
            page.click('text=Refresh')]);
        const content = await page.$eval('#messages', el => el.value)
        assert.include(content, messages);
    }).timeout(6000);

    it('sends correct message to database', async () => {
        await page.goto(pageUrl);
        await page.waitForSelector('input');
        const author = 'A';
        const content = 'B';
        await page.fill('#author', author);
        await page.fill('#content', content);

        //check if correct request is sent
        const [response] = await Promise.all([
            page.waitForRequest(serverUrl),
            page.click('text=Send')
        ]);
        const postData = JSON.parse(response.postData())
        assert.equal(postData.author, author);
        assert.equal(postData.content, content);
    }).timeout(6000);
})