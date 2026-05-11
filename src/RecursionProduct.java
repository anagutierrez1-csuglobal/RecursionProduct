import java.util.Scanner; // Lets us read input that the user types on the keyboard

public class RecursionProduct {

    // This method calculates the product of all numbers in the array using recursion.
    // 'numbers' is the array of all 5 numbers, 'index' is which position we are on right now.
    public static long calculateProduct(int[] numbers, int index) {

        // Base case: once we reach the last number, return it to stop the recursion
        if (index == numbers.length - 1) {
            return numbers[index];
        }

        // Multiply the current number by the result of calling this method again on the next position
        return numbers[index] * calculateProduct(numbers, index + 1);
    }

    // This method handles collecting one valid number from the user.
    // It keeps asking until the user enters something that passes all three checks:
    //   1. It must be a whole number (no decimals)
    //   2. It must be no longer than 4 digits
    //   3. It must actually be a number and not letters or symbols
    public static int getValidNumber(Scanner scanner, int promptNumber) {

        // Keep looping until a valid number is entered — the loop only exits with a return statement
        while (true) {

            System.out.print("Number " + promptNumber + ": "); // Ask the user to enter a number
            String input = scanner.nextLine().trim();           // Read what the user typed as text and remove extra spaces

            // CHECK 1: Make sure the input doesn't contain a decimal point
            // We read input as text first so we can catch decimals before trying to convert it
            if (input.contains(".")) {
                System.out.println("  Invalid: Whole numbers only — no decimals allowed. Please try again.");
                continue; // Skip the rest of this loop and ask again
            }

            // CHECK 2: Make sure the input is no longer than 4 digits
            // We check the raw text length, ignoring a leading minus sign if the number is negative
            String digitsOnly = input.startsWith("-") ? input.substring(1) : input; // Strip the minus sign for length check only
            if (digitsOnly.length() > 4) {
                System.out.println("  Invalid: Number must be 4 digits or fewer (between -9999 and 9999). Please try again.");
                continue; // Skip the rest of this loop and ask again
            }

            // CHECK 3: Try to convert the text into a whole number
            // If the user typed something that isn't a number at all (like "abc"), this will fail
            try {
                int number = Integer.parseInt(input); // Attempt to turn the text into an integer
                return number;                        // If it worked, return the valid number and exit the loop

            } catch (NumberFormatException e) {
                // This runs if Integer.parseInt() failed because the input wasn't a valid number
                System.out.println("  Invalid: Please enter a whole number using digits only (no letters or symbols).");
                // The while loop will repeat and ask the user again
            }
        }
    }

    // Main method — this is where the program starts running
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // Create a Scanner to read keyboard input
        int[] numbers = new int[5];               // Create an array to hold the 5 numbers the user enters

        System.out.println("=== Recursive Product Calculator ===");
        System.out.println("Rules: Whole numbers only, no decimals, max 4 digits each.");
        System.out.println("Enter 5 numbers:\n");

        // Loop 5 times to collect each number from the user
        for (int i = 0; i < 5; i++) {
            numbers[i] = getValidNumber(scanner, i + 1); // Call our validation method and store the result
            // i + 1 is passed so the prompt says "Number 1", "Number 2", etc. instead of starting at 0
        }

        // Call the recursive method starting at index 0 to multiply all 5 numbers together
        // We store the result as a 'long' because multiplying large numbers can exceed int's limit
        long product = calculateProduct(numbers, 0);

        // Print the results section
        System.out.println("\n--- Results ---");
        System.out.print("Numbers entered: ");

        // Loop through the array to print each number separated by a multiplication symbol
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
            if (i < numbers.length - 1) System.out.print(" × "); // Don't print × after the last number
        }

        System.out.println("\nProduct = " + product); // Display the final calculated product

        scanner.close(); // Close the Scanner to free up system resources when the program ends
    }
}