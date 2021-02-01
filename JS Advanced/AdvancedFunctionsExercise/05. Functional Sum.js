function add(num){
    function calc(num2){
        num+=num2;
        return calc;
    }
    calc.toString = () => num;
    return calc;
}


console.log(add(1)(6)(1)(3).toString());
