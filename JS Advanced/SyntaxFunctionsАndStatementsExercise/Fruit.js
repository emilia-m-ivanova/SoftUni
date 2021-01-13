function calculatePrice(fruit, weightInGr, pricePerKg){
    const weightInKg = weightInGr / 1000;
    const totalPrice = weightInKg * pricePerKg;
    console.log(`I need $${totalPrice.toFixed(2)} to buy ${weightInKg.toFixed(2)} kilograms ${fruit}.`)
}
