function solve(arr){
    function generateData() {
        let collection = [];
        return{
            add: (string) =>collection.push(string),
            remove: (string)=>collection = collection.filter(e=>e!==string),
            print: ()=> console.log(collection.join(','))
        }
    }
    const operations = generateData();
    arr.map(e=>e.split(' ')).forEach(e=>operations[e[0]](e[1]));

}

solve(['add hello', 'add again', 'remove hello', 'add again', 'print']);