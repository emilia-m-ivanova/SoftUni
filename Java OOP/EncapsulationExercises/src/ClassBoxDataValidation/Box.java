package ClassBoxDataValidation;

public class Box {
    private double length;
    private double width;
    private double height;

    Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    private void setLength(double length) {
        checkParam(length, "Length");
        this.length = length;
    }

    private void setWidth(double width) {
        checkParam(width, "Width");
        this.width = width;
    }

    private void setHeight(double height) {
        checkParam(height, "Height");
        this.height = height;
    }

    private void checkParam(double param, String messageStart) {
        if (param <= 0) {
            throw new IllegalArgumentException(messageStart + " cannot be zero or negative.");
        }
    }


    public double calculateSurfaceArea() {
        return (this.height * this.width * 2) + (this.length * this.width * 2) + (this.height * this.length * 2);
    }

    public double calculateLateralSurfaceArea() {
        return (this.height * this.width * 2) + (this.height * this.length * 2);
    }

    public double calculateVolume() {
        return this.length * this.width * this.height;
    }

    @Override
    public String toString() {
        return String.format("Surface Area - %.2f\n" +
                "Lateral Surface Area - %.2f\n" +
                "Volume – %.2f",this.calculateSurfaceArea(),this.calculateLateralSurfaceArea(),this.calculateVolume());
    }
}
