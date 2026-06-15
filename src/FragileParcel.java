public class FragileParcel extends Parcel implements Trackable {
    private static final int BASE_COST = 4;

    @Override
    protected int getBaseCost() {
        return BASE_COST;
    }

    public FragileParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public void packageItem() {
        System.out.println("Посылка" + " " + getDescription() + " " + "обёрнута в защитную плёнку");
        super.packageItem();
    }

    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Хрупкая посылка" + " " + getDescription() + " " + "изменила местоположение на" + " " + newLocation);
    }
}
