package letter_combinations_of_a_phone_number;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    private static final Map<Character, String> numLetters = new HashMap<>();

    static {
        numLetters.put('2', "abc");
        numLetters.put('3', "def");
        numLetters.put('4', "ghi");
        numLetters.put('5', "jkl");
        numLetters.put('6', "mno");
        numLetters.put('7', "pqrs");
        numLetters.put('8', "tuv");
        numLetters.put('9', "wxyz");
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            char num = digits.charAt(i);
            String letters = numLetters.getOrDefault(num, "");
            List<String> newResult = new ArrayList<>();
            for (int j = 0; j < letters.length(); j++) {
                char letter = letters.charAt(j);
                if (result.isEmpty()) newResult.add(String.valueOf(letter));
                for (String r : result) {
                    newResult.add(r + letter);
                }
            }
            if (!newResult.isEmpty()) {
                result = newResult;
            }
        }
        System.out.println(result);
        System.out.println(result.size());
        return result;
    }

    public static void main(String[] args) {
        letterCombinations("23");
        letterCombinations("");
        letterCombinations("239");
        letterCombinations("231");
        letterCombinations("10001231");
        letterCombinations("lakjsdhfkajdsh2akdjfhalkjdfh3");
        letterCombinations("8lakjsdhfkajdsh2akdjfhalkjdfh3");
        letterCombinations("9999");
    }
}