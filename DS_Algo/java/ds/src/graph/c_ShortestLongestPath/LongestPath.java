package graph.c_ShortestLongestPath;

/**
 * On a general graph, finding longest path is NP-hard
 * but got DAG it can be solved in O(V+E)
 *
 * Algo:
 *      multiply all edge weights with -1
 *      find the shortest path
 *      return shorted-path > distance * -1
 */
public class LongestPath {
}
