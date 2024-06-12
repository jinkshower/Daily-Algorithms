import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import Junit.BootCamp;
import Junit.Grader;
import Junit.SimpleCalculator;
import Junit.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @Test
    @DisplayName("User should be at least 18")
    void user_should_be_at_least_18() {
        var user = new User("Marco", 37, false);
        assertThat(user.getAge()).isGreaterThanOrEqualTo(18);

    }

    @Test
    @DisplayName("Marco should be blocked")
    void marco_should_be_blocked() {
        var user = new User("Marco", 37, false);
        assertThat(user.isBlocked())
                .as("User %s should be blocked", user.getName())
                .isTrue();
    }

    @Test
    void user_should_be_marco() {
        var user = new User("Marco", 37, false);
        assertThat(user.getName()).isEqualToIgnoringCase("marco");
    }

    @ParameterizedTest
    @ValueSource(ints = {17, 50, 80})
    void all_friends_should_at_least_be_18(int age) {
        assertThat(age).isGreaterThanOrEqualTo(18);
    }
}
