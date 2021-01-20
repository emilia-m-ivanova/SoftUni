function solve(arr) {
    const result = [];
    for (const e of arr) {
        if (typeof e == 'number') {
            result.push(e)
        } else {
            if (result.length < 2) {
                return 'Error: not enough operands!';
            }
            const num2 = result.pop();
            const num1 = result.pop();
            const operation = {
                '*': num1 * num2,
                '/': num1 / num2,
                '+': num1 + num2,
                '-': num1 - num2,
            }
            result.push(operation[e]);
        }
    }

return result.length === 1 ? result[0] : 'Error: too many operands!';
}