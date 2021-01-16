function solve(arr) {
    const colNum = arr[0];
    const rowNum = arr[1];
    let starPosition = [arr[2], arr[3]];
    let matrix = new Array(rowNum).fill(0).map(() => new Array(colNum).fill(0));
    fillMatrix(0,starPosition[0], starPosition[1]);
    return matrix.map(e => e.join(' ')).join('\n');

    function fillMatrix(value, row, col) {
        if (row+value >= rowNum && col+value >= colNum) {
            return;
        }
        for (let c = col - value; c <= col + value; c++) {
            fillField(row - value, c, value + 1);
            fillField(row + value, c, value + 1);
        }

        for (let r = row - value; r < row + value ; r++) {
            fillField(r,col-value,value+1);
            fillField(r,col+value,value+1);
        }

        fillMatrix(value + 1, row, col);

        function isInBounds(row, col) {
            return 0 <= row && row < rowNum && 0 <= col && col < colNum;
        }

        function fillField(row, col, value) {
            if (!isInBounds(row, col) || matrix[row][col]!==0) {
                return;
            }
            matrix[row][col] = value;
        }
    }
}