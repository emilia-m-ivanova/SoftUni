function deleteByEmail() {
    const input = document.querySelector('input[name="email"]').value;
    const emails = Array.from(document.querySelectorAll('tbody tr td:nth-child(2)'));
    let found = false;
    emails.forEach(row => {
        if (row.textContent === input) {
            row.parentNode.remove();
            document.querySelector('#result').textContent = 'Deleted.'
            found = true;
        }
    });
    if (!found) {
        document.querySelector('#result').textContent = 'Not found.';
    }
    document.querySelector('label>input').value = '';
}