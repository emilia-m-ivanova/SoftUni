function createRegistry(arr){
    const city = {};
    for (const entry of arr) {
        let tokens = entry.split(" <-> ");
        let name = tokens[0];
        let population = Number(tokens[1]);
        if(city[name]){
            population+=city[name];
        }
        city[name] = population;
    }
    let result = '';
    for (const key in city) {
        result+= `${key} : ${city[key]}\n`
    }
    return result;
}
