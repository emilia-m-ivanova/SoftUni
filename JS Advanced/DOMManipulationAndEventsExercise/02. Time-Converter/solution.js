function attachEventsListeners() {

    document.querySelector('main').addEventListener('click', onClick);

    function onClick(ev) {
        if(ev.target.type!=='button'){
            return;
        }
        const inputArea = ev.target.parentNode;
        const inputField = inputArea.querySelector('input[type=text]');
        Array.from(document.querySelectorAll('input[type=text]')).forEach(el=>{
            el.value = converter(inputField,el.id)
        });
    }

    function converter(inputElement, convertTo) {

        const value = convertDays(Number(inputElement.value), convertTo);
        const type = inputElement.id;
        const result = {
            days: value,
            hours: value / 24,
            minutes: value / 1440,
            seconds: value / 86400,
        }
        return result[type];
    }

    function convertDays(value, convertTo) {
        const days = {
            days: value,
            hours: value * 24,
            minutes: value * 1440,
            seconds: value * 86400,
        }
        return days[convertTo];
    }
}