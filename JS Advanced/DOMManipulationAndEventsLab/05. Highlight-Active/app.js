function focus() {
   const inputElements = Array.from(document.querySelectorAll('input'));
    inputElements.forEach(e=>{
        e.addEventListener('focus',selectOnFocus);
        e.addEventListener('blur',blurred);
    });

    function selectOnFocus(ev) {
        ev.target.parentNode.className = 'focused';
    }

    function blurred(ev) {
        ev.target.parentNode.className = '';
    }
}