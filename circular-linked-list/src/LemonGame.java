/**
 * Circular singly linked list that simulates the children's game
 * "O limão entrou na roda" (the lemon goes around the circle), built
 * from scratch without any built-in collection.
 */
public class LemonGame {
    private Node head; // first participant in the circle
    private int size;  // number of participants currently in the circle

    /**
     * Builds the circle with the given number of participants. Each
     * participant is wrapped in a Node and the nodes are linked into a
     * circular chain (the last node points back to the head).
     *
     * @param size number of participants in the circle
     */
    public LemonGame(int size) {
        this.size = size;
        String[] names = {
            "Ana", "Bruno", "Carla", "Daniel", "Elena", "Felipe",
            "Gabriela", "Hugo", "Isabela", "João", "Karina", "Lucas"
        };
        Node previousNode = null;
        for (int i = 1; i <= size; i++) {
            Person person = new Person(names[(i - 1) % names.length], (int) (Math.random() * (30 - 10 + 1) + 10));
            Node node = new Node(person);
            if (head == null) {
                head = node;                // first node becomes the head
            } else {
                previousNode.setNext(node); // link the previous node to the current one
            }
            previousNode = node;
        }
        if (previousNode != null) {
            previousNode.setNext(head);     // close the circle: last node points back to head
        }
    }

    /**
     * Simulates passing the object around the circle.
     *
     * @param x number of times the object is passed
     * @return the position where the object stopped
     */
    public int passObject(int x) {
        int position = 1;
        Node node = head;
        for (int i = 0; i < x; i++) {
            node = node.getNext();
            if (position == size)
                position = 1;
            else
                position++;
        }
        return position;
    }

    /**
     * Removes the participant at the given position, re-links the
     * neighbouring nodes and updates the head when needed.
     *
     * @param x position of the participant to remove
     * @return the winner once a single participant remains, otherwise null
     */
    public Person removePosition(int x) {
        if (x == 1) {
            Node oldHead = head;
            head = head.getNext();
            size--;
            Node node = head;
            while (node.getNext() != oldHead) {
                node = node.getNext();
            }
            node.setNext(head);
            if (size == 1)
                return head.getData();
            else
                return null;
        }
        Node previousNode = head;
        for (int i = 0; i < x - 2; i++) {
            previousNode = previousNode.getNext();
        }
        previousNode.setNext(previousNode.getNext().getNext());
        size--;
        if (size == 1)
            return head.getData();
        else
            return null;
    }

    /**
     * Prints the participants currently in the circle, in order.
     */
    public void printCircle() {
        if (head == null) {
            System.out.println("The circle is empty.");
            return;
        } else {
            System.out.println("Participants in the circle:");
            Node current = head;
            do {
                System.out.println(" - " + current.getData().getName());
                current = current.getNext();
            } while (current != head);
        }
    }
}
