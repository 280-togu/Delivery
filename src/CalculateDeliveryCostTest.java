import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CalculateDeliveryCostTest {
    @Test
    public void shouldCalculateCostForStandardParcel() {
        StandardParcel standardParcel = new StandardParcel("Книга", 3, "ул. Пушкина, д. 10", 1);
        int cost = standardParcel.calculateDeliveryCost();
        assertEquals(6, cost);
    }
    @Test
    public void shouldReturnZeroForZeroWeightStandardParcel() {
        StandardParcel standardParcel = new StandardParcel("Лист", 0, "ул. Ленина, д. 20", 2);
        int cost = standardParcel.calculateDeliveryCost();
        assertEquals(0, cost);
    }
    @Test
    public void shouldCalculateCostForFragileParcel() {
        FragileParcel fragileParcel = new FragileParcel("Стекло", 5, "ул. Гагарина, д. 15", 3);
        int cost = fragileParcel.calculateDeliveryCost();
        assertEquals(20, cost);
    }
    @Test
    public void shouldReturnZeroForZeroWeightFragileParcel() {
        FragileParcel fragileParcel = new FragileParcel("Пустая коробка", 0, "ул. Ленина, д. 20", 2);
        int cost = fragileParcel.calculateDeliveryCost();
        assertEquals(0, cost);
    }
    @Test
    public void shouldCalculateCostForPerishableParcel() {
        PerishableParcel perishableParcel = new PerishableParcel("Молоко", 3, "ул. Советская, д. 5", 4, 7);
        int cost = perishableParcel.calculateDeliveryCost();
        assertEquals(9, cost);
    }
    @Test
    public void shouldReturnZeroForZeroWeightPerishableParcel() {
        PerishableParcel perishableParcel = new PerishableParcel("Пустая коробка", 0, "ул. Ленина, д. 20", 2, 5);
        int cost = perishableParcel.calculateDeliveryCost();
        assertEquals(0, cost);
    }
}

