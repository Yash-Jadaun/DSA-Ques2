import java.util.*;

public class DifferentWaysToAddParentheses {

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();

        // Iterate through the expression
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            // If the current character is an operator, split the expression into left and right parts
            if (ch == '+' || ch == '-' || ch == '*') {
                String leftPart = expression.substring(0, i);
                String rightPart = expression.substring(i + 1); // Fix: Use i + 1 instead of i + i

                // Recursively compute the possible results for the left and right parts
                List<Integer> leftResults = diffWaysToCompute(leftPart);
                List<Integer> rightResults = diffWaysToCompute(rightPart);

                // Combine the results using the current operator
                for (int left : leftResults) {
                    for (int right : rightResults) {
                        if (ch == '+') {
                            result.add(left + right);
                        } else if (ch == '-') {
                            result.add(left - right);
                        } else if (ch == '*') {
                            result.add(left * right);
                        }
                    }
                }
            }
        }

        // If the expression contains no operators, it means it's a single number
        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }

        return result;
    }

    public static void main(String[] args) {
        DifferentWaysToAddParentheses solution = new DifferentWaysToAddParentheses(); // Create an instance of the class
        String expression = "2-1-2";
        List<Integer> result = solution.diffWaysToCompute(expression); // Call the method using the instance
        System.out.println(result); // Output: [-1, 1]
    }
}