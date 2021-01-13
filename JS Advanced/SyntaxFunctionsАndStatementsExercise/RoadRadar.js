function roadRadar(speed, area) {
    const limit = {
        'motorway': 130,
        'interstate': 90,
        'city': 50,
        'residential': 20,
    }
    const speeding = speed - limit[area];
    if (speeding <= 0) {
        return `Driving ${speed} km/h in a ${limit[area]} zone`
    }
    let status;
    if (speeding > 40) {
        status = 'reckless driving';
    } else if (speeding > 20) {
        status = 'excessive speeding';
    } else {
        status = 'speeding';
    }
    return `The speed is ${speeding} km/h faster than the allowed speed of ${limit[area]} - ` + status;

}