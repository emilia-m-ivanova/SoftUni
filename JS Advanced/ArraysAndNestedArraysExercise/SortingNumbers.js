function solve(arr){
    arr.sort((a,b)=>a-b);
    let result = [];
    while(arr.length!==0){
        result.push(arr.shift());
        result.push(arr.pop());
    }
    return result;
}