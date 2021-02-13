function result() {

    class Figure {
        constructor(units = 'cm') {
            this.units = units;
        }

        get area() {

        }

        changeUnits(units) {
            this.units = units;
        }

        transformMetric(valueInCm) {
            return this.units === 'm' ?
                valueInCm / 100 :
                this.units === 'mm' ?
                    valueInCm * 10 :
                    valueInCm;
        }

        toString() {
            return 'Figures units: ' + this.units;
        }
    }

    class Circle extends Figure {
        constructor(r) {
            super();
            this.r = r;
        }

        get area() {
            const r = this.transformMetric(this.r);
            return r * r * Math.PI;
        }

        toString() {
            return super.toString() + ` Area: ${this.area} - radius: ${this.transformMetric(this.r)}`;
        }
    }

    class Rectangle extends Figure {
        constructor(width, height, units) {
            super(units);
            this.width = width;
            this.height = height;
        }

        get area() {
            const width = this.transformMetric(this.width);
            const height = this.transformMetric(this.height);
            return width * height;
        }

        toString() {
            return super.toString() + ` Area: ${this.area} - width: ${this.transformMetric(this.width)}, height: ${this.transformMetric(this.height)}`;
        }
    }

    return {
        Figure,
        Circle,
        Rectangle,
    }
}