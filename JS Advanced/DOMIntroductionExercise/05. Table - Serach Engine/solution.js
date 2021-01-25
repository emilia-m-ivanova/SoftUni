function solve() {
    document.querySelector('#searchBtn').addEventListener('click', onClick);

    function onClick() {
        const input = document.getElementById('searchField').value;
        document.getElementById('searchField').value = '';
        const rows = Array.from(document.querySelectorAll('tbody tr'));
        rows.forEach(row => {
            if (row.textContent.includes(input)) {
                row.classList.add('select');
            }else{
                row.removeAttribute('class')
            }
        });
    }
}