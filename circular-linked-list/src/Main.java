/**
 * Entry point that runs the "lemon game" simulation: the object is passed
 * around the circle and one participant is removed each round, until a
 * single winner remains.
 */
public class Main {
    public static void main(String[] args) {
        LemonGame game = new LemonGame(10);
        game.printCircle();
        System.out.println("*****");
        boolean finished = false;
        Person winner = null;

        while (!finished) {
            int position = game.passObject(14);
            winner = game.removePosition(position);
            game.printCircle();
            System.out.println("************");
            finished = winner != null;
        }
        System.out.println(winner);
    }
}
