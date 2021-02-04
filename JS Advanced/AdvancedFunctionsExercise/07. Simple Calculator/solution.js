function solve() {
    let firstNum;
    let secondNum;
    let result;

    function init(selector1, selector2, resultSelector) {
        firstNum = document.querySelector(selector1);
        secondNum = document.querySelector(selector2);
        result = document.querySelector(resultSelector);

    }

    function add() {
        result.value = Number(firstNum.value) + Number(secondNum.value);
    }

    function subtract() {
        result.value = Number(firstNum.value) - Number(secondNum.value);
    }

    return {
        init,
        add,
        subtract
    }
}