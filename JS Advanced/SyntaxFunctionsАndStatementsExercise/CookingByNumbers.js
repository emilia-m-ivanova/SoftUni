function solve(num, operation1, operation2, operation3, operation4, operation5) {
    num = Number(num);
    const arr = [operation1, operation2, operation3, operation4, operation5];
    const operation = {
        'chop': n => n / 2,
        'dice': n => Math.sqrt(n),
        'spice': n => n + 1,
        'bake': n => n * 3,
        'fillet': n => n * 0.8,
    }
    let result = '';
    for (const element of arr) {
        result += (num = operation[element](num)) + '\n';
    }
    return result;
}