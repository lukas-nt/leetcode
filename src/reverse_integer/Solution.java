package reverse_integer;

class Solution {
    public static int reverse(int x) {
        String num = String.valueOf(x);
        var reversed = new StringBuilder();
        boolean negative = num.charAt(0) == '-';
        if (negative) reversed.append('-');
        for (int i = 0; i < num.length() - (negative ? 1 : 0); i++) {
            reversed.append(num.charAt(num.length() - 1 - i));
        }
        long longNum = Long.parseLong(reversed.toString());
        if (longNum > (long) Integer.MAX_VALUE || longNum < (long) Integer.MIN_VALUE) {
            return 0;
        } else {
            return (int) longNum;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-321));
        System.out.println(reverse(120));
    }
}