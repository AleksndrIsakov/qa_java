import com.example.Animal;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class AnimalTest {

    private Animal animal;
    private final String animalType;

    public AnimalTest(String animalType) {
        this.animalType = animalType;
        this.animal = new Animal();
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"Хищник}"},
                {"Травоядное"},
                {"Непонятное"}
        };
    }

    @Test
    public void getFood() {
        List<String> expected = null;
        switch (animalType) {
            case "Хищник":
                expected = List.of("Животные", "Птицы", "Рыба");
                break;
            case "Травоядное":
                expected = List.of("Трава", "Различные растения");
                break;
        }
    }

    @Test
    public void getFamily() {
        assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", animal.getFamily());
    }
}