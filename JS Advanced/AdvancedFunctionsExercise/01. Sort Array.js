function solve(arr, arg) {
    const map = {
        'asc': (a, b) => a - b,
        'desc': (a, b) => b - a,
    }
    return arr.sort(map[arg]);
}

console.log(solve([3, 1, 2, 10, 4, 8, 5, 7, 9, 20, 6], 'desc'))