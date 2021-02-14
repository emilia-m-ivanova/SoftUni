function solve() {
    class Employee {
        constructor(name, age, tasks) {
            if (new.target === Employee) {
                throw new Error('Cannot instantiate directly.')
            }
            this.name = name;
            this.age = age;
            this.salary = 0;
            this.tasks = tasks;
            this.currentTaskIndex = 0;
        }

        work() {
            this.currentTaskIndex = this.currentTaskIndex % this.tasks.length;
            console.log(this.tasks[this.currentTaskIndex++]);
        }

        collectSalary() {
            console.log(`${this.name} received ${this.getSalary()} this month.`)
        }

        getSalary() {
            return this.salary;
        }
    }

    class Junior extends Employee {
        constructor(name, age) {
            super(name, age, [name + ' is working on a simple task.']);
        }
    }

    class Senior extends Employee {
        constructor(name, age) {
            const tasks = [name + ' is working on a complicated task.',
                name + ' is taking time off work.',
                name + ' is supervising junior workers.']
            super(name, age, tasks);

        }
    }

    class Manager extends Employee {
        constructor(name, age) {
            const tasks = [name + ' scheduled a meeting.',
                name + ' is preparing a quarterly report.'];
            super(name, age, tasks);
            this.dividend = 0;
        }

        getSalary() {
            return this.salary + this.dividend;
        }
    }

    return {
        Employee,
        Junior,
        Senior,
        Manager,
    }
}