package Homework17.inheritance;

public class SuperEntity extends Entity {
    public int a;
    private final int b = 1;
    @MyAnnotation
    private int c;

    private void f() {
        System.out.println(a + " " + b + " " + c);
    }

    public String g() {
        return "";
    }

    public String h(String string) {
        if (string == null) {
            return string;
        }
        return new StringBuilder(string).reverse().toString();
    }

    @Override
    public String toString() {
        return "SuperEntity{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}' + super.toString();
    }
}
