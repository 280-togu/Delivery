import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParcelTest {
    @Test
    public void shouldThrowExceptionWhenWeightIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> new StandardParcel("Книга", -5, "адрес", 1));
    }
}
