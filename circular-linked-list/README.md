# Circular Linked List — "Lemon Game"

A circular singly linked list built from scratch in Java (no `ArrayList`,
`LinkedList`, or any built-in collection), used to simulate the classic
children's game *"O limão entrou na roda"* (the lemon goes around the circle).

Players form a ring and pass an object around; when the music stops, whoever
holds it leaves the ring. The game repeats until a single winner remains — a
variation of the classic **Josephus problem**.

## Concepts practiced

- Self-referential nodes and chained (linked) structures
- Manual pointer manipulation (`next` re-wiring)
- Building and traversing a **circular** list
- Element removal with pointer and `head` updates

## Structure

| File | Responsibility |
| --- | --- |
| `Person.java` | Data stored in each node (name, age) |
| `Node.java` | A node: holds a `Person` and a reference to the `next` node |
| `LemonGame.java` | The circular linked list and the game logic |
| `Main.java` | Entry point that runs the simulation |

## How to run

```bash
cd src
javac *.java
java Main
```

## Status

🚧 Work in progress — the structure and its constructor are implemented.
The simulation methods (`passObject`, `removePosition`, `printCircle`) are
still being developed.
