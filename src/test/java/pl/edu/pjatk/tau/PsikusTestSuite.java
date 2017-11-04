package pl.edu.pjatk.tau;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pl.edu.pjatk.tau.psikus.PsikusOneDigitNumberTest;
import pl.edu.pjatk.tau.psikus.PsikusTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        PsikusTest.class,
        PsikusOneDigitNumberTest.class
})
public class PsikusTestSuite {
}
