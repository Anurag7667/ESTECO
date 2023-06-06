import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the numbers separated by comma: ");
        String input = scanner.nextLine();

        String result = add(input.split(","));
        System.out.println("Sum: " + result);
    }

    public static String add(String... numbers) {
        if (numbers.length == 0) {
            return "0";
        }

        double sum = 0.0;

        for (String number : numbers) {
            sum += Double.parseDouble(number);
        }

        return Double.toString(sum);
    }
}
