import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    private Feline feline;

    @Before
    public void init() {
        this.feline = Mockito.mock(Feline.class);
    }

    @Test
    public void getKittens() throws Exception {
        Lion lion = new Lion("Самка", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        assertEquals(1, lion.getKittens());
        Mockito.verify(feline).getKittens();
    }

    @Test
    public void doesHaveMane() throws Exception {
            Lion lion = new Lion("Самец", feline);
            assertTrue(lion.doesHaveMane());
    }

    @Test
    public void doesntHaveMane() throws Exception {
        Lion lion = new Lion("Самка", feline);
        assertFalse(lion.doesHaveMane());
    }

    @Test
    public void getFood() throws Exception {
            Lion lion = new Lion("Самец", feline);
            Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
            assertEquals(lion.getFood(), List.of("Животные", "Птицы", "Рыба"));
            Mockito.verify(feline).getFood(Mockito.anyString());
    }

}