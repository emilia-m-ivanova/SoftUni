class List {
    constructor() {
        this.list = [];
        this.size = 0;
    }

    add(num) {
        this.list.push(num);
        this.size++;
        this.list.sort((a, b) => a - b);
    }

    remove(index) {
        if (index < 0 || index >= this.size) {
            return;
        }
        for (let i = index; i < this.list.length - 1; i++) {
            this.list[i] = this.list[i + 1];
        }
        this.list.pop();
        this.size--;
        this.list.sort((a, b) => a - b);
    }

    get(index) {
        if (index < 0 || index >= this.size) {
            return;
        }
        return this.list[index];
    }
}
