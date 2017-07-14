package Homework17.inheritance;

public class Entity extends AbstractEntity {
    private int x;
    protected String name;
    long y;
    public double z;

    @Override
    public String toString() {
        return "Entity{" +
                "x=" + x +
                ", name='" + name + '\'' +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
