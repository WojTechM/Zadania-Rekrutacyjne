package com.github.wojtechm.zadania_rekrutacyjne.arrays_and_lists;

import com.github.wojtechm.zadania_rekrutacyjne.tools.Difficulty;
import com.github.wojtechm.zadania_rekrutacyjne.tools.Level;

import java.util.*;
import java.util.stream.Stream;

/**
 * Given a list of some elements
 * write a method that will find unique element.
 * For edge case handing see provided tests.
 *
 * [1, 1, 2, 1, 1]  => 2
 * ['a', 'b', 'b']  => 'a'
 *
 * There always will be just one unique element
 *
 * @author Wojciech Makieła
 */
@Difficulty(Level.MEDIUM)
class FindTheUnique {

    private FindTheUnique(){}

    static <T extends Comparable<T>> T findUnique(List<T> list) {
        if (list == null) throw new IllegalArgumentException();
        if (list.size() == 2) throw new IllegalArgumentException();
        for (T one : list) {
            if (list.stream().filter(e -> Objects.equals(e, one)).count() == 1) {
                return one;
            }
        }
        return null;
    }
}
