public class StandardParcel extends Parcel{
    StandardParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    protected void packageItem() {
        System.out.println("Посылка" + " " + description + " " + "упакована.");
    }
}