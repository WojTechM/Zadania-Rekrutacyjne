package com.github.wojtechm.zadania_rekrutacyjne.math;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SwapBitValuesTest {

    @Test(dataProvider = "testCases")
    private void should_returnDecimalRepresentationAfterChangingBitsOfInteger(int toConvert, int expected) {
        // act
        int actual = SwapBitValues.swap(toConvert);
        // assert
        assertEquals(actual, expected);
    }

    @DataProvider
    private Object[][] testCases() {
        return new Object[][]{
                {0, 1},
                {5, 2},
                {62, 1},
                {93, 34},
                {124, 3},
                {155, 100},
                {186, 69},
                {217, 38},
                {248, 7},
                {279, 232},
                {310, 201},
                {341, 170},
                {372, 139},
                {403, 108},
                {434, 77},
                {465, 46},
                {496, 15},
                {527, 496},
                {558, 465},
                {589, 434},
                {620, 403},
                {651, 372},
                {682, 341},
                {713, 310},
                {744, 279},
                {775, 248},
                {806, 217},
                {837, 186},
                {868, 155},
                {899, 124},
                {930, 93},
                {961, 62},
                {992, 31},
                {1023, 0},
                {1054, 993},
                {1085, 962},
                {1116, 931},
                {1147, 900},
                {1178, 869},
                {1209, 838},
                {1240, 807},
                {1271, 776},
                {1302, 745},
                {1333, 714},
                {1364, 683},
                {1395, 652},
                {1426, 621},
                {1457, 590},
                {1488, 559},
                {1519, 528}
        };
    }
}