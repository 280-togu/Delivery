public class FragileParcel extends Parcel {
    FragileParcel(String description, int weight, String deliveryAddress, double sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    protected void packageItem() {
        System.out.println("Посылка" + " " + description + " " + "обёрнута в защитную плёнку");
        System.out.println("Посылка" + " " + description + " " + "упакована.");
    }
}
