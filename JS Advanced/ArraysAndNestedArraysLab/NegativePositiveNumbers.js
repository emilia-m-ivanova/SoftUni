function solve(arr) {
    let result = [];
    arr.forEach(e=>{
        if(e<0){
            result.unshift(e);
        }else{
            result.push(e);
        }
    })
    return result.join('\n');
}