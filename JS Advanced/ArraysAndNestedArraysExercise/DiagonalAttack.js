function solve(matrix) {
    matrix = matrix.map(e => e.split(' ').map(e => Number(e)));
    let sumMain = 0;
    let sumSec = 0;
    for (let row = 0; row < matrix.length; row++) {
        sumMain += matrix[row][row];
        sumSec += matrix[row][matrix.length - 1 - row];
    }
    if (sumMain === sumSec) {
        matrix = matrix.map((row, iR) => row.map((e, iC) => {
            if (iR !== iC && iC !== matrix.length - 1 - iR) {
                return e = sumSec;
            }
            return e;
        }))
    }
    return matrix.map(row => row
        .join(' '))
        .join('\n')

}