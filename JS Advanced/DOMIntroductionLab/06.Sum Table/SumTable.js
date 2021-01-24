function sumTable() {
    const rows = Array.from(document.querySelectorAll('table tr')).slice(1, -1);
    document.querySelector('#sum').textContent = rows.reduce((sum, row) => {
        return sum + Number(row.lastChild.textContent);
    }, 0);
}