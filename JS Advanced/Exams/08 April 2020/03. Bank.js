class Bank {
    constructor(bankName) {
        this._bankName = bankName;
        this.allCustomers = [];
    }

    newCustomer(customer) {
        const currentCustomer = this.allCustomers.find(c=>c.personalId===customer.personalId);
        if (currentCustomer) {
            throw new Error(`${customer.firstName} ${customer.lastName} is already our customer!`);
        }
        this.allCustomers.push(customer);
        return customer;
    }

    depositMoney(id, amount) {
        const currentCustomer = this.allCustomers.find(c=>c.personalId===id);
        if (!currentCustomer) {
            throw new Error('We have no customer with this ID!')
        }
        currentCustomer.totalMoney = currentCustomer.totalMoney ? currentCustomer.totalMoney + amount : amount;
        if (!currentCustomer.transactions) {
            currentCustomer.transactions = [];
        }
        currentCustomer.transactions.push(`${currentCustomer.firstName} ${currentCustomer.lastName} made deposit of ${amount}$!`);
        return currentCustomer.totalMoney + '$';
    }

    withdrawMoney(id, amount) {
        const currentCustomer = this.allCustomers.find(c=>c.personalId===id);
        if (!currentCustomer) {
            throw new Error('We have no customer with this ID!');
        }
        if (!currentCustomer.totalMoney || currentCustomer.totalMoney < amount) {
            throw new Error(`${currentCustomer.firstName} ${currentCustomer.lastName} does not have enough money to withdraw that amount!`)
        }
        currentCustomer.totalMoney = currentCustomer.totalMoney - amount;
        currentCustomer.transactions.push(`${currentCustomer.firstName} ${currentCustomer.lastName} withdrew ${amount}$!`);
        return currentCustomer.totalMoney + '$';
    }

    customerInfo(id) {
        const currentCustomer = this.allCustomers.find(c=>c.personalId===id);
        if (!currentCustomer) {
            throw new Error('We have no customer with this ID!')
        }
        const money = currentCustomer.totalMoney ? currentCustomer.totalMoney : 0;
        const transactions = currentCustomer.transactions === undefined ?
            '' : '\nTransactions:\n' + `${currentCustomer.transactions.map((e, i) => i+1 + '. ' + e).reverse().join('\n')}`
        return `Bank name: ${this._bankName}\n` +
            `Customer name: ${currentCustomer.firstName} ${currentCustomer.lastName}\n` +
            `Customer ID: ${currentCustomer.personalId}\n` +
            `Total Money: ${money}$` +
            transactions;
    }
}
