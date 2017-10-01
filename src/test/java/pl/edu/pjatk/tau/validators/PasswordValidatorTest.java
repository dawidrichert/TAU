package pl.edu.pjatk.tau.validators;

import junit.framework.TestCase;

public class PasswordValidatorTest extends TestCase {

    public void testShouldReturnTrueWhenPasswordIsValid() {
        assertTrue(new PasswordValidator("RazDwaTrzy3#").isValid());
        assertTrue(new PasswordValidator("Super!!111").isValid());
    }

    public void testShouldReturnFalseWhenPasswordIsInvalid() {
        assertFalse(new PasswordValidator("test").isValid());
    }

    public void testShouldReturnFalseWhenPasswordIsShorterThan8Characters() {
        assertFalse(new PasswordValidator("a").isValid());
        assertFalse(new PasswordValidator("A#").isValid());
        assertFalse(new PasswordValidator("A2@").isValid());
        assertFalse(new PasswordValidator("aA1!").isValid());
        assertFalse(new PasswordValidator("aA1#!").isValid());
        assertFalse(new PasswordValidator("aA1!#&").isValid());
        assertFalse(new PasswordValidator("aA(*$1!").isValid());
    }

    public void testShouldReturnFalseWhenPasswordDoesntContainSpecialCharacter() {
        assertFalse(new PasswordValidator("SuperPassword").isValid());
        assertFalse(new PasswordValidator("12345678").isValid());
    }

    public void testShouldReturnFalseWhenPasswordDoesntContainNumberCharacter() {
        assertFalse(new PasswordValidator("SuperPassword").isValid());
        assertFalse(new PasswordValidator("DAS@#!#*!@!@").isValid());
    }

    public void testShouldReturnFalseWhenPasswordDoesntContainLowerCaseCharacter() {
        assertFalse(new PasswordValidator("DSAH@#@7821").isValid());
        assertFalse(new PasswordValidator("JCZXJK@@!!&^8").isValid());
    }

    public void testShouldReturnFalseWhenPasswordDoesntContainUpperCaseCharacter() {
        assertFalse(new PasswordValidator("dsadasd@*&!621").isValid());
        assertFalse(new PasswordValidator("czh4@2121").isValid());
    }

    public void testShouldReturnFalseWhenPasswordIsNull() {
        assertFalse(new PasswordValidator(null).isValid());
    }
}
