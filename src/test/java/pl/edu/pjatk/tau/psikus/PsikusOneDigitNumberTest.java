package pl.edu.pjatk.tau.psikus;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pl.edu.pjatk.tau.exceptions.NieudanyPsikusException;
import pl.edu.pjatk.tau.models.GotowyPsikus;

@RunWith(Parameterized.class)
public class PsikusOneDigitNumberTest extends TestCase {

    @Parameterized.Parameters
    public static Object[] data() {
        return new Object[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    }

    private int paramInput;

    public PsikusOneDigitNumberTest(int input) {
        paramInput = input;
    }

    @Test
    public void testCyfrokradShouldReturnNullWhenNumberIsOneDigit() {
        GotowyPsikus gotowyPsikus = new GotowyPsikus();

        assertEquals(null, gotowyPsikus.cyfrokrad(paramInput));
    }

    @Test(expected = NieudanyPsikusException.class)
    public void testHultajchochlaShouldThrowNieudanyPsikusExceptionWhenNumberIsOneDigit() throws NieudanyPsikusException {
        GotowyPsikus gotowyPsikus = new GotowyPsikus();

        gotowyPsikus.hultajchochla(paramInput);
    }
}
