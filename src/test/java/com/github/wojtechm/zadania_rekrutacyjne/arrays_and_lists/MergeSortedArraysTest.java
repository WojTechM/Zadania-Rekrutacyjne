package com.github.wojtechm.zadania_rekrutacyjne.arrays_and_lists;

import io.github.sskorol.core.DataSupplier;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.testng.Assert.assertEquals;

public class MergeSortedArraysTest {

    @Test
    private void should_returnEmptyArray_when_passedTwoNulls() {
        // arrange
        int[] expected = new int[0];
        // act
        int[] actual = MergeSortedArrays.merge(null, null);
        // assert
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "getSingleSortedIntArray")
    private void should_returnFirstArray_when_secondIsNull(int[] first) {
        // act
        int[] actual = MergeSortedArrays.merge(first, null);
        // assert
        assertEquals(actual, first);
    }

    @Test(dataProvider = "getSingleSortedIntArray")
    private void should_returnSecondArray_when_firstIsNull(int[] second) {
        // act
        int[] actual = MergeSortedArrays.merge(null, second);
        // assert
        assertEquals(actual, second);
    }

    @Test(dataProvider = "standardUseCases")
    private void should_mergeArrays_when_noNullValuesPassed(int[] first, int[] second, int[] expected) {
        // act
        int[] actual = MergeSortedArrays.merge(first, second);
        // assert
        assertEquals(actual, expected);
    }

    @DataSupplier
    public Stream<int[]> getSingleSortedIntArray() {
        return IntStream.rangeClosed(0, 20).mapToObj(n -> new int[]{n * 2, n * 3, n * 4, n * 5, n * 6, n * 7});
    }

    @DataProvider
    private Object[][] standardUseCases() {
        return new Object[][]{
                {new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{1, 2, 3, 4, 5, 6}},
                {new int[]{1, 3, 5}, new int[]{2, 4, 6}, new int[]{1, 2, 3, 4, 5, 6}},
                {new int[]{1}, new int[]{2, 4, 6}, new int[]{1, 2, 4, 6}},
                {new int[]{10, 11, 12}, new int[]{1, 2, 6}, new int[]{1, 2, 6, 10, 11, 12}},
                {new int[]{1, 4, 8}, new int[]{1, 4, 8}, new int[]{1, 1, 4, 4, 8, 8}}
        };
    }
}