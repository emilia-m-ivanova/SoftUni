function getGCD (first, second){
    for (let i = 2; i <= Math.min(first,second); i++) {
        if(first%i==0 && second%i == 0){
            return i;
        }
    }
    return 1;
}