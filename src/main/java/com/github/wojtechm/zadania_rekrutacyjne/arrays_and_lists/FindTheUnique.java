package com.github.wojtechm.zadania_rekrutacyjne.arrays_and_lists;

import com.github.wojtechm.zadania_rekrutacyjne.tools.Difficulty;
import com.github.wojtechm.zadania_rekrutacyjne.tools.Level;

import java.util.*;
import java.util.stream.Collectors;

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

    static <T extends Comparable<T>> T findUnique(List<T> list) {  //todo O(2n)  == O(n)??
        if (list == null) throw new IllegalArgumentException();
        if (list.size() == 2) throw new IllegalArgumentException();
        var hashDictionary = new HashMap<T, Integer>();
        for (T one : list) {
            if (hashDictionary.putIfAbsent(one, 1) != null) {
                var value = hashDictionary.get(one);
                hashDictionary.put(one, ++value);
            }
        }
        var array = hashDictionary.keySet().stream().filter(e -> hashDictionary.get(e) == 1).collect(Collectors.toList());
        return (!array.isEmpty() ? array.get(0) : null);
    }
}
