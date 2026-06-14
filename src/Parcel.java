public abstract class Parcel {
    protected String description;
    protected int weight;
    protected String deliveryAddress;
    protected double sendDay;

    Parcel(String description, int weight, String deliveryAddress, double sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    protected abstract void packageItem(); {
    }
    protected  void Delivery() {
        System.out.println("Посылка" + " " + description + " " + "доставлена по адресу" + " " + deliveryAddress);
    }

}
