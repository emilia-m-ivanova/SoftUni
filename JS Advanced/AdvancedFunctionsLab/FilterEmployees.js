function solve(data, criteria){
    let arr = JSON.parse(data);
    const [parameter, value] = criteria.split('-');
    arr = arr.filter(e=>e[parameter]===value);
    let count = 0;
    arr.forEach(e=>print.apply(e));

    function print(){
        console.log(`${count++}. ${this.first_name} ${this.last_name} - ${this.email}`)
    }
}

solve(`[{
    "id": "1",
    "first_name": "Ardine",
    "last_name": "Bassam",
    "email": "abassam0@cnn.com",
    "gender": "Female"
  }, {
    "id": "2",
    "first_name": "Kizzee",
    "last_name": "Jost",
    "email": "kjost1@forbes.com",
    "gender": "Female"
  },  
{
    "id": "3",
    "first_name": "Evanne",
    "last_name": "Maldin",
    "email": "emaldin2@hostgator.com",
    "gender": "Male"
  }]`,
    'gender-Female');