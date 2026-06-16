import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IsExpiredTest {
    @Test
    public void shouldReturnTrueIfParcelIsExpired() {
        PerishableParcel perishableParcel = new PerishableParcel("Молоко", 3, "ул. Советская, д. 5", 4, 0);
        assertTrue(perishableParcel.isExpired(10));
    }

    @Test
    public void shouldReturnFalseIfParcelNotExpired() {
        PerishableParcel perishableParcel = new PerishableParcel("Молоко", 3, "ул. Советская, д. 5", 4, 7);
        assertFalse(perishableParcel.isExpired(5));
    }

    @Test
    public void shouldReturnFalseWhenParcelStillValidAtBoundary() {
        PerishableParcel perishableParcel = new PerishableParcel("Молоко", 3, "ул. Советская, д. 5", 30, 2);
        assertFalse(perishableParcel.isExpired(31));
    }

    @Test
    public void shouldReturnFalseWhenExactlyAtExpiryLimit() {
        PerishableParcel parcel = new PerishableParcel("Молоко", 3, "адрес", 4, 7);
        assertFalse(parcel.isExpired(11));
    }
    @Test
    public void shouldReturnTrueWhenParcelIsActuallyExpired() {
        PerishableParcel parcel = new PerishableParcel("Молоко", 3, "адрес", 10, 2);
        assertTrue(parcel.isExpired(13));
    }
}
