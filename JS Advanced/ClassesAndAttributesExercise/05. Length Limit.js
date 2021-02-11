class Stringer {
    constructor(innerString, innerLength) {
        this.innerString = innerString;
        this.innerLength = innerLength;
    }

    increase(value) {
        this.innerLength += value;
    }

    decrease(value) {
        this.innerLength -= value;
        if (this.innerLength < 0) {
            this.innerLength = 0;
        }
    }

    toString() {
        if (this.innerLength === 0) {
            return '...';
        }
        return this.innerString.slice(0, this.innerLength) +
            (this.innerLength < this.innerString.length ?
                '.'.repeat(this.innerString.length - this.innerLength) : '');
    }

}
