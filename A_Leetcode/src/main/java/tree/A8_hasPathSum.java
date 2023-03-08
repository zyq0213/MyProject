package tree;

import A_entity.TreeNode;

import java.util.*;

/**
 * @author yanqing.zou
 * @date 2023-01-10 15:06
 * Description
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *                    5
 *                4      8
 *             11     13   4
 *           7   2           1
 *
 *           target = 22;
 *           result = true;
 */
public class A8_hasPathSum {
    /**
     * 广度优先搜索 ，堆栈
     * @param root
     * @param targetSum
     * @return
     */
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        Deque<Integer> valueDeque = new LinkedList<>();
        valueDeque.addLast(root.val);
        while (!deque.isEmpty()){
            TreeNode node = deque.removeFirst();
            Integer value = valueDeque.removeFirst();
            if(node.left == null && node.right == null && value == targetSum){
                return true;
            }
            if(node.left != null){
                deque.add(node.left);
                valueDeque.add(node.left.val + value);
            }
            if(node.right != null) {
                deque.offer(node.right);
                valueDeque.add(node.right.val + value);
            }
        }
        return false;
    }

    /**
     * 递归
     * @param root
     * @param targetSum
     * @return
     */
    public static boolean hasPathSum1(TreeNode root, int targetSum) {
        if(root == null) {
            return false;
        }
        if(root.left == null && root.right == null && root.val == targetSum){
            return true;
        }
        return hasPathSum1(root.left,targetSum-root.val) || hasPathSum1(root.right, targetSum-root.val);
    }

    public static boolean hasPathSum2(TreeNode root, int targetSum){
        return true;
    }


        public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(8);
        treeNode.left.left = new TreeNode(11);
        treeNode.left.left.left = new TreeNode(7);
        treeNode.left.left.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(13);
        treeNode.right.right = new TreeNode(4);
        treeNode.right.right.right = new TreeNode(1);
        boolean b = hasPathSum1(treeNode, 23);
        System.out.println(b);

    }

}
