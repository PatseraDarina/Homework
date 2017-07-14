package Homework2;

public class MatrixPrinter {
    public static void main(String[] args) {
        int[][] array = {
                {1, 2000, 3, 4},
                {3, 4, 5250, 60000000},
                {7, 5, 4, 1}
        };
        MatrixPrinter matrix = new MatrixPrinter();
        matrix.matrixPrint(array);
    }
    void matrixPrint(int[][] array) {
        String s;
        int arraysElement = getMaxLength(array) + 2;
        for (int i = 0; i < array.length; i++) {
            System.out.print("[");
            for (int j = 0; j < array[i].length; j++) {
                if (j != 0) {
                    s = "%" + arraysElement + "d";
                    System.out.format(s, array[i][j]);
                } else
                    System.out.print(array[i][j]);
            }
            System.out.print("]");
            System.out.println();
        }
    }

    private static int getMaxLength(int[][] array) {
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (maxLength < Math.ceil(Math.log10(Math.abs(array[i][j]) + 0.5))) {
                    maxLength = (int) Math.ceil(Math.log10(Math.abs(array[i][j]) + 0.5));
                }
            }
        }
        return maxLength;
    }
}
