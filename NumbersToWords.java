//
// NumbersToWords class
// Convert a number to its written form 
// 
// Rules read from : https://oxfordlanguageclub.com/page/blog/saying-large-numbers-in-english
// Note: omission of "and" and "," that are sometimes used.
//
// $ javac NumbersToWords.java 
// $ java NumbersToWords 1234
// 1234 ---> one thousand two hundred thirty four
//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumbersToWords {

    /** Describe numbers from 0 to 19 */
    List<String> units = Arrays.asList("zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
            "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
            "nineteen");
    /** Describe the numbers from 0 to 90 in tens. */
    List<String> tens = Arrays.asList("zero", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy",
            "eighty", "ninety");

    /**
     * Handling plurals for a list of tables containing names of multiples of one
     * hundred.
     * 
     * @param list of strings
     * @return transformed list
     */
    List<String> plural(List<String> list) {
        return IntStream.range(0, list.size())
                .mapToObj(i -> (i > 1) ? (list.get(i) + "s") : (list.get(i)))
                .collect(Collectors.toList());
    }

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

    public String convert(int rawvalue, boolean debug) {
        if (rawvalue == 0) {
            return units.get(0);
        }
        if (rawvalue > 1000000000) {
            return "Number is too large!";
        }

        List<String> result = new ArrayList<>();
        if (rawvalue < 0) {
            result.add("minus");
        }
        int value = Math.abs(rawvalue);
        int digit9 = (value % (int) Math.pow(10, 9)) / (int) Math.pow(10, 8);
        int digit8 = (value % (int) Math.pow(10, 8)) / (int) Math.pow(10, 7);
        int digit7 = (value % (int) Math.pow(10, 7)) / (int) Math.pow(10, 6);
        int digit6 = (value % (int) Math.pow(10, 6)) / (int) Math.pow(10, 5);
        int digit5 = (value % (int) Math.pow(10, 5)) / (int) Math.pow(10, 4);
        int digit4 = (value % (int) Math.pow(10, 4)) / (int) Math.pow(10, 3);
        int digit3 = (value % (int) Math.pow(10, 3)) / (int) Math.pow(10, 2); // <-- (value % 1000) / 100
        int digit2 = (value % (int) Math.pow(10, 2)) / (int) Math.pow(10, 1); // <-- (value % 100) / 10
        int digit1 = (value % (int) Math.pow(10, 1)) / (int) Math.pow(10, 0); // <-- (value % 10)

        if (digit2 < 2) {
            digit1 += digit2 * 10;
            digit2 = 0;
        }
        if (digit5 < 2) {
            digit4 += digit5 * 10;
            digit5 = 0;
        }
        if (digit8 < 2) {
            digit7 += digit8 * 10;
            digit8 = 0;
        }

        if (debug) {
            System.out.println("[" + value + "] digit9 = " + digit9);
            System.out.println("[" + value + "] digit8 = " + digit8);
            System.out.println("[" + value + "] digit7 = " + digit7);
            System.out.println("[" + value + "] digit6 = " + digit6);
            System.out.println("[" + value + "] digit5 = " + digit5);
            System.out.println("[" + value + "] digit4 = " + digit4);
            System.out.println("[" + value + "] digit3 = " + digit3);
            System.out.println("[" + value + "] digit2 = " + digit2);
            System.out.println("[" + value + "] digit1 = " + digit1);

        }

        // List<String> hundreds = plural(units.stream().map(s -> s + " hundred").collect(Collectors.toList()));
        // List<String> thousands = plural(units.stream().map(s -> s + " thousand").collect(Collectors.toList());
        // List<String> millions = plural(units.stream().map(s -> s + " million").collect(Collectors.toList()));

        // System.out.println("unite.size = " + hundreds);
        // System.out.println("unite.size = " + units.size());

        if (digit9 > 0) {
            result.add(units.get(digit9));
            result.add("hundred");
        }
        if (digit8 > 0) {
            result.add(tens.get(digit8));
        }
        if (digit7 > 0) {
            result.add(units.get(digit7));
        }
        if (digit7 > 0 || digit8 > 0 || digit9 > 0) {
            result.add("million");

        }
        if (digit6 > 0) {
            result.add(units.get(digit6));
            result.add("hundred");
        }
        if (digit5 > 0) {
            result.add(tens.get(digit5));
        }
        if (digit4 > 0) {
            result.add(units.get(digit4));
        }
        if (digit4 > 0 || digit5 > 0 || digit6 > 0) {
            result.add("thousand");

        }
        if (digit3 > 0) {
            result.add(units.get(digit3));
            result.add("hundred");
        }
        if (digit2 > 0) {
            result.add(tens.get(digit2));
        }
        if (digit1 > 0) {
            result.add(units.get(digit1));
        }
        // System.out.println(rawvalue + " ---> " + String.join(" ", result));
        return String.join(" ", result);
    }
}
