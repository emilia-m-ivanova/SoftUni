function solve(n, k) {
    let arr = [1];
    for (let i = 1; i < n; i++) {
        let lastKElements = arr.slice(-k);
        let sum = lastKElements.reduce((acc,x)=> acc + x,0);
        arr.push(sum);
    }
    return arr;
}