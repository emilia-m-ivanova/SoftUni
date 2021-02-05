function solve(httpObj) {
    const validMethods = ['GET', 'POST', 'DELETE', 'CONNECT'];
    const uniRegExp = /^[\w.]+$/;
    const validVersions = ['HTTP/0.9', 'HTTP/1.0', 'HTTP/1.1', 'HTTP/2.0'];
    const specialCharacters = ['<', '>', '\\', '&', '\'', '\"'];
    if (!validMethods.includes(httpObj.method)) {
        throw new Error('Invalid request header: Invalid Method')
    }
    if (!httpObj.uri || httpObj.uri.match(uniRegExp) == null) {
        throw new Error('Invalid request header: Invalid URI')
    }
    if (!validVersions.includes(httpObj.version)) {
        throw new Error('Invalid request header: Invalid Version')
    }
    if(!httpObj.hasOwnProperty('message')){
        throw new Error('Invalid request header: Invalid Message')
    }
    httpObj.message.split('').forEach(c => {
        if (specialCharacters.includes(c)){
            throw new Error('Invalid request header: Invalid Message')
        }
    })
    return httpObj;
}