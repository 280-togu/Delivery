import java.util.List;
import java.util.ArrayList;

public class ParcelBox<T extends Parcel> {
    private final int maxWeight;
    private int currentWeight;
    private final List<T> parcels;

    public ParcelBox(int maxWeight) {
        this.maxWeight = maxWeight;
        this.currentWeight = 0;
        this.parcels = new ArrayList<>();
    }
    public int getMaxWeight() {
        return maxWeight;
    }
    public int getCurrentWeight() {
        return currentWeight;
    }

    public void addParcel(T parcel) {
        if (currentWeight + parcel.getWeight() > maxWeight) {
            System.out.println("Невозможно добавить посылку: превышен максимальный вес коробки.");
            return;
        }
        parcels.add(parcel);
        currentWeight += parcel.getWeight();
        System.out.println("Посылка " + parcel.getDescription() + " добавлена в коробку.");
    }

    public List<T> getAllParcels() {
        return parcels;
    }
}
