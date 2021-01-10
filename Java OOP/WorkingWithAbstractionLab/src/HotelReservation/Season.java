package HotelReservation;

public enum Season {
    AUTUMN(1),
    SPRING(2),
    SUMMER(4),
    WINTER(3);

    private int value;

    Season(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
