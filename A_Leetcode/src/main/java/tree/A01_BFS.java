package tree;

import A_entity.TreeNode;

import java.util.*;

/**
 * @author yanqing.zou
 * @date 2023-01-10 17:42
 * Description 广度优先算法
 *          1
 *       2     3
 *     4  5   6  7
 */
public class A01_BFS {
    public static List<Integer> BFS(TreeNode treeNode){
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue =new LinkedList<>();
        queue.add(treeNode);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
        return list;
    }

    public static List<Integer> BFS1(TreeNode treeNode){
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(treeNode);
        while (!deque.isEmpty()){
            TreeNode node = deque.removeFirst();
            list.add(node.val);
            if(node.left != null){
                deque.add(node.left);
            }
            if(node.right != null){
                deque.offer(node.right);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);
        List<Integer> bfs = BFS1(treeNode);
        System.out.println(Arrays.toString(bfs.toArray()));
    }
}
