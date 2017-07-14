package Homework2;

import java.util.Arrays;

public class MatrixInverter {
    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 3, 4},
                {3, 4, 5, 6},
                {7, 7, 4, 1},
                {7, 5, 4, 1}
        };
        int temp;

        if (array.length != array[0].length) {
            System.out.println("Non-square matrix.");
        } else {
            for (int i = 0; i < array.length; i++)
                for (int j = 0; j < i && i != j; j++)
                {
                        temp = array[i][j];
                        array[i][j] = array[j][i];
                        array[j][i] = temp;
                    }
            for (int i = 0; i < array.length; i++)
                System.out.println(Arrays.toString(array[i]));
        }
    }
}