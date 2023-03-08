package tree;

import A_entity.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yanqing.zou
 * @date 2023-03-07 20:44
 * Description
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/invert-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A226_invertTree {
    /**
     * bfs 把每次取出来的子节点，交换位置
     *
     * @param root
     * @return
     */
    public static TreeNode invertTree(TreeNode root) {
        Deque<TreeNode> indeque = new LinkedList<>();
        indeque.push(root);
        while (!indeque.isEmpty()) {
            TreeNode node = indeque.removeLast();
            TreeNode left = node.left;
            TreeNode right = node.right;
            if(left != null){
                indeque.push(left);
            }
            if(right != null){
                indeque.push(right);
            }
            node.right = node.left;
            node.left = right;
        }
        return root;
    }

    // 先序遍历--从顶向下交换
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTree1(root.left);
        invertTree1(root.right);
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;

        return root;
    }



    public static void main(String[] args) {
        /**
         *         1
         *      2      3
         *    4   5  6   7
         * 10   8
         * 前序遍历, the result is: 1 2 4 10 8 5 3 6 7
         */
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);
        treeNode.left.left.left = new TreeNode(10);
        treeNode.left.left.right = new TreeNode(8);
        invertTree(treeNode);

    }
}
