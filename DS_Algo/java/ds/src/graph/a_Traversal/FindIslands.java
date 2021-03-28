package graph.a_Traversal;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/number-of-islands/
 *
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 *
 * Sol: Assume 2d grid map as an undirected graph, run BFS and count the number of time queue was empty
 */
public class FindIslands {

    public static void main(String[] args) {
        int[][] grid = {{1,1,0,0,0}, {1,1,0,0,0}, {0,0,1,0,0}, {0,0,0,1,1}};
        System.out.println(findIslands(grid));
    }

    private static int findIslands(int[][] grid) {
        int count = 0;
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return count;

        for(int i=0; i< grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    count++;
                    bfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private static void bfs(int[][] grid, int x, int y) {
        grid[x][y] = 0;
        int nr = grid.length;
        int nc = grid[0].length;
        int code = x*nc + y;
        Queue<Integer> q = new LinkedList<>();
        q.offer(code);
        while(!q.isEmpty()) {
            int t = q.poll();
            int i = t/nc;
            int j = t%nc;
            if(i > 0 && grid[i-1][j] == 1) {
                q.offer((i-1)*nc+j);
                grid[i-1][j] = 0;
            }
            if(i < nr-1 && grid[i+1][j] == 1) {
                q.offer((i+1)*nc+j);
                grid[i+1][j] = 0;
            }
            if(j > 0 && grid[i][j-1] == 1) {
                q.offer(i*nc+(j-1));
                grid[i][j-1] = 0;
            }
            if(j < nc-1 && grid[i][j+1] == 1) {
                q.offer(i*nc+(j+1));
                grid[i][j+1] = 0;
            }
        }
    }
}
