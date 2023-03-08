package normal;

/**
 * @author yanqing.zou
 * @date 2022-09-19 17:45
 * Description
 */
public class A5_transpose {
    public int[][] transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        return matrix;
    }
}
