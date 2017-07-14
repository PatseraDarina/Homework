package Homework1;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class TriangelSquare {
    public static void main(String[] args) {
        int x1 = 1, y1 = 1;
        int x2 = 10, y2 = 7;
        int x3 = -3, y3 = 4;
        double length = 0;
        double square = 0;

        double a = sqrt((pow((x2 - x1), 2) + pow((y2 - y1), 2)));
        double b = sqrt((pow((x3 - x1), 2) + pow((y3 - y1), 2)));
        double c = sqrt((pow((x3 - x2), 2) + pow((y3 - y2), 2)));

        length = a + b + c;
        square = sqrt(length / 2 * (length / 2 - a) * (length / 2 - b) * (length / 2 - c));

        System.out.println("Length of all sides is " + length);
        System.out.println("Square is " + square);
    }
}
