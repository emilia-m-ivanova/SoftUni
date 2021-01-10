package HotelReservation;

public enum DiscountType {
    VIP(0.2),
    SECONDVISIT(0.1),
    NONE(0);

    private double value;

    DiscountType(double value){
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
