function solve(json) {
    let arr = JSON.parse(json);
    let result = '<table>\n';
    result+=makeKeyRow(arr);
    arr.forEach((obj) => result+=(makeValueRow(obj)));
    result+=('</table>');

    function makeKeyRow(arr) {
        let row = arr[0];
        let headings = ['<tr>'];
        for (const key in row) {
            const value = escapeHtml(key);
            headings.push(`<th>${value}</th>`);
        }
        headings.push('</tr>');
        return headings.join('')+'\n';
    }

    function makeValueRow(obj) {
        let row = ['<tr>'];
        for (const key in obj) {
            const value = escapeHtml(obj[key]);
            row.push(`<td>${value}</td>`);
        }
        row.push('</tr>');
        return row.join('')+'\n';
    }

    function escapeHtml(value) {
        return value.toString()
            .replace(/&/g, "&amp;")
            .replace(/</g, "&lt;")
            .replace(/>/g, "&gt;")
            .replace(/"/g, "&quot;")
            .replace(/'/g, "&#39;");
    }
    return result;
}