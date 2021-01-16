function solve(arr,n){
    let outputArr = arr.filter((e,i)=>i%n===0);
    return outputArr;
}