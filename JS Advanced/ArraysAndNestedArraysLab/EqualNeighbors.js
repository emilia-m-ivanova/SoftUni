function solve(matrix) {
    let pairs = 0;
    for (let i = 0; i < matrix.length; i++) {
        for (let j = 0; j < matrix[i].length; j++) {
            if (matrix[i+1] && matrix[i][j] === matrix[i + 1][j]) {
                pairs++;
            }
            if (matrix[i][j] === matrix[i][j + 1]) {
                pairs++;
            }
        }
    }
    return pairs;
}

console.log(solve([
    [2,2,5,7,4],
        [4,0,5,3,4],
        [2,5,5,4,2]
]))