public abstract class Parcel {
    private final String description;
    private final int weight;
    private final String deliveryAddress;
    private final int sendDay;

    protected abstract int getBaseCost();

    public Parcel(String description, int weight, String deliveryAddress, int sendDay) {
        if (weight < 0) {
            throw new IllegalArgumentException("Вес посылки не может быть отрицательным.");
        }

        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    public void packageItem() {
        System.out.println("Посылка" + " " + description + " " + "упакована.");
    }

    public void deliver() {
        System.out.println("Посылка" + " " + description + " " + "доставлена по адресу" + " " + deliveryAddress);
    }

    public int calculateDeliveryCost() {
        return getBaseCost() * weight;
    }

    public String getDescription() {
        return description;
    }

    public int getWeight() {
        return weight;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public int getSendDay() {
        return sendDay;
    }
}