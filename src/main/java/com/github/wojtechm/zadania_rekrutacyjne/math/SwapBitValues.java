package com.github.wojtechm.zadania_rekrutacyjne.math;

import com.github.wojtechm.zadania_rekrutacyjne.tools.Difficulty;
import com.github.wojtechm.zadania_rekrutacyjne.tools.Level;

/**
 * Given a positive integer 'n'
 * write a method that converts n to binary and replaces all 0s with 1s and 1s with 0s
 *
 * 5 as binary => 101
 * 101 swapped => 010
 * 010 to decimal => 2
 * thus swap(5) => 2
 *
 * other examples
 *
 * swap(0)  => 1    // '0'      => '1'
 * swap(10) => 5    // '1010'   => '0101'
 * swap(8)  => 7    // '1000'   => '0111'
 * swap(7)  => 0    // '111'    => '000'
 *
 * @author Wojciech Makieła
 */
@Difficulty(Level.MEDIUM)
class SwapBitValues {

    static int swap(int n) {
        return 0;
    }
}
