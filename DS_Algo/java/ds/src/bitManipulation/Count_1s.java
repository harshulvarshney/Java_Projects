package bitManipulation;

/**
 * https://www.youtube.com/watch?v=bc7cxeDy308&list=PLSIpQf0NbcCm1HjcbM6aAoDUdpZyS1YBP&index=1
 *
 * Length Of The Longest Consecutive 1s In Binary Representation Of A Number
 */
public class Count_1s {

    public static void main(String[] args) {
        int num = 21166184;
        System.out.println(Integer.toBinaryString(num));

        int count = 0;
        while(num != 0) {
            count++;
            num = num & num << 1;
        }

        System.out.println("longest consecutive 1s :: " + count);
    }
}
