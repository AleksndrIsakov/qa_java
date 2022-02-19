import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionTest {
    private final String sex;
    private Lion lion;
    private Feline feline;
    private static final String whenLionIsNull = "Гендерквир";

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    public LionTest(String sex) {
        this.sex = sex;
        try {
            this.feline = Mockito.mock(Feline.class);
            this.lion = new Lion(sex, feline);
        } catch (Exception e) {
            this.lion = null;
            assertEquals("Используйте допустимые значения пола животного - самей или самка", e.getMessage());
        }
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"Самец"},
                {"Самка"},
                {whenLionIsNull}
        };
    }

    @Test
    public void getKittens() {
        int expectedKittens = 1;
        int actualKittens = 0;

        try {
            Mockito.when(feline.getKittens()).thenReturn(expectedKittens);
            actualKittens = lion.getKittens();
            Mockito.verify(feline).getKittens();            // Проверим, что lion.getKittens() вызывает feline.getKittens()
            assertEquals(expectedKittens, actualKittens);    // Проверим, что lion.getKittens() возвращает feline.getKittens()
        } catch (NullPointerException e) {
            assertTrue(sex.equals(whenLionIsNull));
        }

    }

    @Test
    public void doesHaveMane() {
        try {
            boolean doesHaveMane = lion.doesHaveMane();
            if (sex.equals("Самец"))
                assertTrue(doesHaveMane);
            if (sex.equals("Самка"))
                assertFalse(doesHaveMane);
        } catch (NullPointerException e) {
            assertTrue(sex.equals(whenLionIsNull));
        }
    }

    @Test
    public void getFood() {
        try {
            Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
            assertEquals(lion.getFood(), List.of("Животные", "Птицы", "Рыба"));
            Mockito.verify(feline).getFood(Mockito.anyString());
        } catch (Exception e) {
            assertTrue(sex.equals(whenLionIsNull));
        }
    }

}