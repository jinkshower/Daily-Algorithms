import static org.junit.jupiter.api.Assertions.assertEquals;

import Junit.BootCamp;
import org.junit.jupiter.api.Test;

public class test {
    @Test
    public void subtotalIsValid() {
        assertEquals(19.2, BootCamp.getsSubtotal());
    }

    @Test
    public void taxIsValid() {
        assertEquals(3.9, BootCamp.getTax(30));
    }

    @Test
    public void totalIsValid() {
        assertEquals(113, BootCamp.getTotal(100, 13));
    }
}
