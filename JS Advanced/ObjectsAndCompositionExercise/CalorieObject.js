function createObject(arr){
    const products = {};
    for (let i = 0; i < arr.length; i+=2) {
        products[arr[i]] = Number(arr[i+1]);
    }
    return products;
}
