package string_to_integer;

import java.math.BigInteger;
import java.util.Set;

class Solution {

    static final Set<Character> digits = Set.of('1', '2', '3', '4', '5', '6', '7', '8', '9', '0');

    public static int myAtoi(String s) {
        String num = s.trim();

        boolean negative = false;
        int start = 0;
        if (num.isEmpty()) {
            return 0;
        } else if (num.charAt(start) == '+') {
            start++;
        } else if (num.charAt(start) == '-') {
            negative = true;
            start++;
        }

        while (start + 1 < num.length() &&
            num.charAt(start) == '0' &&
            digits.contains(num.charAt(start + 1))
        ) {
            start++;
        }

        int end = start;
        for (int i = start; i < num.length(); i++) {
            if (!digits.contains(num.charAt(i))) {
                break;
            }
            end = i;
        }

        if (start < num.length() && digits.contains(num.charAt(start))) {
            var bg = new BigInteger(num.substring(start, end + 1))
                .multiply(BigInteger.valueOf((negative ? -1 : 1)));
            return bg.max(BigInteger.valueOf(Integer.MIN_VALUE))
                .min(BigInteger.valueOf(Integer.MAX_VALUE))
                .intValue();
        } else return 0;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("  -042"));
        System.out.println(myAtoi("1337c0d3"));
        System.out.println(myAtoi("0-1"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi(""));
        System.out.println(myAtoi("-"));
        System.out.println(myAtoi("+1"));
        System.out.println(myAtoi("       +1"));
        System.out.println(myAtoi("       +"));
        System.out.println(myAtoi("+-12"));
        System.out.println(myAtoi("       -12"));
        System.out.println(myAtoi("20000000000000000000"));
        System.out.println(myAtoi("2147483648"));
        System.out.println(myAtoi("-2147483649"));
        System.out.println(myAtoi("9223372036854775808"));


    }
}
