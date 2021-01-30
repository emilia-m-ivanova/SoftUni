function attachEventsListeners() {
    const ratiosInMeters = {
        km: 1000,
        m: 1,
        cm: 0.01,
        mm: 0.001,
        mi: 1609.34,
        yrd: 0.9144,
        ft: 0.3048,
        in: 0.0254,
    }

    document.querySelector('#convert').addEventListener('click',onClick);
    const inputDistance = document.querySelector('#inputDistance');
    const outputDistance = document.querySelector('#outputDistance');
    const inputUnits = document.querySelector('#inputUnits');
    const outputUnits = document.querySelector('#outputUnits');

    function onClick(){
        const input = Number(inputDistance.value);
        outputDistance.value = input * convert(inputUnits.value,outputUnits.value);
    }

    function convert(from,to){
        return ratiosInMeters[from]/ratiosInMeters[to];
    }
}