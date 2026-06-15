public class PerishableParcel extends Parcel{
    private static final int BASE_COST = 3;

    private final int timeToLive;

    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }
    public int getTimeToLive() {
        return timeToLive;
    }

    @Override
    protected int getBaseCost() {
        return BASE_COST;
    }

    public boolean isExpired(int currentDay) {
        if (getSendDay() + timeToLive >= currentDay) {
            return false;
        }
        return true;
    }
}
