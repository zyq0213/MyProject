package tree;

import A_entity.TreeNode;

import java.util.*;

/**
 * @author yanqing.zou
 * @date 2023-01-06 16:49
 * Description
 *
 * 示例 ：
 *    1
 *  2   3
 *4  5
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 */
public class A7_isSameTree {

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        while (p != null || !stack1.isEmpty() || (q != null || !stack2.isEmpty())){
            while (p != null || q != null){
                if(p == null && q != null || (q == null && p != null)){
                    return false;
                }
                if(p.val != q.val){
                    return false;
                }
                stack1.push(p);
                stack2.push(q);
                p = p.left;
                q = q.left;
            }
            p = stack1.pop();
            q = stack2.pop();
            p = p.right;
            q = q.right;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);
        treeNode.left.left.right = new TreeNode(8);
        boolean sameTree = isSameTree(treeNode, treeNode);
        System.out.println(sameTree);
    }

}
