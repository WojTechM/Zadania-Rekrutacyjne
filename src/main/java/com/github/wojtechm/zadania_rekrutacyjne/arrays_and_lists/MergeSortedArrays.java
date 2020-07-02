package com.github.wojtechm.zadania_rekrutacyjne.arrays_and_lists;

import com.github.wojtechm.zadania_rekrutacyjne.tools.Difficulty;
import com.github.wojtechm.zadania_rekrutacyjne.tools.Level;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Write a method to return a sorted array of integers created by merging 2 sorted arrays.
 *
 * [1], [2]             => [1,2]
 * [9,10,11], [5, 9]    => [5,9,9,10,11]
 * [1,3,5], [2,4,6]     => [1,2,3,4,5,6]
 * null, [1,2,3]        => [1,2,3]
 * [3,4,5], null        => [3,4,5]
 * null, null           => []
 *
 * @author Wojciech Makieła
 */
@Difficulty(Level.EASY)
class MergeSortedArrays {

    private MergeSortedArrays(){}

    public static void main(String[] args) {
        var test1 = new int[]{1, 3, 5};
        var test2 = new int[]{2, 4, 6};
        for (var one : merge(test1, test2)) {
            System.out.println(one);
        }
    }

    static int[] merge(int[] first, int[] second)
    {
        if (first == null || second == null) {
            if(first == null) return (second != null) ? second: new int[]{};
            return first;
        }
        return Stream.of(Arrays.stream(first), Arrays.stream(second))
                .flatMap(IntStream::boxed)
                .collect(Collectors.toList())
                .stream().mapToInt( e -> e)
                .sorted()
                .toArray();
    }
}
