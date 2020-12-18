package graph.e_StronglyConnectedComponents;

/**
 * Strongly Connected Components (SCCs)
 * A self-contained cycle withing a **directed graph** where a node in a cycle can reach every other node in same cycle
 * SCCs can exists only in directed graphs
 *
 * https://www.udemy.com/course/graph-theory-algorithms/learn/lecture/19791308#notes
 *
 * Time Complexity: O(V+E)
 *
 * This algo is similar to finding bridges but
 * In this algo we uses a stack s.t.
 *      keep adding edges into stack while dfs
 *      while backtracking, remove the edge
 *          if id[at] = low[at] ==> we hv found a SCC
 *
 *
 * NOTE: low-link values depends on which node was the root node of dfs
 *       i.e. if we start dfs on a different node, low-link values will also change
 */
public class TarjansAlgo {
}
