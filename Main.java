import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the numbers separated by comma: ");
        String input = scanner.nextLine();

        String result = add(input);
        System.out.println("Sum: " + result);
    }

    public static String add(String input) {
        if (input.isEmpty()) {
            return "0";
        }

        String[] numbers = input.split(",");
        double sum = 0.0;

        for (String number : numbers) {
            sum += Double.parseDouble(number);
        }

        return Double.toString(sum);
    }
}
