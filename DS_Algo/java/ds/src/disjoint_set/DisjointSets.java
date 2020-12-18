package disjoint_set;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.youtube.com/watch?v=ID00PMy0-vE
 *
 * Disjoint-Sets is a data structure the offers 2 operations:
 *      1- union
 *      2- find
 *
 * This data structure is used in Kruskal's algo to find MST and
 * to find cycle in non-directed graphs
 *
 * In Below implementation, this DS is represented as a Tree
 */
public class DisjointSets {

    private Map<Integer, DsNode> map = new HashMap<>();

    /**
     * A node in this tree
     */
    public static class DsNode {
        int data;
        int rank;
        DsNode parent;

        public DsNode(int data) {
            this.data = data;
            this.rank = 0;
            this.parent = this;
        }
    }

    /**
     * create a new set
     */
    public void make(int data) {
        DsNode node = new DsNode(data);
        map.put(data, node);
    }

    public boolean union(int data1, int data2) {
        DsNode n1 = map.get(data1);
        DsNode n2 = map.get(data2);

        DsNode p1 = find(n1);
        DsNode p2 = find(n2);

        if(p1 == p2) {//both elements are already part of same set
            return false;
        }

        //node with higher rank becomes parent
        if(p1.rank >= p2.rank) {
            p1.rank = (p1.rank == p2.rank) ? p1.rank+1 : p1.rank;
            p2.parent = p1;
        } else {
            p1.parent = p2;
        }
        return true;
    }

    /**
     * find and return the set# to which this element belongs
     */
    public int find(int data) {
        return find(map.get(data)).data;
    }

    private DsNode find(DsNode node) {
        DsNode parent = node.parent;
        if(node == parent)
            return node;
        node.parent = find(node.parent);
        return node.parent;
    }
}
