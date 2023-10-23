import static org.junit.jupiter.api.Assertions.*;

import Junit.BootCamp;
import Junit.Grader;
import Junit.SimpleCalculator;
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

    @Test
    void twoPlusTwoShouldEqualFour() {
        SimpleCalculator calculator = new SimpleCalculator();
        assertEquals(4,
                calculator.add(2, 2));
//        assertTrue(calculator.add(2,2) == 4);
    }
    @Test
    void threePlusSevenShouldEqualTen() {
        SimpleCalculator calculator = new SimpleCalculator();
        assertEquals(10,
                calculator.add(3, 7));
    }

    @Test
    void fiftyNineShouldReturnF() {
        var grader = new Grader();
        assertEquals('F', grader.determineLetterGrade(59));
    }

    @Test
    void negativeOneShouldReturnIllegalArgument() {
        var grader = new Grader();
        assertThrows(IllegalArgumentException.class,
                () -> {
                    grader.determineLetterGrade(-1);
                });

    }
}
