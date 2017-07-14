package Homework2;

public class MatrixMultiplier {

    public static void main(String[] args) {
        int[][] first = {
                {1, 2, 3, 4},
                {3, 4, 5, 3},
                {7, 5, 4, 1}
        };

        int[][] second = {
                {1, 2, 3},
                {3, 4, 6},
                {7, 5, 1},
                {3, 4, 9}
        };

        MatrixPrinter matrix = new MatrixPrinter();
        if (isRectangle(first) && isRectangle(second)) {
            if (first[0].length == second.length) {
                int row = first.length;
                int column = second[0].length;
                int[][] result = new int[row][column];
                for (int l = 0; l < second[0].length; l++) {
                    for (int i = 0; i < row; i++) {
                        for (int j = 0; j < second.length; j++) {
                            result[l][i] += first[l][j] * second[j][i];
                        }
                    }
                }
                matrix.matrixPrint(result); // Use of a method for formatted matrix output from homework MatrixPrinter
            } else
                System.out.println("Cannot multiply matrices. Number of columns of first matrix must equal number of  row of second matrix.");
        }
        else {
            System.out.println("One of matrix not rectangular");
        }
    }

    public static boolean isRectangle(int[][] array){
        int firstRowCount = array[0].length;
        for (int i = 1; i < array.length; i++) {
            if (firstRowCount != array[i].length){
                return false;
            }
        }
        return true;
    }
}
