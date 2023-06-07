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

        String delimiter = ",";
        String numbersString = input;

        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            if (delimiterEndIndex == -1) {
                return "Invalid delimiter format.";
            }
            delimiter = input.substring(2, delimiterEndIndex);
            numbersString = input.substring(delimiterEndIndex + 1);
        }

        String[] numbers = numbersString.split("[,\n" + delimiter + "]");

        double sum = 0.0;
        List<String> errorMessages = new ArrayList<>();
        StringBuilder negativeNumbers = new StringBuilder();

        for (int i = 0; i < numbers.length; i++) {
            String number = numbers[i].trim();

            if (number.isEmpty()) {
                errorMessages.add("'" + delimiter + "' expected but ',' found at position " + (i + 1) + ".");
                continue;
            }

            double parsedNumber;
            try {
                parsedNumber = Double.parseDouble(number);
            } catch (NumberFormatException e) {
                errorMessages.add("Invalid number format: " + number);
                continue;
            }

            if (parsedNumber < 0) {
                negativeNumbers.append(parsedNumber).append("\n");
            }

            sum += parsedNumber;
        }

        if (negativeNumbers.length() > 0) {
            errorMessages.add("Negative not allowed: " + negativeNumbers.toString().trim());
        }

        if (!errorMessages.isEmpty()) {
            return String.join("\n", errorMessages);
        }

        return Double.toString(sum);
    }
}
