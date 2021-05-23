const url = require('url');
const fs = require('fs');
const path = require('path');
const qs = require('querystring');
const formidable = require('formidable');
// const breeds = require('../data/breeds');
// const cats = require('../data/cats');

module.exports = (req, res) => {
    const pathname = url.parse(req.url).pathname;
    let file;
    if (pathname === '/cats/add-cat' && req.method === 'GET') {
        file = '../views/addCat.html';
    } else if (pathname === '/cats/add-breed' && req.method === 'GET') {
        file = '../views/addBreed.html'
    } else {
        return true;
    }
    const filePath = path.normalize(
        path.join(__dirname, file)
    );
    fs.readFile(filePath, (err, data) => {
        if (err) {
            res.writeHead(404, {
                'Content-Type': 'text/plain'
            });
            res.write('Resource not found');
            res.end();
            return;
        }
        res.writeHead(200, {
            'Content-Type': 'text/html'
        });
        res.write(data);
        res.end();
    })
}