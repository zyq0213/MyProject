package zyq.arithmetic;

/**
 * @author yanqing.zou
 * @date 2022-08-29 20:10
 * Description

 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(){

    }
    public TreeNode(int val){
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }


}
