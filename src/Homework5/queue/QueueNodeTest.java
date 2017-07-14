package Homework5.queue;

public class QueueNodeTest {
    public static void main(String[] args) {
        NodeQueueWrapper queue = new NodeQueueWrapper(new QueueNode(1));
        queue.addNode(new QueueNode(2));
        queue.addNode(new QueueNode(5));
        queue.printQueue();
        System.out.println(queue.getFromHead(3).getValue());
        queue.printQueueRecurcive();


//        System.out.println(queue.getHead().getValue());
//        queue.printQueue();
//
//        System.out.println(queue.getHead().getValue());
//        queue.printQueue();



    }
}
