package searching;

/**
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/binarysearch/MedianOfTwoSortedArrayOfDifferentLength.java
 *
 * https://www.youtube.com/watch?v=LPFhl65R7ww
 */
public class MedianOfTwoSortedArray {

    public static void main(String[] args) {
        int[] x = {1, 2, 3, 4, 9};
        int[] y = {2, 4, 11};
        System.out.println(findMedian(x, y));
    }

    static double findMedian(int[] x, int[] y) {
        //assumin x to be smaller array
        if(x.length > y.length)
            return findMedian(y, x);

        int t = (x.length+y.length+1)/2;

        int l = 0;
        int r = x.length-1;

        while(l <= r) {
            int midx = l + (r-l)/2;
            int midy = t - midx - 2;

            double leftMaxX = midx <= 0 ? Double.NEGATIVE_INFINITY : x[midx];
            double leftMaxY = midy <= 0 ? Double.NEGATIVE_INFINITY : y[midy];

            double rightMinX = midx >= x.length-1 ? Double.POSITIVE_INFINITY : x[midx+1];
            double rightMinY = midy >= y.length-1 ? Double.POSITIVE_INFINITY : y[midy+1];

            if(leftMaxX < rightMinY && leftMaxY < rightMinX) {
                if((x.length+y.length)%2==0)
                    return (Math.max(leftMaxX, leftMaxY) + Math.min(rightMinX, rightMinY))/2;
                else
                    return Math.max(leftMaxX, leftMaxY);
            }
            else if (leftMaxX > rightMinY)
                r = midx-1;
            else
                l = midx+1;
        }
        return -1;
    }

}
