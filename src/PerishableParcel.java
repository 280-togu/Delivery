public class PerishableParcel extends Parcel{
    int timeToLive;

    PerishableParcel(String description, int weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    @Override
    protected void packageItem() {
        System.out.println("Посылка" + " " + description + " " + "упакована.");
    }
}
