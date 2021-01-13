function solve(arr){
   let result = arr
       .sort((a,b)=>a-b)
       .slice(Math.floor(arr.length/2));
   return result;
}