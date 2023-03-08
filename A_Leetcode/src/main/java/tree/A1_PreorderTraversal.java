package tree;

import com.alibaba.fastjson.JSON;
import A_entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yanqing.zou
 * @date 2022-09-21 10:15
 * Description 前序遍历
 *        1
 *    2       3
 *  4   5   6   7
 *10  8
 * the result is: 1 2 4 8 5 3 6 7
 */
public class A1_PreorderTraversal {

    public static List<Integer> preorderTraversal(TreeNode treeNode){
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (treeNode != null || !stack.isEmpty()){
            while(treeNode != null){
                list.add(treeNode.val);
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            treeNode = stack.pop();
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
        treeNode.left.left.left = new TreeNode(10);
        treeNode.left.left.right = new TreeNode(8);

        List<Integer> list = preorderTraversal(treeNode);
        System.out.println(JSON.toJSONString(list));
    }

}
