function getFibonator() {
    let currentNum = 0;
    let nextNum = 1;
    return () => {
        const fibNum = currentNum + nextNum;
        currentNum = nextNum;
        nextNum = fibNum;
        return currentNum;
    }
}

let fib = getFibonator();
console.log(fib());
console.log(fib());
console.log(fib());
console.log(fib());
console.log(fib());
console.log(fib());
console.log(fib());
console.log(fib());
