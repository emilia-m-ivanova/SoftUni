function createSortedList() {
    return {
        arr: [],
        add(element) {
            this.arr.push(element);
            this.arr.sort((a, b) => a - b);
            this.size++;
        },
        remove(index) {
            if (0 <= index && index < this.arr.length) {
                this.arr.splice(index, 1);
                this.size--;
            }
        },
        get(index) {
            if (0 <= index && index < this.arr.length) {
                return this.arr[index];
            }
        },
        size: 0,
    }
}