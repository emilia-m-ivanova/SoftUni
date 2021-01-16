function solve(arr) {
    let result = arr
        .sort((a, b) => a.localeCompare(b))
        .map((e, i) => i+1 + '.' + e)
    return result.join('\n');
}