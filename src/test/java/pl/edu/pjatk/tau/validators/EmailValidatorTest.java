package pl.edu.pjatk.tau.validators;

import junit.framework.TestCase;

public class EmailValidatorTest extends TestCase {

    public void testShouldReturnTrueWhenEmailIsValid() {
        assertTrue(new EmailValidator("dawidrichert@gmail.com").isValid());
        assertTrue(new EmailValidator("test@test.pl").isValid());
    }

    public void testShouldReturnFalseWhenEmailDoesntContainAtCharacter() {
        assertFalse(new EmailValidator("dawidrichertgmail.com").isValid());
        assertFalse(new EmailValidator("testtest.pl").isValid());
    }

    public void testShouldReturnFalseWhenEmailIsInvalid() {
        assertFalse(new EmailValidator("test").isValid());
        assertFalse(new EmailValidator("test@").isValid());
        assertFalse(new EmailValidator("test@@").isValid());
        assertFalse(new EmailValidator("test@.pl").isValid());
        assertFalse(new EmailValidator("@test.pl").isValid());
        assertFalse(new EmailValidator("test").isValid());
    }

    public void testShouldReturnFalseWhenEmailIsNull() {
        assertFalse(new EmailValidator(null).isValid());
    }
}
