function findLowestPrices(arr) {
    const products = {};
    arr.forEach(e => {
        let [city, product, price] = e.split(' | ');
        price = Number(price);
        if (products[product] &&
            products[product].city !== city &&
            price >= products[product].price
        ) {
            price = products[product].price;
            city = products[product].city;
        }
        products[product] = {city, price};
    })
    let result = '';
    Object.entries(products).forEach(([key, value]) => {
        result += key + ' -> ' + value.price + ' (' + value.city + ')\n';
    });
    return result;
}
