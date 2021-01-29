function lockedProfile() {
    Array.from(document.querySelectorAll('button')).forEach(b => b.addEventListener('click', onClick));

    function onClick(ev) {
        const profile = ev.target.parentNode;
        if (!profile.querySelector('input[type=radio]').checked) {
            ev.target.textContent = ev.target.textContent === 'Hide it' ? 'Show more' : 'Hide it';
            let hiddenSection = profile.querySelector('div');
            hiddenSection.style.display = hiddenSection.style.display === 'block' ? 'none' : 'block';
        }
    }
}