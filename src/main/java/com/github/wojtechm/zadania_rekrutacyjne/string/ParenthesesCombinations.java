package com.github.wojtechm.zadania_rekrutacyjne.string;

import com.github.wojtechm.zadania_rekrutacyjne.tools.Difficulty;
import com.github.wojtechm.zadania_rekrutacyjne.tools.Level;

import java.util.ArrayList;
import java.util.Collections;
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
@Difficulty(Level.HARD)
class ParenthesesCombinations {

    private ParenthesesCombinations(){}

    static List<String> parenthesesCombinations(int pairs) {
        if (pairs <= 0){
            return Collections.emptyList();
        }

        ArrayList<String> out = new ArrayList<>();
        int number = 0;
        for (int i = pairs; i > 0; i--) {
            number += 1 << i * 2 - 1;
        }

        int maxNumber = (int) Math.pow(2, pairs * 2.0) - 1;
        int mask = 0;
        for (int i = 0; i < pairs; i++) {
            mask += (int) Math.pow(2, i);
        }
        maxNumber &= mask << pairs;
        int maxBeforeNumber = (int) (maxNumber - Math.pow(2, pairs - 1));

        makeOut(pairs, out, number, maxBeforeNumber);
        out.add(convert(maxNumber));
        Collections.sort(out);
        return out;
    }

    private static void makeOut(int pairs, ArrayList<String> out, int number, int maxBeforeNumber) {
        while (number <= maxBeforeNumber) {
            if (Integer.bitCount(number) == pairs) {
                int sum = 0;
                String converted = convert(number);
                for (char item : converted.toCharArray()) {
                    sum += (item == '(')? 1: -1;
                    if (sum < 0) {
                        break;
                    }
                }
                if (sum == 0) {
                    out.add(converted);
                }
            }
            number += 2;
        }
    }

    private static String convert(int in) {
        StringBuilder out = new StringBuilder();
        StringBuilder inRev = new StringBuilder(Integer.toBinaryString(in));
        for (char item : inRev.toString().toCharArray()) {
            out.append((item == '1') ? "(" : ")");
        }
        return out.toString();
    }
}
