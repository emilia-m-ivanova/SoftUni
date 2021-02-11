class Textbox {
    constructor(selector, regEx) {
        this._invalidSymbols = regEx;
        this._elements = Array.from(document.querySelectorAll(selector));
        for(let i = 0; i < this._elements.length; i++){
            $(selector).eq(i).on('input', () => {
                let val = $(selector).eq(i).val();
                this.value = val;
            });
        }
    }
    get value(){
        return this._value;
    }
    set value(value){
        this._value = value;
        this._elements.forEach(e=>e.value = value);
    }
    get elements(){
        return this._elements;
    }
    isValid(){
        return !this._invalidSymbols.test(this.value);
    }
}

let textbox = new Textbox(".textbox", /[^a-zA-Z0-9]/);
let inputs = Array.from(document.querySelectorAll('.textbox'));
inputs.forEach(i=>i.addEventListener('input',()=> console.log(textbox.value)));
