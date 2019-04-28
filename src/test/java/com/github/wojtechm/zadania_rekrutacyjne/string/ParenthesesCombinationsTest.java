package com.github.wojtechm.zadania_rekrutacyjne.string;

import io.github.sskorol.core.DataSupplier;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ParenthesesCombinationsTest {

    @Test(dataProvider = "nonPositiveNumbers")
    private void should_returnEmptyList_when_passedNonPositiveNumber(int n) {
        // act
        List<String> strings = ParenthesesCombinations.parenthesesCombinations(n);
        // assert
        assertTrue(strings.isEmpty());
    }

    @DataSupplier
    public Stream<Integer> nonPositiveNumbers() {
        return IntStream.rangeClosed(-10, 0).boxed();
    }

    @Test
    private void should_returnSingleParentheses_when_passedOne() {
        // arrange
        List<String> expected = new ArrayList<>(Collections.singletonList("()"));
        // act
        List<String> actual = ParenthesesCombinations.parenthesesCombinations(1);
        // assert
        assertEquals(expected.get(0), actual.get(0));
    }

    @Test
    private void should_returnPossibilitiesFor2() {
        // arrange
        List<String> expected = new ArrayList<>(Arrays.asList("()()", "(())"));
        // act
        List<String> actual = ParenthesesCombinations.parenthesesCombinations(2);
        // assert
        Collections.sort(expected);
        Collections.sort(actual);
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }

    @Test
    private void should_returnPossibilitiesFor3() {
        // arrange
        List<String> expected = new ArrayList<>(Arrays.asList("()()()", "()(())", "(())()", "((()))", "(()())"));
        // act
        List<String> actual = ParenthesesCombinations.parenthesesCombinations(3);
        // assert
        Collections.sort(expected);
        Collections.sort(actual);
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }

    @Test
    private void should_returnPossibilitiesFor4() {
        // arrange
        List<String> expected = new ArrayList<>(Arrays.asList("(((())))", "((()()))", "((())())", "((()))()", "(()(()))", "(()()())", "(()())()", "(())(())", "(())()()", "()((()))", "()(()())", "()(())()", "()()(())", "()()()()"));
        // act
        List<String> actual = ParenthesesCombinations.parenthesesCombinations(4);
        // assert
        Collections.sort(expected);
        Collections.sort(actual);
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }

    @Test
    private void should_returnPossibilitiesFor5() {
        // arrange
        List<String> expected = new ArrayList<>(Arrays.asList("((((()))))", "(((()())))", "(((())()))", "(((()))())", "(((())))()", "((()(())))", "((()()()))", "((()())())", "((()()))()", "((())(()))", "((())()())", "((())())()", "((()))(())", "((()))()()", "(()((())))", "(()(()()))", "(()(())())", "(()(()))()", "(()()(()))", "(()()()())", "(()()())()", "(()())(())", "(()())()()", "(())((()))", "(())(()())", "(())(())()", "(())()(())", "(())()()()", "()(((())))", "()((()()))", "()((())())", "()((()))()", "()(()(()))", "()(()()())", "()(()())()", "()(())(())", "()(())()()", "()()((()))", "()()(()())", "()()(())()", "()()()(())", "()()()()()"));
        // act
        List<String> actual = ParenthesesCombinations.parenthesesCombinations(5);
        // assert
        Collections.sort(expected);
        Collections.sort(actual);
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }
}