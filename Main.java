import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the numbers separated by comma: ");
        String input = scanner.nextLine();

        String result = add(input);
        System.out.println("Sum: " + result);

        scanner.close(); // Close the scanner
    }

    public static String add(String input) {
        if (input.isEmpty()) {
            return "0";
        }

        if (input.endsWith(",") || input.endsWith("\n")) {
            return "Number expected but EOF found.";
        }

        String[] numbers = input.split("[,\n]");

        double sum = 0.0;
        int invalidPosition = -1;
        List<String> errorMessages = new ArrayList<>();
        StringBuilder negativeNumbers = new StringBuilder();

        for (int i = 0; i < numbers.length; i++) {
            String number = numbers[i].trim();

            if (number.isEmpty()) {
                invalidPosition = i;
                break;
            }

            double parsedNumber;
            try {
                parsedNumber = Double.parseDouble(number);
            } catch (NumberFormatException e) {
                invalidPosition = i;
                break;
            }

            if (parsedNumber < 0) {
                if (negativeNumbers.length() > 0) {
                    negativeNumbers.append(", ");
                }
                negativeNumbers.append(parsedNumber);
            }

            sum += parsedNumber;
        }

        if (invalidPosition != -1) {
            errorMessages.add("Number expected but '" + numbers[invalidPosition] + "' found at position "
                    + input.indexOf(numbers[invalidPosition]) + ".");
        }

        if (negativeNumbers.length() > 0) {
            errorMessages.add("Negative not allowed: " + negativeNumbers.toString());
        }

        if (!errorMessages.isEmpty()) {
            return String.join("\n", errorMessages);
        }

        return Double.toString(sum);
    }
}
