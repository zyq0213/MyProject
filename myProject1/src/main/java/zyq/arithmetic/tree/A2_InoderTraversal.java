package zyq.arithmetic.tree;


import com.alibaba.fastjson.JSON;
import zyq.arithmetic.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yanqing.zou
 * @date 2022-08-29 20:13
 * Description 中序遍历
 * *        1
 * *    2       3
 * *  4   5   6   7
 * *   8
 *  the result is: 4 8 2 5 1 6 3 7
 */
public class A2_InoderTraversal {
    public static List<Integer> preorderTraversal(TreeNode treeNode){
        List<Integer> list = new ArrayList<>();
        if(treeNode == null){
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        while(treeNode!=null || !stack.isEmpty()){
            while(treeNode != null){
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            treeNode = stack.pop();
            list.add(treeNode.val);
            treeNode = treeNode.right;
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

        List<Integer> list = preorderTraversal(treeNode);
        System.out.println(JSON.toJSONString(list));
    }
}
