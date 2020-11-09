package graph.problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a MxN matrix where each element can either be 0 or 1. We need to find the shortest path
 * between a given source cell to a destination cell. The path can only be created out of a cell if its value is 1.
 * Expected time complexity is O(MN), for example:
 *
 * Input:
 * mat[ROW][COL]  = {{1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
 *                   {1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
 *                   {1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
 *                   {0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
 *                   {1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
 *                   {1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
 *                   {1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
 *                   {1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
 *                   {1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }};
 * Source = {0, 0};
 * Destination = {3, 4};
 *
 * Output:
 * Shortest Path is 11
 *
 */
public class ShortestPathBinaryMaze {

    int[][] mat;
    Queue<Integer> rq;
    Queue<Integer> cq;
    boolean[][] visited;
    int nodesLeft = 1;
    int nodexInNextLevel = 0;
    int[] rv = {-1, 1, 0, 0};
    int[] cv = {0, 0, -1, 1};


    public int find(int[] E, int[] X) {

        int path = 1;
        rq = new LinkedList<>();
        cq = new LinkedList<>();
        visited = new boolean[mat.length][mat[0].length];

        rq.offer(E[0]);
        cq.offer(E[1]);
        visited[E[0]][E[1]] = true;

        while(!rq.isEmpty()) {
            int x = rq.poll();
            int y = cq.poll();
            if(x == X[0] && y == X[1]) {
                return path;
            }
            findNeighbours(x, y);
            nodesLeft--;
            if(nodesLeft == 0) {
                nodesLeft = nodexInNextLevel;
                nodexInNextLevel = 0;
                path++;
            }

        }

        return -1;
    }

    private void findNeighbours(int x, int y) {
        for(int i=0; i<4; i++) {
            int xx = x + rv[i];
            int yy = y + cv[i];

            if(xx < 0 || yy < 0 || xx > mat.length || yy > mat[0].length || visited[xx][yy] || mat[xx][yy] == 0)
                continue;

            rq.offer(xx);
            cq.offer(yy);
            nodexInNextLevel++;
        }
    }

    public static void main(String[] args) {
        ShortestPathBinaryMaze obj = new ShortestPathBinaryMaze();
        obj.mat = new int[][]{
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                {1, 1, 1, 0, 1, 1, 1, 0, 1, 0},
                {1, 0, 1, 1, 1, 1, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 1, 0, 0, 0, 0, 1, 0, 0, 1}};

        int[] entry = {0, 0};
        int[] exit = {2, 0};

        System.out.println("Path: " + obj.find(entry, exit));
    }
}
