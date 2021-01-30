function solution() {
    let result = '';
    function append(string) {
        result+=string;
    }

    function removeStart(n) {
        result = result.slice(n);
    }
    function removeEnd(n) {
        result = result.slice(0,-n);
    }
    function print() {
        console.log(result);
    }
     return{
        append,removeStart,removeEnd,print,
     }
}

let secondZeroTest = solution();

secondZeroTest.append('123');
secondZeroTest.append('45');
secondZeroTest.removeStart(2);
secondZeroTest.removeEnd(1);
secondZeroTest.print();
