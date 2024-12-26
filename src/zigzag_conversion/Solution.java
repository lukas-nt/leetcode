package zigzag_conversion;

import java.util.ArrayList;

class Solution {
    public static String convert(String s, int numRows) {
        var rows = new ArrayList<String>(numRows);
        int i = 0;
        while (i < s.length()) {
            for (int row = 0; row < numRows && i < s.length(); row++) {
                String rowResult = null;
                if (row < rows.size()) {
                    rowResult = rows.get(row);
                }
                var letter = s.charAt(i);
                if (rowResult != null) {
                    rowResult += letter;
                    rows.set(row, rowResult);
                } else {
                    rows.add(String.valueOf(letter));
                }
                i++;
            }
            for (int row = numRows - 2; row > 0 && i < s.length(); row--) {
                String rowResult = rowResult = rows.get(row);
                var letter = s.charAt(i);
                rowResult += letter;
                rows.set(row, rowResult);
                i++;
            }
        }
        var result = "";
        for (int row = 0; row < rows.size(); row++) {
            result += rows.get(row);
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        convert("PAYPALISHIRING", 3);
        convert("PAYPALISHIRING", 4);
        convert("A", 1);
    }
}