package pl.edu.pjatk.tau.validators;

import junit.framework.TestCase;

import java.time.LocalDate;

public class PeselValidatorTest extends TestCase {

    public void testShouldReturnTrueWhenPeselIsValid() {
        assertTrue(new PeselValidator("94080502097").isValid());
        assertTrue(new PeselValidator("59041311273").isValid());
        assertTrue(new PeselValidator("32090305983").isValid());
        assertTrue(new PeselValidator("48031203032").isValid());
    }

    public void testShouldReturnFalseWhenPeselIsNotValid() {
        assertFalse(new PeselValidator("111111111111").isValid());
        assertFalse(new PeselValidator("222222222222").isValid());
        assertFalse(new PeselValidator("333333333333").isValid());
        assertFalse(new PeselValidator("444444444444").isValid());
    }

    public void testShouldReturnTrueWhenPeselIsMatchedToDateOfBirth() {
        PeselValidator peselValidator = new PeselValidator("94080502097");
        LocalDate localDate = LocalDate.of(1994, 8, 5);

        boolean result = peselValidator.isValid()
                && peselValidator.getBirthDay() == localDate.getDayOfMonth()
                && peselValidator.getBirthMonth() == localDate.getMonthValue()
                && peselValidator.getBirthYear() == localDate.getYear();

        assertTrue(result);
    }

    public void testShouldReturnFalseWhenPeselIsNotMatchedToDateOfBirth() {
        PeselValidator peselValidator = new PeselValidator("59041311273");
        LocalDate localDate = LocalDate.of(1994, 8, 5);

        boolean result = peselValidator.isValid()
                && peselValidator.getBirthDay() == localDate.getDayOfMonth()
                && peselValidator.getBirthMonth() == localDate.getMonthValue()
                && peselValidator.getBirthYear() == localDate.getYear();

        assertFalse(result);
    }

    public void testShouldReturnFalseWhenPeselContainsNotAllowedCharacters() {
        assertFalse(new PeselValidator("adj374819dj").isValid());
    }

    public void testShouldReturnFalseWhenPeselHasLessThan11Characters() {
        assertFalse(new PeselValidator("1").isValid());
        assertFalse(new PeselValidator("12").isValid());
        assertFalse(new PeselValidator("123").isValid());
        assertFalse(new PeselValidator("1234").isValid());
        assertFalse(new PeselValidator("12345").isValid());
        assertFalse(new PeselValidator("123456").isValid());
        assertFalse(new PeselValidator("1234567").isValid());
        assertFalse(new PeselValidator("12345678").isValid());
        assertFalse(new PeselValidator("123456789").isValid());
        assertFalse(new PeselValidator("1234567890").isValid());
    }

    public void testShouldReturnFalseWhenPeselHasMoreThan11Characters() {
        assertFalse(new PeselValidator("123456789012").isValid());
        assertFalse(new PeselValidator("1234567890123").isValid());
        assertFalse(new PeselValidator("12345678901234").isValid());
        assertFalse(new PeselValidator("123456789012345").isValid());
    }

    public void testShouldReturnFalseWhenPeselIsNull() {
        assertFalse(new PeselValidator(null).isValid());
    }
}
