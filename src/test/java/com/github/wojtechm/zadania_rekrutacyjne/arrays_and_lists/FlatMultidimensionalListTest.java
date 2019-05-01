package com.github.wojtechm.zadania_rekrutacyjne.arrays_and_lists;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.testng.Assert.*;

public class FlatMultidimensionalListTest {

    @Test(expectedExceptions = IllegalArgumentException.class)
    private void should_throwIllegalArgumentException_when_passedNull() {
        // act
        FlatMultidimensionalList.flat(null);
    }

    @Test(dataProvider = "testData")
    private void should_flatMultiDimentionalList(List<List<String>> toFlat, List<String> expected) {
        // act
        List<String> actual = FlatMultidimensionalList.flat(toFlat);
        // assert
        assertEquals(actual, expected);
    }

    @DataProvider
    private Object[][] testData() {
        Object[][] testData = new Object[50][2];
        for (int i = 0; i < testData.length; i++) {
            ThreadLocalRandom random = ThreadLocalRandom.current();
            int listsToCreate = random.nextInt(3, 8);
            List<List<String>> toFlat = new ArrayList<>();
            for (int n = 0; n < listsToCreate; n++) {
                toFlat.add(new ArrayList<>());
            }
            List<String> expected = new ArrayList<>();
            for (int n = 1; n < random.nextInt(5, 20); n++) {
                int innerListIndex = random.nextInt(listsToCreate);
                toFlat.get(innerListIndex).add(String.valueOf(n));
            }
            for (List<String> inner : toFlat) {
                expected.addAll(inner);
            }
            testData[i][0] = toFlat;
            testData[i][1] = expected;
        }
        return testData;
    }
}