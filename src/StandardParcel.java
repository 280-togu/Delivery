public class StandardParcel extends Parcel{
    private static final int BASE_COST = 2;

    @Override
    protected int getBaseCost() {
        return BASE_COST;
    }

    public StandardParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }
}