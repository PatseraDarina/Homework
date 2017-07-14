package Homework1;

public class SwitchValues {
    public static void main(String[] args) {
        int first = 2;
        int second = 7;
        /*int temp = first;
        first = second;
        second = temp;*/

        first = first + second;
        second = first - second;
        first = first - second;

        System.out.println("First = " + first + " , second = " + second);
    }
}
