import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

public class FelineTest {

    private Feline feline;

    @Before
    public void init(){
        feline = new Feline();
    }

    @Test
    public void eatMeat() throws Exception {
            assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

    @Test
    public void getFamily() {
        assertEquals(feline.getFamily(), "Кошачьи");
    }

    @Test
    public void getKittens() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void testGetKittens() {
        assertEquals(100, feline.getKittens(100));
    }
}