function solve(area, vol, input) {
   let arr = JSON.parse(input);
   return arr.map(e=>{
       return {area: Math.abs(area.call(e)),
           volume: Math.abs(vol.call(e))};
   })
}

function area() {
    return Math.abs(this.x * this.y);
};
function vol() {
    return Math.abs(this.x * this.y * this.z);
};

console.log(solve(area, vol,
    '[{"x":"-1","y":"-1","z":"-1"},{"x":"-7","y":"-7","z":"10"},{"x":"5","y":"2","z":"10"}]'
));
