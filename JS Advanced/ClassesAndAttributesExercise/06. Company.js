class Company {
    constructor() {
        this.departments = [];
    }

    addEmployee(username, salary, position, department) {

        if (!username || !salary || salary < 0 || !position || !department) {
            throw new Error('Invalid input!');
        }

        if (!this.departments[department]) {
            this.departments[department] = [];
        }
        this.departments[department].push({
            username, salary, position
        });
        return `New employee is hired. Name: ${username}. Position: ${position}`
    }

    bestDepartment() {

        let bestSalary = 0;
        let bestDep = '';

        for (const key in this.departments) {
            this.departments[key] = this.departments[key]
                .sort((a,b)=>a.username.localeCompare(b.username))
                .sort((a, b) => {
                return b.salary - a.salary;
            });
            let average = this.departments[key].reduce((acc, el) => {
                return acc + el.salary;
            }, 0) / this.departments[key].length;
            this.departments[key].average = average;
            if (average > bestSalary) {
                bestSalary = average;
                bestDep = key;
            }
        }

        return `Best Department is: ${bestDep}
Average salary: ${this.departments[bestDep].average.toFixed(2)}\n`
            + this.departments[bestDep].map(e=>{
                return e.username + ' ' + e.salary + ' ' + e.position;
            }).join('\n');
    }

}