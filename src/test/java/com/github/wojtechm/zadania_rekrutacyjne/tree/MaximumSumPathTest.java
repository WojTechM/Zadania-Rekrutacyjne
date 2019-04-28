package com.github.wojtechm.zadania_rekrutacyjne.tree;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MaximumSumPathTest {

    /*
           1
          / \
         2   3     => 11 = 1 + 3 + 7
        / \ / \
       4  5 6  7

     */
    @Test
    private void test1() {
        // arrange
        TreeNode rootLeft = new TreeNode(2, 4, 5);
        TreeNode rootRight = new TreeNode(3, 6, 7);
        TreeNode root = new TreeNode(1, rootLeft, rootRight);
        int expected = 11;

        // act
        int actual = MaximumSumPath.maxSumPath(root);

        // assert
        assertEquals(actual, expected);
    }


    /*
           1
          / \
         1   3     => 7 = 1 + 1 + 5
        / \ / \
       1  5 1  1

     */
    @Test
    private void test2() {
        // arrange
        TreeNode rootLeft = new TreeNode(1, 1, 5);
        TreeNode rootRight = new TreeNode(3, 1, 1);
        TreeNode root = new TreeNode(1, rootLeft, rootRight);
        int expected = 7;

        // act
        int actual = MaximumSumPath.maxSumPath(root);

        // assert
        assertEquals(actual, expected);
    }

    /*
        null   => 0;
     */
    @Test
    private void test3() {
        // arrange
        int expected = 0;

        // act
        int actual = MaximumSumPath.maxSumPath(null);

        // assert
        assertEquals(actual, expected);
    }


    /*
           1
          / \
         9   2     => 15 = 1 + 2 + 3 + 4 + 5
              \
               3
                \
                 4
                / \
               0   5

     */
    @Test
    private void test4() {
        // arrange
        TreeNode n4 = new TreeNode(4, 0, 5);
        TreeNode n3 = new TreeNode(3, null, n4);
        TreeNode n2 = new TreeNode(2, null, n3);
        TreeNode n9 = new TreeNode(9, null, null);
        TreeNode root = new TreeNode(1, n9, n2);
        int expected = 15;

        // act
        int actual = MaximumSumPath.maxSumPath(root);

        // assert
        assertEquals(actual, expected);
    }


    /*
        1    => 1 = 1
     */
    @Test
    private void test5() {
        // arrange
        TreeNode root = new TreeNode(1, null, null);
        int expected = 1;

        // act
        int actual = MaximumSumPath.maxSumPath(root);

        // assert
        assertEquals(actual, expected);
    }

}