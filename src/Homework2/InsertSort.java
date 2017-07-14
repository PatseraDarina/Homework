package Homework2;

import java.util.Arrays;

import static java.lang.System.arraycopy;

public class InsertSort {
    public static void main(String[] args) {
        int[] array = {5, 7, 9, 15, 10, -1, 8};
        int temp;
        int j;

        if (array.length !=1) {
            for (int i = 1; i < array.length; i++) {
                for (j = i - 1; j >= 0 && array[i] < array[j]; j--) {
                    continue;
                }
                if (!(j == i - 1)){
                    temp = array[i];
                    arraycopy(array, ++j, array, j + 1, i - j);
                    array[j] = temp;
                }
            }
            System.out.println(Arrays.toString(array));
        }
        else
            System.out.println("The array contains one element. It's sorted.");
    }
}