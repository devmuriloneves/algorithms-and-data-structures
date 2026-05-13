public class Exercises {
    // Create a recursive method that prints an array received as parameter in reverse order
    public static <T> void printArrayReverse(T[] array) {
        printArrayReverse(array, array.length -1);
    }

    private static <T> void printArrayReverse(T[] array, int index) {
        if (index == 0) {
            System.out.println(array[0]);
            return;
        }
        System.out.println(array[index]);
        printArrayReverse(array, index - 1);
    }

    /* Create a recursive method that receives a 2D double array
       and returns the sum of its elements */
    public static double doubleArraySum(double[][] array) {
        return doubleArraySum(array, 0, 0);
    }

    private static double doubleArraySum(double[][] array, int line, int column) {
        if (line == array.length) {
            return 0;
        } else if (column == array[line].length - 1) {
            return array[line][column] + doubleArraySum(array, line + 1, 0);
        } else {
            return array[line][column] + doubleArraySum(array, line, column + 1);
        }
    }

    /* Create a method called findMinValueIndex. This method must find the position
    of the smallest value in an integer array received as parameter. */
    public static int findMinValueIndex(int[] array) {
        return findMinValueIndex(array, 0);
    }

    private static int findMinValueIndex(int[] array, int index) {
        if (index == array.length - 1)
            return index;
        int minIndex = findMinValueIndex(array, index + 1);
        if (array[index] <= array[minIndex])
            return index;
        else
            return minIndex;
    }
}
