package _AdityaVerma_Jul21.binarySearch;

public class RotatedSortedArray {

    public static void main(String[] args) {
        int[] arr = {8, 9, 2};
        System.out.println(howManyTimesArrayIsRotated(arr));
        System.out.println(findInRotatedArray(arr, 9));
    }

    static int howManyTimesArrayIsRotated(int[] arr) {
        int s = 0;
        int e = arr.length-1;
        int n = arr.length;

        while(s <= e) {
            int mid = s + (e-s)/2;
            int prev = (mid + n - 1) % n; // this is most important in this question, this is needed to avoid out-of-bound exception
            if(arr[mid] < arr[prev]) {
                return mid;
            }
            else if (arr[mid] < arr[0])
                e = mid-1;
            else
                s = mid+1;
        }
        return -1;
    }

    static int findInRotatedArray(int[] arr, int k) {
        int n = arr.length;
        int indexOfMinElement = howManyTimesArrayIsRotated(arr);
        int s = k >= arr[indexOfMinElement] && k <= arr[n-1] ? indexOfMinElement : 0;
        int e = k >= arr[indexOfMinElement] && k <= arr[n-1] ? n-1 : indexOfMinElement-1;

        while(s <= e) {
            int mid = s + (e-s)/2;
            if(arr[mid] == k)
                return mid;
            else if(k > arr[mid])
                s = mid+1;
            else
                e = mid-1;
        }
        return -1;
    }
}
