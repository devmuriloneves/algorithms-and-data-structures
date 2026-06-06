/**
 * A node of the circular linked list. It holds a Person and a reference
 * to the next node in the circle.
 */
public class Node {
    private Person data;
    private Node next;

    public Node(Person data) {
        this.data = data;
        this.next = null;
    }

    public Person getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
