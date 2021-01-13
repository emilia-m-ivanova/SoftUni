function makeUpperCase (input) {
    input = input.split(/\W/).filter(e=>e.length>0);
    for (let i = 0; i < input.length; i++) {
        input[i] = input[i].toUpperCase();
    }
    return input.join(', ');
}