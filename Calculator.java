import java.util.Scanner;

public class Calculator {


    int add(int a, int b) {
        return a + b;
    }

    int sub(int a, int b) {
        return a - b;
    }

    int mul(int a, int b) {
        return a * b;
    }

    int div(int a, int b) {
        try {
            if (b == 0) {
                System.out.println("На нуль ділити не можна!");
            }
        } catch (ArithmeticException e) {
            e.getMessage();
        }
        return a / b;
    }
}

class CalculatorMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть перше число: ");
        int firstNumber = sc.nextInt();
        System.out.println("Введіть друге число: ");
        int secondNumber = sc.nextInt();
        System.out.println("Введіть знак арифметичної операції +, -, *, /");
        String arithmeticSign = sc.next();
        sc.close();
        Calculator calculator = new Calculator();
        if (arithmeticSign.equals("+")) {
            System.out.print(firstNumber + " + " + secondNumber + " = ");
            System.out.println(calculator.add(firstNumber, secondNumber));
        } else if (arithmeticSign.equals("-")) {
            System.out.print(firstNumber + " - " + secondNumber + " = ");
            System.out.println(calculator.sub(firstNumber, secondNumber));
        } else if (arithmeticSign.equals("*")) {
            System.out.print(firstNumber + " * " + secondNumber + " = ");
            System.out.println(calculator.mul(firstNumber, secondNumber));
        } else if (arithmeticSign.equals("/")) {
            try {
                System.out.println(firstNumber + " / " + secondNumber + " = ");
                System.out.println(calculator.div(firstNumber, secondNumber));
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }


        }
    }
}
