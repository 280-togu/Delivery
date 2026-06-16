import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {


    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static List<Trackable> trackableParcels = new ArrayList<>();
    private static final ParcelBox<StandardParcel> standardBox = new ParcelBox<>(20);
    private static final ParcelBox<FragileParcel> fragileBox = new ParcelBox<>(10);
    private static final ParcelBox<PerishableParcel> perishableBox = new ParcelBox<>(5);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    updateStatuses();
                    break;
                case 5:
                    showBox();
                    break;

                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Обновить статус отправлений");
        System.out.println("5 — Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }


    private static void addParcel() {
        System.out.println("Выберите тип посылки:");
        System.out.println("1 — Стандартная");
        System.out.println("2 — Хрупкая");
        System.out.println("3 — Скоропортящаяся");

        int type = Integer.parseInt(scanner.nextLine());

        System.out.print("Описание: ");
        String description = scanner.nextLine();

        System.out.print("Вес (кг): ");
        int weight = Integer.parseInt(scanner.nextLine());

        System.out.print("Адрес доставки: ");
        String address = scanner.nextLine();

        System.out.print("День отправления: ");
        int sendDay = Integer.parseInt(scanner.nextLine());
        switch (type) {
            case 1:
                StandardParcel standardParcel = new StandardParcel(description, weight, address, sendDay);
                allParcels.add(standardParcel);
                standardBox.addParcel(standardParcel);
                break;
            case 2:
                FragileParcel fragileParcel = new FragileParcel(description, weight, address, sendDay);
                allParcels.add(fragileParcel);
                fragileBox.addParcel(fragileParcel);
                trackableParcels.add(fragileParcel);
                break;
            case 3:
                System.out.print("Время жизни (дни): ");
                int timeToLive = Integer.parseInt(scanner.nextLine());
                PerishableParcel perishableParcel = new PerishableParcel(description, weight, address, sendDay, timeToLive);
                perishableBox.addParcel(perishableParcel);
                allParcels.add(perishableParcel);
                break;
            default:
                System.out.println("Неверный тип посылки.");
        }
    }


    private static void sendParcels() {
        if (allParcels.isEmpty()) {
            System.out.println("Нет посылок для отправления.");
            return;
        }

        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
        }

        System.out.println("Все посылки отправлены.");
    }

    private static void calculateCosts() {
        int totalCost = 0;

        for (Parcel parcel : allParcels) {
            int cost = parcel.calculateDeliveryCost();
            totalCost += cost;
            System.out.println("Посылка " + parcel.getDescription() + ":" + " " + cost);
        }

        System.out.println("Общая стоимость доставки: " + totalCost);
    }

    private static void updateStatuses() {
        if (trackableParcels.isEmpty()) {
            System.out.println("Нет отслеживаемых посылок.");
            return;
        }
        System.out.print("Введите новое местоположение: ");
        String newLocation = scanner.nextLine();
        for (Trackable trackable : trackableParcels) {
            trackable.reportStatus(newLocation);
        }
    }

    private static void showBox() {
        System.out.println("Выберите коробку:");
        System.out.println("1 — Стандартная");
        System.out.println("2 — Хрупкая");
        System.out.println("3 — Скоропортящаяся");

        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                printBox(standardBox);
                break;
            case 2:
                printBox(fragileBox);
                break;
            case 3:
                printBox(perishableBox);
                break;
            default:
                System.out.println("Неверный выбор.");
        }
    }

    private static <T extends Parcel> void printBox(ParcelBox<T> box) {
        if (box.getAllParcels().isEmpty()) {
            System.out.println("Коробка пуста.");
            return;
        }

        for (T parcel : box.getAllParcels()) {
            System.out.println(parcel.getDescription());
        }
    }
}
