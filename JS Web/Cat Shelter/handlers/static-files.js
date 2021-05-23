const url = require('url');
const fs = require('fs');

function getContentType(url) {
    if (url.endsWith('css')) {
        return 'text/css';
    } else if (url.endsWith('html')) {
        return 'text/html';
    } else if (url.endsWith('png')) {
        return 'image/png';
    } else if (url.endsWith('jpeg')) {
        return 'image/jpeg';
    } else if (url.endsWith('jpg')) {
        return 'image/jpg';
    }else if(url.endsWith('js')){
        return 'application/javascript'
    } else {
        return "text/plain";
    }
}

module.exports = (req,res)=>{
    const pathname = url.parse(req.url).pathname;
    if(pathname.startsWith('/content')&& req.method === 'GET'){
        fs.readFile(`../${pathname}`, (err, data) => {
            if (err) {
                res.writeHead(404, {
                    'Content-Type': 'text/plain'
                });
                res.write('Resource not found');
                res.end();
                return;
            }
            res.writeHead(200, {
                'Content-Type': getContentType(pathname)
            });
            res.write(data);
            res.end();
        })
    }else{
        return true;
    }
}