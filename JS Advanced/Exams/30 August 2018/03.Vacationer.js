class Vacationer {
    constructor(fullName, creditCard =
        [1111, '', 111]) {
        this.fullName = fullName;
        this._idNumber = this.generateIDNumber();
        this._creditCard = this.addCreditCardInfo(creditCard);
        this.wishList = [];
    }

    set fullName(fullName) {
        if (fullName.length !== 3) {
            throw new Error('Name must include first name, middle name and last name');
        }
        if (fullName.some(e => !e.match(/^[A-Z][a-z]+$/))) {
            throw new Error('Invalid full name');
        }
        this._fullName = {
            firstName: fullName[0],
            middleName: fullName[1],
            lastName: fullName[2],
        };
    }

    get fullName() {
        return this._fullName;
    }

    get idNumber() {
        return this._idNumber;
    }

    generateIDNumber() {
        //231 * firstName’s first letter’s ASCII code + 139 * middleName length
        const vowels = ["a", "e", "o", "i", "u"];
        return 231 * this.fullName.firstName.charCodeAt(0) + 139 * this.fullName.middleName.length +
            (vowels.some(e => this.fullName.lastName.endsWith(e)) ? '8' : '7');
    }

    addCreditCardInfo(arr) {
        if (arr.length !== 3) {
            throw new Error('Missing credit card information');
        }
        if (typeof arr[0] !== 'number' || typeof arr[2] !== 'number') {
            throw new Error('Invalid credit card details');
        }

        return this._creditCard = {
            cardNumber: Number(arr[0]),
            expirationDate: arr[1],
            securityNumber: Number(arr[2])
        }
    }

    get creditCard() {
        return this._creditCard;
    }

    addDestinationToWishList(destination) {
        if (this.wishList.some(e => e === destination)) {
            throw new Error('Destination already exists in wishlist');
        }
        this.wishList.push(destination);
        this.wishList = this.wishList.sort((a, b) => a.length - b.length)
    }

    getVacationerInfo() {
        return `Name: ${this.fullName.firstName} ${this.fullName.middleName} ${this.fullName.lastName}\n` +
            `ID Number: ${this.idNumber}\n` +
            `Wishlist:\n` +
            (this.wishList.length === 0 ? 'empty\n' :
                this.wishList.join(', ') + '\n') +
            'Credit Card:\n' +
            `Card Number: ${this.creditCard.cardNumber}\n` +
            `Expiration Date: ${this.creditCard.expirationDate}\n` +
            `Security Number: ${this.creditCard.securityNumber}`;
    }
}

// Initialize vacationers with 2 and 3 parameters
let vacationer1 = new Vacationer(["Vania", "Ivanova", "Zhivkova"]);
let vacationer2 = new Vacationer(["Tania", "Ivanova", "Zhivkova"],
    [123456789, "10/01/2018", 777]);
console.log(vacationer1.idNumber);
console.log(vacationer2.creditCard)
console.log(vacationer1.creditCard)

// Should throw an error (Invalid full name)
try {
    let vacationer3 = new Vacationer(["Vania", "Ivanova", "ZhiVkova"]);
} catch (err) {
    console.log("Error: " + err.message);
}

// Should throw an error (Missing credit card information)
try {
    let vacationer3 = new Vacationer(["Zdravko", "Georgiev", "Petrov"]);
    vacationer3.addCreditCardInfo([123456789, "20/10/2018"]);
} catch (err) {
    console.log("Error: " + err.message);
}

vacationer1.addDestinationToWishList('Spain');
vacationer1.addDestinationToWishList('Germany');
vacationer1.addDestinationToWishList('Bali');

// Return information about the vacationers
console.log(vacationer1.getVacationerInfo());
console.log(vacationer2.getVacationerInfo());
