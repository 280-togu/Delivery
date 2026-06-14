class Main {
    public static void main(String[] args) {
        StandardParcel standardParcel = new StandardParcel("Стандартная посылка", 5, "ул. Ленина, д. 1", 1.0);
        FragileParcel fragileParcel = new FragileParcel("Хрупкая посылка", 2, "ул. Пушкина, д. 2", 2.0);
        PerishableParcel perishableParcel = new PerishableParcel("Скоропортящаяся посылка", 3, "ул. Гагарина, д. 3", 3.0);

        standardParcel.packageItem();
        fragileParcel.packageItem();
        perishableParcel.packageItem();
    }
}