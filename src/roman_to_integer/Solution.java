package roman_to_integer;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    static final Map<String, Integer> table = new HashMap<String, Integer>();

    static {
        table.put("I", 1);
        table.put("IV", 4);
        table.put("V", 5);
        table.put("IX", 9);
        table.put("X", 10);
        table.put("XL", 40);
        table.put("L", 50);
        table.put("XC", 90);
        table.put("C", 100);
        table.put("CD", 400);
        table.put("D", 500);
        table.put("CM", 900);
        table.put("M", 1000);
    }

    public static int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            var symbol = String.valueOf(s.charAt(i));
            var value = table.get(symbol);
            if (i < s.length() - 1) {
                var doubleSymbol = symbol + s.charAt(i + 1);
                var doubleValue = table.get(doubleSymbol);
                if (doubleValue != null) {
                    value = doubleValue;
                    i++;
                }
            }
            result += value;
        }
        //System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        romanToInt("III");
        romanToInt("LVIII");
        romanToInt("MCMXCIV");
    }
}
