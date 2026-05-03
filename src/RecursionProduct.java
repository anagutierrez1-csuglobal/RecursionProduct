import java.util.Scanner; // Utility to allow us to read user input from the keyboard

public class RecursionProduct {

    // Recursive method that multiplies all numbers in the array together
    // 'numbers' is the full array, 'index' is our current position in it
    public static long calculateProduct(int[] numbers, int index) {

        // When we reach the last element, return it to stop the recursion
        if (index == numbers.length - 1) {
            return numbers[index];
        }

        // Multiply the current number by the result of the next recursive call
        return numbers[index] * calculateProduct(numbers, index + 1);
    }

    // Main method: entry point of the program
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // Create a Scanner to read keyboard input
        int[] numbers = new int[5]; // Array to store the 5 numbers the user enters

        System.out.println("=== Recursive Product Calculator ===");
        System.out.println("Enter 5 numbers:");

        // Loop 5 times to collect each number from the user
        for (int i = 0; i < 5; i++) {
            System.out.print("Number " + (i + 1) + ": "); // Prompt for each number (1–5)
            numbers[i] = scanner.nextInt(); // Read and store the user's input
        }

        // Call the recursive method starting at index 0, store result as 'long' for large numbers
        long product = calculateProduct(numbers, 0);

        System.out.println("\n--- Results ---");
        System.out.print("Numbers entered: ");

        // Print each number separated by a multiplication symbol
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
            if (i < numbers.length - 1) System.out.print(" × "); // Avoid trailing × after last number
        }

        System.out.println("\nProduct = " + product); // Display the final product

        scanner.close(); // Close the Scanner to free up system resources
    }
}