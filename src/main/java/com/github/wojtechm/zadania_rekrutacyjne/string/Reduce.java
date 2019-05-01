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

    static String reduce(String toReduce) {
        return toReduce;
    }
}
