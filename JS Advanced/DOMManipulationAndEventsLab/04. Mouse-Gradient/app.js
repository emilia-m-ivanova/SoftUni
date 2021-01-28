function attachGradientEvents() {
    const box = document.querySelector('#gradient');
    box.addEventListener('mousemove',gradientMove);
    function gradientMove(ev) {
        const percent = (ev.offsetX/box.clientWidth)*100;
        document.querySelector('#result').textContent = Math.floor(percent) + '%';
    }
}