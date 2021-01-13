function solve(matrix) {
    let mainDiagonal = 0;
    let secDiagonal = 0;
    for (let i = 0; i < matrix.length; i++) {
        mainDiagonal += matrix[i][i];
        secDiagonal += matrix[i][matrix.length - 1 - i];
    }
    return mainDiagonal + ' ' + secDiagonal;
}
