function createCar(order) {
    function getEngine(power) {
        const engines = [
            {power: 90, volume: 1800},
            {power: 120, volume: 2400},
            {power: 200, volume: 3500}
        ]
        return engines.find(e => e.power >= power);
    }

    function getWheels(wheelsize) {
        wheelsize%2===0?wheelsize--:wheelsize;
        return Array(4).fill(wheelsize,0,4);}

    return {
        model: order.model,
        engine: getEngine(order.power),
        carriage: {type: order.carriage, color: order.color},
        wheels: getWheels(order.wheelsize),
    }
}