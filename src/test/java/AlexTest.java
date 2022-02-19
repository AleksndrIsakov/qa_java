import com.example.Alex;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AlexTest {

    private Alex alexLion;

    @Mock
    Feline feline;

    @Before
    public void init() {
        try {
            alexLion = new Alex(feline);
        } catch (Exception e) {
            assertNull(e);
        }

    }

    @Test
    public void getKittens() {
        assertEquals(0, alexLion.getKittens());
    }

    @Test
    public void getFriends() {
        assertEquals(List.of("Марти", "Глория", "Мелман"), alexLion.getFriends());
    }

    @Test
    public void getPlaceOfLiving() {
        assertEquals("Нью-Йоркский зоопарк", alexLion.getPlaceOfLiving());
    }
}