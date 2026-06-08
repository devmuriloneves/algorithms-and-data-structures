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
        // TODO: walk x steps around the circle and return the position where it stops
        return 0;
    }

    /**
     * Removes the participant at the given position, re-links the
     * neighbouring nodes and updates the head when needed.
     *
     * @param x position of the participant to remove
     * @return the winner once a single participant remains, otherwise null
     */
    public Person removePosition(int x) {
        // TODO: remove the node at position x, update the pointers/head and the winner logic
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
        // TODO: traverse the circular list from the head and print each participant
    }
}
