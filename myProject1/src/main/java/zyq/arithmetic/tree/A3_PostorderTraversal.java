package zyq.arithmetic.tree;

import com.alibaba.fastjson.JSON;
import zyq.arithmetic.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yanqing.zou
 * @date 2022-09-21 10:28
 * Description 后序遍历
 *        1
 *    2       3
 *  4   5   6   7
 *   8
 *  9 0
 * the result is: 9 0 8 4 5 2 6 7 3 1
 */
public class A3_PostorderTraversal {
    public static List<Integer> postorderTraversal(TreeNode treeNode){
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while(treeNode != null || !stack.isEmpty()){
            while(treeNode !=null){
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            treeNode = stack.peek();
            if(treeNode.right == null || treeNode.right == pre){
                list.add(treeNode.val);
                stack.pop();
                pre = treeNode;
                treeNode = null;
            }else{
                treeNode = treeNode.right;
            }
        }

        return list;
    }
    public static void main(String[] args){
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);
        treeNode.left.left.right = new TreeNode(8);
        treeNode.left.left.right.left = new TreeNode(9);
        treeNode.left.left.right.right = new TreeNode(0);
        List<Integer> list = postorderTraversal(treeNode);
        System.out.println(JSON.toJSONString(list));
    }
}
