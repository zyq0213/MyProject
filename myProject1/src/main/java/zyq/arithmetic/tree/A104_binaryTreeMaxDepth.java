package zyq.arithmetic.tree;

import zyq.arithmetic.TreeNode;

import java.util.*;

/**
 * @author yanqing.zou
 * @date 2023-03-06 19:38
 * Description
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,15,7,null,null]，
 *
 *      3
 *     / \
 *    9  20
 *  /  \
 * 15   7
 * 返回它的最大深度 3 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A104_binaryTreeMaxDepth {
    public static int maxDepth(TreeNode root) {
        //新增一个map，key存二叉树，value存度。
        int maxDepth = 0;
        List<TreeNode> list = new ArrayList<>();
        Map<TreeNode, Integer> treeMap = new TreeMap<>();

        Deque<TreeNode> deque = new LinkedList<>();
        while(root != null || !deque.isEmpty()){
            while (root != null ){
                //判断treeMap里面有没有,没有的话是第一个
                int value = 1;
                if(treeMap.containsKey(root)){
                     value = treeMap.get(root);
                }else{
                    treeMap.put(root,1);
                }
                if(root.left != null){
                    maxDepth = Math.max(maxDepth, value + 1);
                    treeMap.put(root.left,value+1);
                }
                if(root.right != null){
                    maxDepth = Math.max(maxDepth, value + 1);
                    treeMap.put(root.right,value+1);
                }
                list.add(root);
                deque.addFirst(root);
                root = root.left;
            }
            root = deque.removeFirst();
            root = root.right;
        }
        //输出list
        StringBuilder sb= new StringBuilder();
        for (TreeNode node : list) {
            sb.append(node.val).append("->");
        }
        System.out.println(sb.substring(0,sb.length()-2));
        //输出map
        Comparator<Map.Entry<TreeNode, Integer>> comparator = Comparator.comparingInt(Map.Entry::getValue);
        List<Map.Entry<TreeNode, Integer>> entries = new ArrayList<>(treeMap.entrySet());
        entries.sort(comparator);
        for (Map.Entry<TreeNode, Integer> entry : entries) {
            System.out.println("node:"+entry.getKey().val+"   depth:"+entry.getValue());
        }
        return maxDepth;
    }

    /**
     * 递归
     * @param root
     * @return
     */
    public static int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth1(root.left);
        int right = maxDepth1(root.right);
        return Math.max(left, right) + 1;

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
        int i = maxDepth1(treeNode);
        System.out.println(i);
    }

}
