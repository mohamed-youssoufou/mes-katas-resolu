package ci.dojo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {

    // if the number is divisible by three, you instead say “Fizz”
    // if it is divisible by five you say “Buzz”
    // multiples of both three and five print “FizzBuzz “.

    private FizzBuzz fizzBuzz;
    @BeforeEach void setUp(){
        fizzBuzz = new FizzBuzz();
    }
    @Test void itShouldReturn1IfIpassed1(){
        assertEquals("1", fizzBuzz.generate(1,1));
    }
    @Test void itShouldReturn2IfIPassed2(){
        assertEquals("2", fizzBuzz.generate(2,2));
    }
    @Test void itShouldReturnFizzIfIPassed3(){
        assertEquals("Fizz", fizzBuzz.generate(3,3));
    }
    @Test void itShouldReturnFizzIfIPassed6(){
        assertEquals("Fizz", fizzBuzz.generate(6,6));
    }
    @Test void itShouldReturnBuzzIfPassed5(){
        assertEquals("Buzz", fizzBuzz.generate(5,5));
    }
    @Test void itShouldReturnBuzzIfPassed10(){
        assertEquals("Buzz", fizzBuzz.generate(10,10));
    }
    @Test void itShouldReturn11IfPassed11(){
        assertEquals("11", fizzBuzz.generate(11,11));
    }
    @Test void itShouldReturn12IfPassedFizz(){
        assertEquals("Fizz", fizzBuzz.generate(12,12));
    }
    @Test void itShouldReturn13IfPassed13(){
        assertEquals("13", fizzBuzz.generate(13,13));
    }
    @Test void itShouldReturn14IfPassed14(){
        assertEquals("14", fizzBuzz.generate(14,14));
    }
    @Test void itShouldReturnFizzBuzzIfPassed15(){
        assertEquals("FizzBuzz", fizzBuzz.generate(15,15));
    }
    @Test void itShouldReturnFizzBuzzIfPassed30(){
        assertEquals("FizzBuzz", fizzBuzz.generate(30,30));
    }
    @Test void itShoutReturn12IfPassed1to2(){assertEquals("12", fizzBuzz.generate(1,2));}
    @Test void itShoutReturn12FizzIfPassed1to3(){assertEquals("12Fizz", fizzBuzz.generate(1,3));}
    @Test void itShoutReturn12Fizz4IfPassed1to4(){assertEquals("12Fizz4", fizzBuzz.generate(1,4));}
    @Test void itShoutReturn12Fizz4BuzzIfPassed1to4(){assertEquals("12Fizz4Buzz", fizzBuzz.generate(1,5));}
    @Test void itShoutReturn12Fizz4BuzzFizz78FizzBuzz11Fizz1314FizzBuzzIfPassed1to4(){assertEquals("12Fizz4BuzzFizz78FizzBuzz11Fizz1314FizzBuzz", fizzBuzz.generate(1,15));}}
