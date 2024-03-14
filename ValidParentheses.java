import java.util.Scanner;
import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String expression) {
        Stack<Character> stack = new Stack<>();
        char[] chars = expression.toCharArray();

        for (char ch : chars) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty() || !matches(stack.pop(), ch)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private static boolean matches(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the string of parentheses: ");
        String input = scanner.nextLine();

        if (isValid(input)) {
            System.out.println("The expression is valid");
        } else {
            System.out.println("The expression is not valid");
        }

        scanner.close();
    }
}

