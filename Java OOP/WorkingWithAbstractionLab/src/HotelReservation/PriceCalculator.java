package HotelReservation;

public class PriceCalculator {

    double pricePerDay;
    int numberOfDays;
    Season season;
    DiscountType discountType;

    public PriceCalculator (double pricePerDay, int numberOfDays, Season season, DiscountType discountType){
        this.pricePerDay = pricePerDay;
        this.numberOfDays = numberOfDays;
        this.season = season;
        this.discountType = discountType;
    }

    public double calculatePrice(){
        return ((pricePerDay*season.getValue())*(1-discountType.getValue()))*numberOfDays;
    }
}
