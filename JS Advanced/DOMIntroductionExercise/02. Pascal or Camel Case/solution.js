function solve() {
    const textToCamelCase = document.getElementById('text').value
        .toLowerCase().split(/\s+/)
        .reduce((acc, el) => {
        return acc += el.charAt(0).toUpperCase() + el.substring(1);
    });
    const convention = document.getElementById('naming-convention').value;
    let output = 'Error!';
    if (convention === 'Camel Case') {
        output = textToCamelCase;
    } else if (convention === 'Pascal Case') {
        output = textToCamelCase.charAt(0).toUpperCase() + textToCamelCase.substring(1);
    }
    document.getElementById('result').textContent = output;
}