function makeUpperCase (input) {
    input = input.split(/\W/).filter(e=>e.length>0);
    for (let i = 0; i < input.length; i++) {
        input[i] = input[i].toUpperCase();
    }
    return input.join(', ');
}
console.log(makeUpperCase('Hi, how are you?'));
console.log(makeUpperCase('hello'));