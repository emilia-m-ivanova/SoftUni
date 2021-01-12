function calculateArea(radius){
    let type = typeof radius;
    if(type == 'number'){
        console.log((Math.pow(radius,2) * Math.PI).toFixed(2));
    }else{
        console.log(`We can not calculate the circle area, because we receive a ${type}.`)
    }
}
