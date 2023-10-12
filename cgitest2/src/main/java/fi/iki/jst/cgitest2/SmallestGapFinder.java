package fi.iki.jst.cgitest2;
public class SmallestGapFinder {
    
    public static final int smallestGap(int[] numbers) {
        if (numbers.length == 0 || numbers.length == 1) {
            throw new IllegalArgumentException("Length of array of numbers must be 2 or more");
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length - 1; i++) {
            int gap = gap(numbers[i], numbers[i+1]);
            if (gap < result) {
                result = gap;
            }
        }
        return result;
    }

    private static final int gap(int number1, int number2) {
        if (number1 < 0) {
            throw new IllegalArgumentException("Number " + number1 + " is not natural number.");
        }
        if (number2 < 0) {
            throw new IllegalArgumentException("Number " + number2 + " is not natural number.");
        }
        if (number1 == number2) {
            return 0;
        }
        if (number1 < number2) {
            return number2 - number1 - 1;
        }
        else {
            return number1 - number2 - 1;
        }
    }
}
