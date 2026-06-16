import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class ParcelBoxTest {

    @Test
    public void shouldAddParcelWhenWeightNotExceeded() {
        ParcelBox<StandardParcel> box = new ParcelBox<>(10);

        StandardParcel parcel = new StandardParcel("Книга", 3, "адрес", 1);

        box.addParcel(parcel);

        List<StandardParcel> parcels = box.getAllParcels();

        assertEquals(1, parcels.size());
        assertEquals(parcel, parcels.get(0));
        assertEquals(3, box.getCurrentWeight());
    }

    @Test
    public void shouldNotAddParcelWhenWeightExceeded() {
        ParcelBox<StandardParcel> box = new ParcelBox<>(5);

        StandardParcel parcel1 = new StandardParcel("Книга", 3, "адрес", 1);
        StandardParcel parcel2 = new StandardParcel("Тяжёлая книга", 4, "адрес", 1);

        box.addParcel(parcel1);
        box.addParcel(parcel2);

        List<StandardParcel> parcels = box.getAllParcels();

        assertEquals(1, parcels.size());
        assertEquals(3, box.getCurrentWeight());
    }

    @Test
    public void shouldAllowExactWeightLimit() {
        ParcelBox<StandardParcel> box = new ParcelBox<>(5);

        StandardParcel parcel1 = new StandardParcel("Книга", 3, "адрес", 1);
        StandardParcel parcel2 = new StandardParcel("Тетрадь", 2, "адрес", 1);

        box.addParcel(parcel1);
        box.addParcel(parcel2);

        assertEquals(2, box.getAllParcels().size());
        assertEquals(5, box.getCurrentWeight());
    }
}