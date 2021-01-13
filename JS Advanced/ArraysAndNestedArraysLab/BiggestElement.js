function solve(matrix) {
    let result = matrix
        .map(row=>Math.max(...row))
        .reduce((a,b)=>Math.max(a,b),Number.MIN_SAFE_INTEGER);
    return result;
}