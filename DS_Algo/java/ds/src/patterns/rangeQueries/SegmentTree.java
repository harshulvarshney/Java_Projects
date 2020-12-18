package patterns.rangeQueries;

import java.util.Arrays;

/**
 * https://www.youtube.com/watch?v=ZBHKZF5w4YU
 */
public class SegmentTree {

    static int [] tree;
    public static void main(String[] args) {
        int [] arr = {-1,2,4,0, -2};
        prepareTree(arr);
        System.out.println("min in range: " + rangeMinimumQuery(0, arr.length-1, 2, 4, 0));
    }

    private static void prepareTree(int [] arr) {
        int n = arr.length;
        int treelen = (n&(n-1)) == 0 ? (2*n-1) : 2*(((n&(n-1))) << 1)-1;
        tree = new int[treelen];
        build(arr, 0, n-1, 0);
    }

    private static void build(int[] arr, int low, int high, int pos) {
        if(low == high) {
            tree[pos] = arr[low];
            return;
        }
        int mid = (low+high)/2;
        build(arr, low, mid, 2*pos+1);
        build(arr, mid+1, high, 2*pos+2);
        tree[pos] = Math.min(tree[2*pos+1], tree[2*pos+2]);
    }

    /**
     * query is answered by traversing the tree with 3 conditions:
     *      1- if the range (l, r) perfectly overlaps with node range, return node value
     *      2- if the range (l, r) does not overlaps with node range, return infinity
     *      3- for partial overlap, search in node children (both sides)
     */
    private static int rangeMinimumQuery(int low,int high,int l,int r,int pos){
        if(l <= low && r >= high){
            return tree[pos];
        }
        if(l > high || r < low){
            return Integer.MAX_VALUE;
        }
        int mid = (low+high)/2;
        return Math.min(rangeMinimumQuery(low, mid, l, r, 2 * pos + 1),
                rangeMinimumQuery(mid + 1, high, l, r, 2 * pos + 2));
    }


}
