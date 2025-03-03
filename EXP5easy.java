import java.util.ArrayList;
import java.util.List;

public class AutoboxingUnboxingExample {

    // Method to convert a list of String numbers to Integer list
    public static List<Integer> convertToIntegerList(String[] numbers) {
        List<Integer> intList = new ArrayList<>();
        for (String num : numbers) {
            intList.add(Integer.parseInt(num));  // Autoboxing: int to Integer
        }
        return intList;
    }

    // Method to calculate sum using unboxing
    public static int calculateSum(List<Integer> numbers) {
        int sum = 0;
        for (Integer num : numbers) {
            sum += num;  // Unboxing: Integer to int
        }
        return sum;
    }

    public static void main(String[] args) {
        String[] strNumbers = {"10", "20", "30", "40", "50"};
        
        // Convert Strings to Integer list
        List<Integer> integerList = convertToIntegerList(strNumbers);

        // Calculate sum
        int sum = calculateSum(integerList);
        
        // Output result
        System.out.println("Sum of numbers: " + sum);
    }
}
