package integer_to_roman;

import java.util.HashSet;
import java.util.LinkedHashMap;

class Solution {
    static final LinkedHashMap<String, Integer> table = new LinkedHashMap<>();
    static final LinkedHashMap<String, Integer> sub = new LinkedHashMap<>();
    static final HashSet<String> tens = new HashSet<>();

    static {
        table.putLast("M", 1000);
        table.putLast("D", 500);
        table.putLast("C", 100);
        table.putLast("L", 50);
        table.putLast("X", 10);
        table.putLast("V", 5);
        table.putLast("I", 1);

        sub.putLast("CM", 900);
        sub.putLast("CD", 400);
        sub.putLast("XC", 90);
        sub.putLast("XL", 40);
        sub.putLast("IX", 9);
        sub.putLast("IV", 4);

        tens.add("M");
        tens.add("C");
        tens.add("X");
        tens.add("I");
    }

    public static String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        int rem = num;
        while (rem > 0) {
            String remString = String.valueOf(rem);
            char first = remString.charAt(0);
            if (first == '4' || first == '9') {
                for (var e : sub.entrySet()) {
                    if (rem - e.getValue() >= 0) {
                        result.append(e.getKey());
                        rem -= e.getValue();
                        break;
                    }
                }
            } else {
                for (var e : table.entrySet()) {
                    if (rem - e.getValue() >= 0) {
                        result.append(e.getKey());
                        rem -= e.getValue();
                        int t = 1;
                        while (tens.contains(e.getKey()) && rem - e.getValue() >= 0 && t < 3) {
                            result.append(e.getKey());
                            rem -= e.getValue();
                            t++;
                        }
                        break;
                    }
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        intToRoman(3749);
        intToRoman(58);
        intToRoman(1994);
    }
}