package Homework5.queue;

public class NodeQueueWrapper {
    private QueueNode tail;

    public NodeQueueWrapper(QueueNode node) {
        tail = node;
    }

    public void addNode(QueueNode node) {
        node.setNext(tail);
        tail = node;
    }

    public QueueNode getHead() {
        QueueNode current;
        if (tail.getNext() != null) {
            current = tail.getNext();
            QueueNode prev = tail;
            while (current.getNext() != null) {
                current = current.getNext();
                prev = prev.getNext();
            }
            prev.setNext(null);
        }
        else {
            current = tail;
            tail = null;
        }
        return current;
    }

    public void printQueue() {
        QueueNode current = tail;
        while (current != null) {
            System.out.print(current.getValue() + " --> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    public void printQueueRecurcive() {
        printRecurcive(tail);
        System.out.println("null");
    }

    private void printRecurcive(QueueNode current) {
        System.out.print(current.getValue() + " --> ");
        if (current.getNext() != null) {
            printRecurcive(current.getNext());
        }
    }

    /**
     * Removes Node from list that is located on position from head(start of the list).
     * If position is more than list size prints error message
     * @param position number of the Node starting from the head
     **/
    public void remove(int position) {
            int count = 0;
            QueueNode current = tail;
            while (current != null) {
                count++;
                current = current.getNext();
            }
            if (count > position) {
                position = count - position;
                count = 1;
                current = tail;
                    while (count != position) {
                        count++;
                        current = current.getNext();
                    }
                    if (current.getNext() != null) {
                            current.setNext(current.getNext().getNext());
                        }
                        else
                            current.setNext(null);
            }
        else if (count == position) {
                tail = tail.getNext();
            }
            else if (count < position)
        {
            System.out.println("Position is more than list size");
        }
    }

    /**
     * Adds Node to list on position from head(start of the list).
     * If position is more than list size prints error message
     * @param position number of the Node starting from the head
     * @param node node should be inserted at position
     */
    public void addNodeOnPosition(int position, QueueNode node) {
        QueueNode current = tail;
        int count = 0;
        while (current != null){
            count++;
            current = current.getNext();
        }
        if (position > count){
            System.out.println("Position is more than list size");
        }
        else
        {
            position = count + 1 - position;
            count = 1;
            current = tail;
            while (count != position){
                count++;
                current = current.getNext();
            }
            node.setNext(current.getNext());
            current.setNext(node);
        }
    }

    /**
     * Gets then Node that located on the position starting from the tail (end of the list)
     * if position is more than list size - prints error message
     * @param position number of the Node starting from the tail
     * @return Node that located on the position from the tail (end of list) if position exists in list
     */
    public QueueNode getFromHead(int position) {
        QueueNode result = null;
        QueueNode current = tail;
            int count = 0;
            while (current != null) {
                count++;
                current = current.getNext();
            }
            if (count > position) {
                position = count - position;
                count = 1;
                current = tail;
                    while (count != position) {
                        count++;
                        current = current.getNext();
                    }
                    result = current.getNext();
                    current.setNext(current.getNext().getNext());
                    }
                else if (count == position) {
                result = tail;
                tail = tail.getNext();
            }
             else
                {
                System.out.println("Position is more than list size.");
            }
        return result;
    }
}
