// Entry point used to test the methods from the Exercises class
public class RecursionExercisesRunner {
    public static void main(String[] args) throws Exception {
        Exercises.printArrayReverse(new Integer[] {1, 2, 8, 6, 7});

        System.out.println(Exercises.doubleArraySum(new double[][] {{1.0, 2.0}, {3.0, 4.0}}));

        System.out.println(Exercises.findMinValueIndex(new int[] {3, 1, 4, 1, 5}));

        System.out.println(Exercises.binaryToDecimal("11010001"));
    }
}
