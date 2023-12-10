package ci.dojo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Toutes les années divisibles par 400 SONT des années bissextiles (ainsi par exemple, 2000 était bien une année bissextile),
Toutes les années divisibles par 100 mais pas par 400 ne sont PAS des années bissextiles (ainsi, par exemple, 1700, 1800 et 1900 n'étaient PAS des années bissextiles, et 2100 ne sera PAS non plus une année bissextile),
Toutes les années divisibles par 4 mais pas par 100 SONT des années bissextiles (ex : 2008, 2012, 2016),
Toutes les années non divisibles par 4 ne sont PAS des années bissextiles (par exemple 2017, 2018, 2019).
 */
public class LeapYearsTest {

    private LeapYears leapYears;

    @BeforeEach
    void setUp(){
        leapYears = new LeapYears();
    }
    @Test void itShouldReturnTrueIfPassed2000(){
        assertEquals(true, leapYears.isLeapYear(2000));
    }
    @Test void itShouldReturnFalseIfPassed2001(){
        assertEquals(false, leapYears.isLeapYear(2001));
    }
    @Test void itShouldReturnFalseIfPassed1700(){
        assertEquals(false, leapYears.isLeapYear(1700));
    }
    @Test void itShouldReturnFalseIfPassed1800(){
        assertEquals(false, leapYears.isLeapYear(1800));
    }
    @Test void itShouldReturnFalseIfPassed1900(){
        assertEquals(false, leapYears.isLeapYear(1900));
    }
    @Test void itShouldReturnFalseIfPassed2100(){
        assertEquals(false, leapYears.isLeapYear(2100));
    }
    @Test void itShouldReturnTrueIfPassed2008(){
        assertEquals(true, leapYears.isLeapYear(2008));
    }
    @Test void itShouldReturnTrueIfPassed2012(){
        assertEquals(true, leapYears.isLeapYear(2012));
    }
    @Test void itShouldReturnTrueIfPassed2016(){
        assertEquals(true, leapYears.isLeapYear(2016));
    }
    @Test void itShouldReturnTrueIfPassed2017(){
        assertEquals(false, leapYears.isLeapYear(2017));
    }
    @Test void itShouldReturnTrueIfPassed2018(){
        assertEquals(false, leapYears.isLeapYear(2018));
    }
    @Test void itShouldReturnTrueIfPassed2019(){
        assertEquals(false, leapYears.isLeapYear(2019));
    }
    @Test void itShouldReturnTrueIfPassed2020(){
        assertEquals(true, leapYears.isLeapYear(2020));
    }
    @Test void itShouldReturnTrueIfPassed100(){
        assertEquals(false, leapYears.isLeapYear(100));
    }
    @Test void itShouldReturnTrueIfPassed400(){
        assertEquals(true, leapYears.isLeapYear(400));
    }
}
