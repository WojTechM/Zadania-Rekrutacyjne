package com.github.wojtechm.zadania_rekrutacyjne.tree;

/**
 * @author Wojciech Makieła
 */
class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    TreeNode(int value, int left, int right) {
        this.value = value;
        this.left = new TreeNode(left, null, null);
        this.right = new TreeNode(right, null, null);
    }


}
