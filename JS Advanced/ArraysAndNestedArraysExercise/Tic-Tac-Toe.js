function solve(moves) {
    let board = [[false, false, false],
        [false, false, false],
        [false, false, false]];
    let i = 0;
    let player = 'X';
    while (!boardIsFull()) {
        let playerCoordinates = [Number(moves[i][0]), Number(moves[i++][2])];
        if (i < moves.length && checkPosition(playerCoordinates) !== false) {
            console.log('This place is already taken. Please choose another!')
            continue;
        }

        board[playerCoordinates[0]][playerCoordinates[1]] = player;

        if (playerWins(player)) {
            console.log(`Player ${player} wins!`)
            printBoard();
            return;
        }

        if (boardIsFull()) {
            break;
        }
        player = player === 'X' ? 'O' : 'X';
    }

    console.log('The game ended! Nobody wins :(');
    printBoard();

    function boardIsFull() {
        for (const row of board) {
            for (const element of row) {
                if (element === false) {
                    return false;
                }
            }
        }
        return true;
    }

    function printBoard() {
        board.map(e => e.join('\t'))
            .forEach(e => console.log(e));
    }

    function checkPosition(playerPosition) {
        return board[playerPosition[0]][playerPosition[1]];
    }

    function playerWins(player) {
        for (const row of board) {
            if (row[0] === player && row[1] === player && row[2] === player) {
                return true;
            }
        }

        for (let col = 0; col < board[0].length; col++) {
            let wins = true;
            for (let row = 0; row < board.length; row++) {
                if (board[row][col] !== player) {
                    wins = false;
                }
            }
            if (wins === true) {
                return true;
            }
        }

        if (board[0][0] === player && board[1][1] === player && board[2][2] === player) {
            return true;
        }

        if (board[0][2] === player && board[1][1] === player && board[2][0] === player) {
            return true;
        }
        return false;
    }
}
