package pl.edu.pjatk.tau.psikus;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import pl.edu.pjatk.tau.exceptions.NieudanyPsikusException;
import pl.edu.pjatk.tau.models.GotowyPsikus;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.AnyOf.anyOf;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(value = BlockJUnit4ClassRunner.class)
public class PsikusTest extends TestCase {

    @Test
    public void testCyfrokradShouldRemoveOneRandomNumber() {
        GotowyPsikus gotowyPsikus = new GotowyPsikus();

        assertThat(gotowyPsikus.cyfrokrad(45), anyOf(equalTo(4), equalTo(5)));
        assertThat(gotowyPsikus.cyfrokrad(739), anyOf(equalTo(73), equalTo(39), equalTo(79)));
        assertThat(gotowyPsikus.cyfrokrad(1234), anyOf(equalTo(123), equalTo(124), equalTo(234), equalTo(134)));
    }

    @Test
    public void testHultajchochlaShouldRandomChangeThePlaceOfTwoDigits() throws NieudanyPsikusException {
        GotowyPsikus gotowyPsikus = new GotowyPsikus();

        assertThat(gotowyPsikus.hultajchochla(45), anyOf(equalTo(45), equalTo(54)));
        assertThat(gotowyPsikus.hultajchochla(26), anyOf(equalTo(26), equalTo(62)));
        assertThat(gotowyPsikus.hultajchochla(87), anyOf(equalTo(87), equalTo(78)));
        assertThat(gotowyPsikus.hultajchochla(784), anyOf(equalTo(784), equalTo(748),
                equalTo(874), equalTo(847), equalTo(478), equalTo(487)));
    }

    @Test
    public void testNieksztaltekShouldReturnUnchangedParameterWhenDigits376NotOccurs() {
        GotowyPsikus gotowyPsikus = new GotowyPsikus();

        assertEquals(Integer.valueOf(5), gotowyPsikus.nieksztaltek(5));
        assertEquals(Integer.valueOf(12), gotowyPsikus.nieksztaltek(12));
        assertEquals(Integer.valueOf(889), gotowyPsikus.nieksztaltek(889));
        assertEquals(Integer.valueOf(4582), gotowyPsikus.nieksztaltek(4582));
        assertEquals(Integer.valueOf(94218), gotowyPsikus.nieksztaltek(94218));
    }

    @Test
    public void testNieksztaltekShouldRandomChangeDigits376() {
        GotowyPsikus gotowyPsikus = new GotowyPsikus();

        assertThat(gotowyPsikus.nieksztaltek(3), equalTo(8));
        assertThat(gotowyPsikus.nieksztaltek(7), equalTo(1));
        assertThat(gotowyPsikus.nieksztaltek(6), equalTo(9));

        assertThat(gotowyPsikus.nieksztaltek(32), equalTo(82));
        assertThat(gotowyPsikus.nieksztaltek(37), anyOf(equalTo(87), equalTo(31)));

        assertThat(gotowyPsikus.nieksztaltek(654), equalTo(954));
        assertThat(gotowyPsikus.nieksztaltek(376), anyOf(equalTo(876), equalTo(316), equalTo(379)));
    }
}
