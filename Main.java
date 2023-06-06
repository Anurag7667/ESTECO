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

        for (int i = 0; i < numbers.length; i++) {
            String number = numbers[i].trim();

            if (number.isEmpty()) {
                invalidPosition = i;
                break;
            }

            try {
                sum += Double.parseDouble(number);
            } catch (NumberFormatException e) {
                invalidPosition = i;
                break;
            }
        }

        if (invalidPosition != -1) {
            return "Number expected but '" + numbers[invalidPosition] + "' found at position "
                    + input.indexOf(numbers[invalidPosition]) + ".";
        }

        return Double.toString(sum);
    }
}
