function solve(matrix) {
    let rowSum = [];
    let colSum = [];
    matrix.forEach(arr=>{
        let sum = 0
        arr.forEach(e=>sum+=e);
        rowSum.push(sum);
    })
    for (let col = 0; col < matrix[0].length; col++) {
        let sum = 0;
        for (let row = 0; row < matrix.length; row++) {
            sum += matrix[row][col];
        }
        colSum.push(sum);
    }
    return rowSum.concat(colSum).every(e=>e===rowSum[0]);
}