//
// NumbersToWords class
// Convert a number to its written form 
// 
// Rules read from : https://oxfordlanguageclub.com/page/blog/saying-large-numbers-in-english
// Note: omission of "and" and "," that are sometimes used.
//
//   $ javac NumbersToWords.java 
//   $ java NumbersToWords 1234
//   1234 ---> one thousand two hundred thirty-four
//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumbersToWords {

    /** Describe numbers from 0 to 19 */
    private final List<String> units = Arrays.asList("zero", "one", "two", "three", "four", "five", "six", "seven",
            "eight",
            "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
            "nineteen");
    /** Describe the numbers from 0 to 90 in tens. */
    private final List<String> tens = Arrays.asList("zero", "ten", "twenty", "thirty", "forty", "fifty", "sixty",
            "seventy",
            "eighty", "ninety");

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("An argument is missing!");
            System.exit(0);
        }
        int value = Integer.parseInt(args[0]);
        String buf = (new NumbersToWords()).convert(value);
        System.out.println(value + " ---> " + buf);
    }

    public String convert(int value) {
        return convert(value, false);
    }

    /**
     * Convert an integer into words
     * 
     * @param value
     * @param debug
     * @return the English sentence that represents the value
     */
    public String convert(int value, boolean debug) {
        if (value == 0) {
            return units.get(0);
        }
        if (value >= Integer.MAX_VALUE) {
            // we could manage MAX_VALUE, but this is to handle an "out of range value" case
            return "Number is too large!";
        }

        List<String> result = new ArrayList<>();
        if (value < 0) {
            result.add("minus");
        }
        int v = Math.abs(value);

        // the max (Integer.MAX_VALUE) is 2147483646 and its length is 10 digits.
        // It is not necessary to get digits beyond the 10th as they do not exist.
        int digit10 = (v % (int) Math.pow(10, 10)) / (int) Math.pow(10, 9); // <-- (v % 10000000000) / 1000000000
        int digit9 = (v % (int) Math.pow(10, 9)) / (int) Math.pow(10, 8);
        int digit8 = (v % (int) Math.pow(10, 8)) / (int) Math.pow(10, 7);
        int digit7 = (v % (int) Math.pow(10, 7)) / (int) Math.pow(10, 6);
        int digit6 = (v % (int) Math.pow(10, 6)) / (int) Math.pow(10, 5);
        int digit5 = (v % (int) Math.pow(10, 5)) / (int) Math.pow(10, 4);
        int digit4 = (v % (int) Math.pow(10, 4)) / (int) Math.pow(10, 3);
        int digit3 = (v % (int) Math.pow(10, 3)) / (int) Math.pow(10, 2); // <-- (v % 1000) / 100
        int digit2 = (v % (int) Math.pow(10, 2)) / (int) Math.pow(10, 1); // <-- (v % 100) / 10
        int digit1 = (v % (int) Math.pow(10, 1)) / (int) Math.pow(10, 0); // <-- (v % 10)

        result.add(tdn(0, 0, digit10, "billion"));
        result.add(tdn(digit9, digit8, digit7, "million"));
        result.add(tdn(digit6, digit5, digit4, "thousand"));
        result.add(tdn(digit3, digit2, digit1, null));

        // remove empty elements
        result.removeAll(Arrays.asList("", null));
        return String.join(" ", result);
    }

    /**
     * tdn for Three Digit Number made of c x 100 + d x 10 + u
     * 
     * @param h       hundreds
     * @param t       tens
     * @param u       units
     * @param postfix the postfix to add when number is not null
     * @return
     */
    private String tdn(int h, int t, int u, String postfix) {
        List<String> result = new ArrayList<>();

        // in English, numbers up to nineteen are specific, beyond that they are
        // compound
        if (t < 2) {
            u += t * 10;
            t = 0;
        }

        if (h > 0) {
            // add hundreds
            result.add(units.get(h));
            result.add("hundred");
        }

        if (t > 0 && u > 0) {
            // join tens and unit with a dash
            result.add(tens.get(t) + "-" + units.get(u));
        } else if (t > 0) {
            // just add the tens. unit is null
            result.add(tens.get(t));
        } else if (u > 0) {
            // just add the unit. tens is null
            result.add(units.get(u));
        }
        if (postfix != null && (h + t + u) > 0) {
            // add the postfix if number is not null
            result.add(postfix);
        }
        return String.join(" ", result);
    }
}
