package longest_common_prefix;

class Solution {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        StringBuilder result = new StringBuilder();
        boolean common = true;
        int j = 0;
        while (common) {
            for (int i = 0; i < strs.length - 1; i++) {
                String first = strs[i];
                String second = strs[i + 1];
                if (j < first.length() && j < second.length()) {
                    if (first.charAt(j) != second.charAt(j)) {
                        common = false;
                        break;
                    }
                } else {
                    common = false;
                    break;
                }
            }
            if (common && j < strs[0].length()) result.append(strs[0].charAt(j));
            j++;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        longestCommonPrefix(new String[] {"flower","flow","flight"});
        longestCommonPrefix(new String[] {""});

    }
}