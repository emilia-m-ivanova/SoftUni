function solve(arr) {
    let currentBiggest = Number.MIN_SAFE_INTEGER;
    let result = arr
        .filter(e => {
        if (e >= currentBiggest) {
            currentBiggest = e;
            return true;
        }
    });
    return result;
}