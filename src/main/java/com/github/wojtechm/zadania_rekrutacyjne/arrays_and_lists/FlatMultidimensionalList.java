package com.github.wojtechm.zadania_rekrutacyjne.arrays_and_lists;

import com.github.wojtechm.zadania_rekrutacyjne.tools.Difficulty;
import com.github.wojtechm.zadania_rekrutacyjne.tools.Level;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a list of list of strings
 * write a method that will take all elements of inner lists, and put them into single list
 *
 * [ ["1", "2"], ["3"], [], ["4", "5", "6"] ]       => ["1", "2", "3", "4", "5", "6"]
 *
 * @author Wojciech Makieła
 */
@Difficulty(Level.EASY)
class FlatMultidimensionalList {

    private FlatMultidimensionalList(){}

    static List<String> flat(List<List<String>> list){
        if (list == null) {
            throw new IllegalArgumentException();
        }
        return list.stream().flatMap(Collection::stream).collect(Collectors.toList());
    }
}
