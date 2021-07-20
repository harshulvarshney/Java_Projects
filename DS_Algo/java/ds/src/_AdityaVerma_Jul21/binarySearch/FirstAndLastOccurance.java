package _AdityaVerma_Jul21.binarySearch;

public class FirstAndLastOccurance {

    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,8};
        int startIndex = first(arr, 8);
        System.out.println("First occurance :: " + startIndex);
        System.out.println("Last  occurance :: " + last(arr, 8));
    }

    static int first(int[] arr, int k) {
        int l = 0;
        int r = arr.length - 1;

        while(l <= r) {
            int mid = l + (r-l)/2;
            if(arr[mid] == k && (mid == 0 || arr[mid] > arr[mid-1]))
                return mid;
            if(arr[mid] == k || arr[mid] > k)
                r = mid-1;
            else
                l = mid+1;
        }
        return -1;
    }

    static int last(int[] arr, int k) {
        int l = 0;
        int r = arr.length-1;

        while(l <= r) {
            int mid = l + (r-l)/2;
            if(arr[mid] == k && (mid == arr.length-1 || arr[mid+1]>k))
                return mid;
            if(arr[mid] == k || arr[mid] < k)
                l = mid+1;
            else
                r = mid-1;
        }
        return -1;
    }
}
