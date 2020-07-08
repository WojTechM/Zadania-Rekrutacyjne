package com.github.wojtechm.zadania_rekrutacyjne.string;

import com.github.wojtechm.zadania_rekrutacyjne.tools.Difficulty;
import com.github.wojtechm.zadania_rekrutacyjne.tools.Level;

/**
 * Given a String consisting of alphabetic characters only,
 * write a method - reduce that returns the given string with all equal characters
 * next to each other removed. Operation stops when no duplicates are neighboring;
 *
 * "book"   => "bk"
 * "abba"   => ""
 * "abcba"  => "abcba"
 * "aAaAaA" => "aAaAaA"
 * "ooabc"  => "abc"
 *
 * @author Wojciech Makieła
 */
@Difficulty(Level.MEDIUM)
class Reduce {

    private Reduce(){}

    static String reduce(String toReduce) {
        if(toReduce == null) throw new IllegalArgumentException("Cannot reduce null");
        var marker = '1';
        char[] toReduceArray = toReduce.toCharArray();
        for (int i = 0; i < toReduceArray.length; i++) {
            var j = 1;
            while (i >= 0 &&
                    toReduceArray[i] != marker &&
                    i + j < toReduceArray.length &&
                    toReduceArray[i] == toReduceArray[i + j]) {
                toReduceArray[i] = marker;
                toReduceArray[i-- + j] = marker;
                j += 2;
            }
        }
        return String.copyValueOf(toReduceArray).replace("1", "");
    }
}
