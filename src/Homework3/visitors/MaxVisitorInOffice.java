package Homework3.visitors;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class MaxVisitorInOffice {
    public static void main(String[] args) {
        Visitor[] visitors = Visitor.createVisitors();
        Arrays.sort(visitors, new Comparator<Visitor>() {
            @Override
            public int compare(Visitor o1, Visitor o2) {
                return o1.getComeTime() > o2.getComeTime() ? 1 : -1;
            }
        });
        for (Visitor visitor : visitors) {
            System.out.println("Come " + new Date(visitor.getComeTime()));
            System.out.println("Leave " + new Date(visitor.getLeaveTime()));
        }
        int maxVisitorAtOnce = 0;

        for (int i = 0; i < visitors.length; i++)
            for (int j = i + 1; j < visitors.length; j++)
                if( visitors[i].getComeTime() > visitors[j].getComeTime() &&
                        visitors[i].getComeTime() < visitors[j].getLeaveTime() ||
                        visitors[i].getLeaveTime() > visitors[j].getComeTime() &&
                        visitors[i].getLeaveTime() < visitors[j].getLeaveTime() ||
                        visitors[j].getComeTime() > visitors[i].getComeTime() &&
                        visitors[j].getComeTime() < visitors[i].getLeaveTime() ||
                        visitors[j].getLeaveTime() > visitors[i].getComeTime() &&
                        visitors[j].getLeaveTime() < visitors[i].getLeaveTime())
                    maxVisitorAtOnce++;
        maxVisitorAtOnce += 1;


        System.out.println("Max visitors was " + maxVisitorAtOnce );
    }
}
