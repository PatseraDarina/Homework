package Homework2;

import java.util.Arrays;

public class YourOwnBinarySearch {
    static int[] array = {1, 4, 7, 10, 17, 30, 48};
    static int element = 4;

    public static void main(String[] args) {
        System.out.println(binarySearch(array, element));
    }


    private static int binarySearch(int[] array, int elem) {
        int result = -1;
        int left = 0;
        int right = array.length;
        int middle;

        Arrays.sort(array);

        while (!(left >= right)) {
            middle = left + (right - left) / 2;

            if (array[middle] == elem)
                return middle;

            if (array[middle] > elem)
                right = middle;
            else
                left = middle + 1;
        }
            return result;
    }
}
