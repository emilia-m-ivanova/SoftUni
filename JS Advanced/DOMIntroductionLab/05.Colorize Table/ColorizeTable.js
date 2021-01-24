function colorize() {
    const rows = Array.from(document.querySelectorAll('table tr:nth-child(even)'));
    rows.forEach(r=>r.style.background = 'teal');
}