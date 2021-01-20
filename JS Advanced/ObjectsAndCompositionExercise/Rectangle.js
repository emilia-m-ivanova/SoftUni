function rectangle(width, height, color) {
    return {
        width,
        height,
        color: color.charAt(0).toUpperCase() + color.substring(1),
        calcArea() {
            return this.height * this.width;
        }
    };
}
