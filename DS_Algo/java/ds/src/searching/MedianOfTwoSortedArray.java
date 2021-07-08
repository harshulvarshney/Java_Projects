package searching;

/**
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/binarysearch/MedianOfTwoSortedArrayOfDifferentLength.java
 *
 * https://www.youtube.com/watch?v=LPFhl65R7ww
 */
public class MedianOfTwoSortedArray {

    static double findMedian(int[] arr1, int[] arr2) {
        if(arr1 == null || arr1.length == 0)
            return median(arr1);
        if(arr2 == null || arr2.length == 0)
            return median(arr2);

        if(arr1.length > arr2.length)
            findMedian(arr2, arr1);

        int x = arr1.length;
        int y = arr2.length;

        int l = 0;
        int r = x-1;
        while(l <= r) {
            int partX = l + (r - l) /2;
            int partY = (x + y)/2 - partX;

            double maxLeftX = partX == 0 ? Double.NEGATIVE_INFINITY : arr1[partX-1];
            double minRightX = partX == x ? Double.POSITIVE_INFINITY : arr1[partX];

            double maxLeftY = partY == 0 ? Double.NEGATIVE_INFINITY : arr2[partY-1];
            double minRightY = partY == y ? Double.POSITIVE_INFINITY : arr2[partY];

            if(maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if((x + y) % 2 == 0)
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
                else
                    return Math.min(minRightX, minRightX);
            }
            else if(maxLeftX > minRightY)
                r = partX-1;
            else
                l = partX + 1;

        }
        return -1;
    }

    static double median(int[] arr) {
        int midIndex = arr.length/2;
        if(arr.length % 2 == 0) {
            return ((double) arr[midIndex] + (double) arr[midIndex-1])/2;
        }
        return arr[midIndex];
    }

    public static void main(String[] args) {
        int[] x = {1, 2, 3, 4, 9};
        int[] y = {2, 4, 9};
        System.out.println(findMedian(x, y));
    }
}
