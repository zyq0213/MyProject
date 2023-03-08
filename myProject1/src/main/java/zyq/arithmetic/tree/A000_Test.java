package zyq.arithmetic.tree;

import zyq.arithmetic.TreeNode;

/**
 * @author yanqing.zou
 * @date 2023-03-08 15:10
 * Description
 */
public class A000_Test {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = root.right;
        root.right = left;
    }
}
