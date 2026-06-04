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

    public static <T> void printPrimaryDiagonal(T[][] array) {
        printPrimaryDiagonal(array, 0, 0);
    }

    private static <T> void printPrimaryDiagonal(T[][] array, int line, int column) {
        if (line == array.length)
            return;
        else if (column < array[line].length)
            System.out.println(array[line][column]);
        printPrimaryDiagonal(array, line + 1, column + 1);
    }

    public static int binaryToDecimal(String binary) {
        if (!binary.matches("[01]{8}"))
            return -1;
        return binaryToDecimal(binary, 0);
    }

    private static int binaryToDecimal(String binary, int index) {
        if (index == binary.length())
            return 0;
        int number = Character.getNumericValue(binary.charAt(index));
        if (number == 1)
            return (int) Math.pow(2, binary.length() - 1 - index) + binaryToDecimal(binary, index + 1);
        else
            return binaryToDecimal(binary, index + 1);
    }
}
