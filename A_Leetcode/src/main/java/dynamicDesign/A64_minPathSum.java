package dynamicDesign;

/**
 * @author yanqing.zou
 * @date 2023-03-07 19:49
 * Description
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 * 示例 1：
 *
 *
 * 输入：grid = [[1,3,1],
 *              [1,5,1],
 *              [4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * 示例 2：
 *
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A64_minPathSum {
    /**
     * 动态规划，到任何一个点，选择左边和上边的最小路径。
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        for (int i = 0; i< grid.length; i++){
            for(int j = 0; j<grid[i].length; j++){
                if(i == 0 && j == 0) {
                    grid[i][j] = grid[i][j];
                    continue;
                }else if(i == 0){
                    grid[i][j] += grid[i][j-1];
                    continue;
                }else if(j == 0){
                    grid[i][j] += grid[i-1][j];
                    continue;
                }
                grid[i][j] = Math.min(grid[i-1][j], grid[i][j-1]) + grid[i][j];
            }
        }

        return grid[grid.length-1][grid[grid.length-1].length-1];
    }

    public static void main(String[] args) {

    }
}
