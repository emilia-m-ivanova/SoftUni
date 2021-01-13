function aggregate(input) {

    console.log(reduce(input, (acc, c) => acc + c, 0));
    console.log(reduce(input, (acc, c) => acc + (1 / c), 0));
    console.log(reduce(input, (acc, c) => acc + c, ""));

    function reduce(arr, operator, initialValue) {
        let result = initialValue;
        for (let i = 0; i < arr.length; i++) {
            result = operator(result,arr[i]);
        }
        return result;
    }
}
