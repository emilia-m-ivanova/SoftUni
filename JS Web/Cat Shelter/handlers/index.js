const homeHandler = require('./home');
const staticHandler = require('./static-files');
const cat = require('./cat');

module.exports = [homeHandler, staticHandler,cat];