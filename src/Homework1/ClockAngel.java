package Homework1;

import static java.lang.Math.abs;

public class ClockAngel {
    public static void main(String[] args) {
        int hours = 8;
        int mins = 20;
        int result = 0;

        String s = "ternary";

        //Circle equals 360 degree. It implies the angle between nearby digits equals 30 degree (360 / 12 = 30)
        result = abs(hours - mins / 5) * 30;
        switch (s) {
            case "ternary":
                System.out.println("Using ternary operator");
                result = (result > 180) ? (360 - result) : result;
                System.out.println("Angle between hours and minute narrows is " + result);
                break;

            case "if":
                System.out.println("Using conditional operator if");
                if (result > 180) {
                    result = 360 - result;
                }
                System.out.println("Angle between hours and minute narrows is " + result);
                break;
            default:
                System.out.println("Specify the variable s correctly! ");
                break;
        }
    }
}
