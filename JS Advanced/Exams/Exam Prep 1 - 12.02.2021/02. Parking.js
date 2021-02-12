class Parking {
    constructor(capacity) {
        this.capacity = capacity;
        this.vehicles = [];
    }

    addCar(carModel, carNumber) {
        if (this.vehicles.length === this.capacity) {
            throw new Error('Not enough parking space.');
        }
        this.vehicles.push({carModel, carNumber, payed: false});
        return `The ${carModel}, with a registration number ${carNumber}, parked.`
    }

    removeCar(carNumber) {
        const car = this.vehicles.find(c => c.carNumber === carNumber);
        if (!car) {
            throw new Error('The car, you\'re looking for, is not found.');
        }
        if (!car.payed) {
            throw new Error(`${carNumber} needs to pay before leaving the parking lot.`);
        }
        this.vehicles = this.vehicles.filter(e => e !== car);
        return `${carNumber} left the parking lot.`;
    }

    pay(carNumber) {
        const car = this.vehicles.find(c => c.carNumber === carNumber);
        if (!car) {
            throw new Error(`${carNumber} is not in the parking lot.`);
        }
        if (car.payed) {
            throw new Error(`${carNumber}'s driver has already payed his ticket.`);
        }
        car.payed = true;
        return `${carNumber}'s driver successfully payed for his stay.`;
    }

    getStatistics(carNumber) {
        if (carNumber) {
            const car = this.vehicles.find(c => c.carNumber === carNumber);
            return `${car.carModel} == ${car.carNumber} - ${car.payed === true ? 'Has payed' : 'Not payed'}`
        } else {
            return `The Parking Lot has ${this.capacity - this.vehicles.length} empty spots left.` +
                (this.vehicles.length > 0 ? '\n' +
                this.vehicles.sort((a, b) => a.carModel.localeCompare(b.carModel))
                    .map(car => {
                        return `${car.carModel} == ${car.carNumber} - ${car.payed === true ? 'Has payed' : 'Not payed'}`
                    })
                    .join('\n') : '');
        }
    }
}