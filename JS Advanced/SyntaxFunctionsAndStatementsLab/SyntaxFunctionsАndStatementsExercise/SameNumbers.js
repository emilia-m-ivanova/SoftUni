function digitsAreEqual(num) {
    const lastDigit = num%10;
    const numToString = num.toString();
    let sum = 0;
    let areEqual = true;
    for (const currentDigit of numToString) {
        sum+=Number(currentDigit);
        if(lastDigit!=currentDigit){
            areEqual = false;
        }
    }
    console.log(areEqual.valueOf());
    console.log(sum);
}