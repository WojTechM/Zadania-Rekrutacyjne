package com.github.wojtechm.zadania_rekrutacyjne.arrays_and_lists;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

public class FindTheUniqueTest {

    @Test(expectedExceptions = IllegalArgumentException.class)
    private void should_throwException_when_passedNull() {
        // act
        FindTheUnique.findUnique(null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    private void should_throwException_when_passedTooSmallList() {
        // act
        FindTheUnique.findUnique(Arrays.asList(1, 2));
    }

    @Test
    private void should_findUniqueElement_when_firstElementIsUnique() {
        // arrange
        List<String> strings = Arrays.asList(null, "a", "a", "a", "a");
        // act
        String unique = FindTheUnique.findUnique(strings);
        // assert
        assertNull(unique);
    }

    @Test
    private void should_findUniqueElement_when_secondElementIsUnique() {
        // arrange
        List<Integer> integers = Arrays.asList(null, 2, null, null, null);
        Integer expected = 2;
        // act
        Integer unique = FindTheUnique.findUnique(integers);
        // assert
        assertEquals(unique, expected);
    }

    @Test
    private void should_findUniqueElement_when_thirdElementIsUnique() {
        // arrange
        List<Float> numbers = Arrays.asList(0.1f, 0.1f, 7f);
        Float expected = 7f;
        // act
        Float unique = FindTheUnique.findUnique(numbers);
        // assert
        assertEquals(unique, expected);
    }

    @Test(dataProvider = "testData")
    private <T extends Comparable<T>> void should_findUniqueElement_when_fourthOrLaterElementIsUnique(List<T> list, T expected) {
        // act
        T unique = FindTheUnique.findUnique(list);
        // assert
        assertEquals(unique, expected);
    }

    @DataProvider
    public Object[][] testData() {
        Object[][] testData = new Object[10][2];
        for (int i = 0; i < testData.length; i++) {
            List<Integer> list = new ArrayList<>();
            Integer unique = i + 1;
            addRandomNumberOfElementsToList(i, list, 4, 10);
            list.add(unique);
            addRandomNumberOfElementsToList(i, list, 0, 3);
            testData[i][0] = list;
            testData[i][1] = unique;
        }
        return testData;
    }

    private void addRandomNumberOfElementsToList(int elementToAdd, List<Integer> list, int min, int max) {
        for (int j = 0; j < ThreadLocalRandom.current().nextInt(min, max); j++) {
            list.add(elementToAdd);
        }
    }
}