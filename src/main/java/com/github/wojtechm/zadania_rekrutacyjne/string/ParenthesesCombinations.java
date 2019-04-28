package com.github.wojtechm.zadania_rekrutacyjne.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a method to return all valid combinations of n-pairs of parentheses.
 * The order of the strings in the List does not matter.
 *
 * 1    => "()"
 * 2    => "()()", "(())"
 * 3    => "()()()", "()(())", "(())()", "((()))", "(()())"
 *
 * @author Wojciech Makieła
 */
class ParenthesesCombinations {

    static List<String> parenthesesCombinations(int pairs) {
        List<String> strings = new ArrayList<>();
        if (pairs <= 0) {
            return strings;
        }
        addCombinations(pairs, pairs, "", strings);
        return strings;
    }

    private static void addCombinations(int left, int right, String combination, List<String> strings) {
        if (left == 0 && right == 0) {
            strings.add(combination);
            return;
        }
        if (left > 0) {
            addCombinations(left - 1, right, combination + "(", strings);
        }

        if (right > left) {
            addCombinations(left, right - 1, combination + ")", strings);
        }
    }
}
