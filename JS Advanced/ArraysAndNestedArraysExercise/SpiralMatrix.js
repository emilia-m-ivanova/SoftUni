function solve(rows, cols) {
    let matrix = new Array(rows).fill(0).map(() => new Array(cols).fill(0));
    let fillElement = 1;
    let startRow = 0;
    let startCol = 0;
    let endRow = rows;
    let endCol = cols;
    while (fillElement <= rows * cols) {
        for (let c = startCol; c < endCol; c++) {
            matrix[startRow][c] = fillElement++;
        }
        for (let r = startRow + 1; r < endRow; r++) {
            matrix[r][endCol - 1] = fillElement++;
        }
        for (let c = endCol - 2; c >= startCol; c--) {
            matrix[endRow - 1][c] = fillElement++;
        }
        for (let r = endRow - 2; r > startRow; r--) {
            matrix[r][startCol] = fillElement++;
        }
        startRow++;
        startCol++;
        endRow--;
        endCol--;
    }

    return matrix.map(e => e.join(' ')).join('\n');
}