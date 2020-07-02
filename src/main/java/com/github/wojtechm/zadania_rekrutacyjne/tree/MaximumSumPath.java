package com.github.wojtechm.zadania_rekrutacyjne.tree;

import com.github.wojtechm.zadania_rekrutacyjne.tools.Difficulty;
import com.github.wojtechm.zadania_rekrutacyjne.tools.Level;

/**
 * Given a binary tree consisting of nodes with positive integer values,
 * write a method - maxSumPath that returns the maximum sum of values obtained by traversing nodes along
 * a path between root node, and any leaf node of the tree.
 *
 *      1
 *     / \
 *    2   3         => 11 = 1 + 3 + 7
 *   / \ / \
 *  4  5 6  7
 *
 *
 *       10
 *     /   \
 *    1     30      => 61 = 10 + 1 + 50
 *   / \   / \
 *  1  50 1  1
 *
 * @author Wojciech Makieła
 */
@Difficulty(Level.EASY)
class MaximumSumPath {

    private MaximumSumPath() {}

    static int maxSumPath(TreeNode root) {
        if (root != null) {
            return root.value + (Math.max(maxSumPath(root.left), maxSumPath(root.right)));
        }
        return 0;
    }
}
