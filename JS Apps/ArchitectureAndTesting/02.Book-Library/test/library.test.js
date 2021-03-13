const {assert} = require('chai');
const {chromium} = require('playwright-chromium');
const data = require('../mock-data.json');

describe('Library E2E tests', () => {
    let browser;
    let page;
    const serverUrl = 'http://localhost:3030/jsonstore/collections/books';
    const pageUrl = 'http://localhost:3000/';
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
    before(async () => browser = await chromium.launch());
    // before(async () => browser = await chromium.launch({headless: false, slowMo: 1200}));
    beforeEach(async () => page = await browser.newPage())
    afterEach(async () => await page.close());
    after(async () => await browser.close());

    it('loads all books', async () => {
        const expectedContent = [
            'Author1', 'Title1',
            'Author1', 'Title2'
        ]
        await page.goto(pageUrl);
        await page.waitForSelector('#loadBooks');
        await Promise.all([
            page.route(serverUrl, route => route.fulfill(json(data.books))),
            page.click('#loadBooks')
        ]);

        await page.waitForSelector('tbody');
        const content = await page.textContent('tbody');
        expectedContent.forEach(e => assert.include(content, e));
    }).timeout(6000);

    it('displays an alert with invalid input', async () => {
        await page.goto(pageUrl);
        await page.waitForSelector('input');

        let message;
        await page.fill('#createForm [name="title"]', '');
        await page.fill('#createForm [name="author"]', 'A');
        await checkInvalid();
        await page.fill('#createForm [name="title"]', 'A');
        await page.fill('#createForm [name="author"]', '');
        await checkInvalid();

        async function checkInvalid() {
            page.on('dialog', async (dialog) => {
                message = dialog.message();
                await dialog.accept()
            });
            await page.click('text=Submit');
            assert.equal(message, 'All fields are required!')
        }

    }).timeout(6000);

    it('adds a book with valid input', async () => {
        await page.goto(pageUrl);
        await page.waitForSelector('input');

        const title = 'A';
        const author = 'B';
        await page.fill('#createForm [name="title"]', title);
        await page.fill('#createForm [name="author"]', author);

        const [request] = await Promise.all([
            page.waitForRequest(serverUrl),
            page.click('text=Submit')
        ]);
        const data = JSON.parse(request.postData())
        assert.equal(data.title, title);
        assert.equal(data.author, author);
    }).timeout(6000)

    it('edits a book', async () => {

        //check if correct details are loaded in the form
        const title = 'Title2';
        const author = 'Author2';
        await page.goto(pageUrl);
        await page.waitForSelector('#loadBooks');

        await Promise.all([
            page.route(serverUrl, route => route.fulfill(json(data.books))),
            page.click('#loadBooks')
        ]);
        await Promise.all([
            page.route(serverUrl + '/2', route => route.fulfill(json(data.books["2"]))),
            page.click('tbody :nth-child(2) .editBtn')
        ]);

        const [titleEdit, authorEdit] = await Promise.all([
            page.$eval('#editForm [name="title"]', el => el.value),
            page.$eval('#editForm [name="author"]', el => el.value)
        ]);
        assert.equal(title, titleEdit);
        assert.equal(author, authorEdit);

        //change input and check if correct request is sent
        const fillTitle = 'A';
        const fillAuthor = 'B';
        await page.fill('#editForm [name="title"]', fillTitle);
        await page.fill('#editForm [name="author"]', fillAuthor);
        const [request] = await Promise.all([
            page.waitForRequest(r => r.url() === serverUrl + '/2' && r.method() === 'PUT'),
            page.click('text=Save')
        ]);
        const postData = JSON.parse(request.postData());
        assert.equal(postData.author, fillAuthor);
        assert.equal(postData.title, fillTitle);


    }).timeout(6000);

    it('deletes a book', async () => {
        await page.goto(pageUrl);
        await page.waitForSelector('#loadBooks');
        await Promise.all([
            page.route(serverUrl, route => route.fulfill(json(data.books))),
            page.click('#loadBooks')
        ]);

        page.on('dialog', async (dialog) => dialog.accept());
        const [request] = await Promise.all([
            page.waitForRequest(serverUrl + '/2'),
            page.click('tbody :nth-child(2) .deleteBtn'),
        ]);
        assert.equal(request.method(), 'DELETE');
    }).timeout(6000);
})