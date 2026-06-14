public class PerishableParcel extends Parcel{
    private int timeToLive;

    PerishableParcel(String description, int weight, String deliveryAddress, double sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    protected void packageItem() {
        System.out.println("Посылка" + " " + description + " " + "упакована.");
    }
}
