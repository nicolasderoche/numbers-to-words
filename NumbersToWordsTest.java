//
// Test class for NUmbersToWords class 
//
// $ . ./sourceMe
// $ javac NumbersToWordsTest.java 
// $ java org.junit.runner.JUnitCore NumbersToWordsTest
//

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NumbersToWordsTest {
    NumbersToWords n2w;

    @Before
    public void setUp() throws Exception {
        n2w = new NumbersToWords();
    }

    @Test
    public void test0to10() {
        Assert.assertEquals("zero", n2w.convert(0));
        Assert.assertEquals("one", n2w.convert(1));
        Assert.assertEquals("two", n2w.convert(2));
        Assert.assertEquals("three", n2w.convert(3));
        Assert.assertEquals("four", n2w.convert(4));
        Assert.assertEquals("five", n2w.convert(5));
        Assert.assertEquals("six", n2w.convert(6));
        Assert.assertEquals("seven", n2w.convert(7));
        Assert.assertEquals("eight", n2w.convert(8));
        Assert.assertEquals("nine", n2w.convert(9));
        Assert.assertEquals("ten", n2w.convert(10));
    }

    @Test
    public void test11to20() {
        Assert.assertEquals("eleven", n2w.convert(11));
        Assert.assertEquals("twelve", n2w.convert(12));
        Assert.assertEquals("thirteen", n2w.convert(13));
        Assert.assertEquals("fourteen", n2w.convert(14));
        Assert.assertEquals("fifteen", n2w.convert(15));
        Assert.assertEquals("sixteen", n2w.convert(16));
        Assert.assertEquals("seventeen", n2w.convert(17));
        Assert.assertEquals("eighteen", n2w.convert(18));
        Assert.assertEquals("nineteen", n2w.convert(19));
        Assert.assertEquals("twenty", n2w.convert(20));
    }

    @Test
    public void test20to100() {
        Assert.assertEquals("forty six", n2w.convert(46));
        Assert.assertEquals("twenty two", n2w.convert(22));
        Assert.assertEquals("fifty", n2w.convert(50));
        Assert.assertEquals("seventy three", n2w.convert(73));
        Assert.assertEquals("ninety nine", n2w.convert(99));
        Assert.assertEquals("one hundred", n2w.convert(100));
    }

    @Test
    public void test101to1000() {
        Assert.assertEquals("one hundred one", n2w.convert(101));
        Assert.assertEquals("two hundred thirty four", n2w.convert(234));
        Assert.assertEquals("nine hundred", n2w.convert(900));
        Assert.assertEquals("nine hundred eighty seven", n2w.convert(987));
        Assert.assertEquals("one thousand", n2w.convert(1000));
    }

    @Test
    public void testAbove1000() {
        Assert.assertEquals("two thousand", n2w.convert(2000));
        Assert.assertNotEquals("two thousands", n2w.convert(2000));
        Assert.assertEquals("twelve thousand", n2w.convert(12000));
        Assert.assertEquals("twelve thousand four", n2w.convert(12004));
        Assert.assertEquals("twenty thousand", n2w.convert(20000));
        Assert.assertEquals("twenty four thousand", n2w.convert(24000));
        Assert.assertEquals("twenty four thousand one hundred", n2w.convert(24100));
        Assert.assertEquals("twenty four thousand nine hundred sixty five", n2w.convert(24965));
        Assert.assertEquals("fifty nine thousand three hundred twenty one", n2w.convert(59321));
        Assert.assertEquals("ninety nine thousand nine hundred ninety nine", n2w.convert(99999));
    }

    @Test
    public void testAbove100000() {
        Assert.assertEquals("one hundred thousand", n2w.convert(100000));
        Assert.assertEquals("one hundred thousand one hundred", n2w.convert(100100));
        Assert.assertEquals("one hundred fifty three thousand two hundred", n2w.convert(153200));
        Assert.assertEquals("two hundred thousand five hundred", n2w.convert(200500));
        Assert.assertEquals("nine hundred thousand eight hundred forty three", n2w.convert(900843));
        Assert.assertEquals("nine hundred thousand eight hundred forty three", n2w.convert(900843));
    }

    @Test
    public void testAbove1000000() {
        Assert.assertEquals("one million three hundred forty five thousand six hundred twelve", n2w.convert(1345612));
        Assert.assertEquals("twelve million three hundred forty five thousand six hundred twelve",
                n2w.convert(12345612));
        Assert.assertEquals("nineteen million", n2w.convert(19000000));
        Assert.assertEquals("nineteen million three thousand", n2w.convert(19003000));
        Assert.assertEquals("nineteen million thirty thousand", n2w.convert(19030000));
        Assert.assertEquals("nineteen million three hundred thousand", n2w.convert(19300000));
        Assert.assertEquals("twenty four million", n2w.convert(24000000, false));
        Assert.assertEquals("eighty seven million six hundred fifty four thousand three hundred twenty one",
                n2w.convert(87654321));
        Assert.assertEquals(
                "nine hundred eighty seven million six hundred fifty four thousand three hundred twenty one",
                n2w.convert(987654321));
        Assert.assertEquals("one hundred million", n2w.convert(100000000));

    }

    @Test
    public void testNegativeNumbers() {
        Assert.assertEquals("minus six", n2w.convert(-6));
        Assert.assertEquals("minus one hundred", n2w.convert(-100));
        Assert.assertEquals("minus one thousand", n2w.convert(-1000));
        Assert.assertEquals("minus ten thousand", n2w.convert(-10000));
        Assert.assertEquals("minus one hundred thousand", n2w.convert(-100000));
        Assert.assertEquals("minus one million two hundred thirty four thousand five hundred sixty seven",
                n2w.convert(-1234567));
    }

    @Test
    public void testTooLargeNumbers() {
        Assert.assertEquals("Number is too large!", n2w.convert(1000000001));
    }
}