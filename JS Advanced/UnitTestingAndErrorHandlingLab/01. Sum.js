function sum (arr,start,end){
    if(!Array.isArray(arr)){
        return NaN;
    }
    if(start<0){
        start = 0;
    }
    return arr.slice(start,end+1).reduce((acc,e)=>{
        return acc + Number(e);
    },0);
}
