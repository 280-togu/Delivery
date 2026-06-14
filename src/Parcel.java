public abstract class Parcel {
    protected String description;
    protected int weight;
    protected String deliveryAddress;
    protected int sendDay;

    Parcel(String description, int weight, String deliveryAddress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    protected abstract void packageItem();

    protected  void deliver() {
        System.out.println("Посылка" + " " + description + " " + "доставлена по адресу" + " " + deliveryAddress);
    }

    protected abstract class calculateDeliveryCost {
        int cost;
        cost = weight * 10;
    }
}