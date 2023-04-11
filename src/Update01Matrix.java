import java.util.*;
public class Update01Matrix {
    public int[][] findShortestDistance(int[][] mat, int[][] result, int rows, int cols, Queue<int[]> visited) {
        while (!visited.isEmpty()) {
                int[] first = visited.poll();
                int i2 = first[0], j2 = first[1];
                if (j2 < cols - 1 && result[i2][j2 + 1] == -1) {
                    result[i2][j2 + 1] = result[i2][j2] + 1;
                    visited.offer(new int[]{i2, j2 + 1});
                }
                if (i2 < rows - 1 && result[i2 + 1][j2] == -1) {
                    result[i2 + 1][j2] = result[i2][j2] + 1;
                    visited.offer(new int[]{i2 + 1, j2});
                }
                if (j2 >= 1 && result[i2][j2 - 1] == -1) {
                    result[i2][j2 - 1] = result[i2][j2] + 1;
                    visited.offer(new int[]{i2, j2 - 1});
                }
                if (i2 >= 1 && result[i2 - 1][j2] == -1) {
                    result[i2 - 1][j2] = result[i2][j2] + 1;
                    visited.offer(new int[]{i2 - 1, j2});
                }
            }
        return result;
    }

    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        int[][] result = new int[rows][cols];
        Queue<int[]> visited = new LinkedList<int[]>(); // To store the index i, j
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] != 0) {
                    result[i][j] = -1; // Mark as unprocessed
                } else {
                    result[i][j] = 0;
                    visited.offer(new int[]{i, j});
                }
            }
        }
        return findShortestDistance(mat, result, rows, cols, visited);
    }
}