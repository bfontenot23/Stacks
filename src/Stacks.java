/*
 * CSC 1351 Lab 9
 *
 * Section 002
 *
 * @author Beau Fontenot
 * @since 04-19-24
 *
 */

import java.util.Stack;

public class Stacks {

    public static boolean isBalancedExpression(String input)
    {
        char[] in = input.toCharArray();
        Stack<Character> queue = new Stack<Character>();
        boolean balanced = true;

        for(char character : in)
        {
            switch(character)
            {
                case '(':
                    queue.push(')');
                    break;
                case '[':
                    queue.push(']');
                    break;
                case '{':
                    queue.push('}');
                    break;
                case ')':
                    if(queue.peek().compareTo(')')==0) queue.pop();
                    else balanced = false;
                    break;
                case ']':
                    if(queue.peek().compareTo(']')==0) queue.pop();
                    else balanced = false;
                    break;
                case '}':
                    if(queue.peek().compareTo('}')==0) queue.pop();
                    else balanced = false;
                    break;
            }
        }
        return balanced;
    }

    public static double evaluateExpression(String expression)
    {
        String[] in = expression.split(" ");
        double op1,op2;
        Stack<String> eval = new Stack<String>();

        for(String symbol : in)
        {
            switch(symbol)
            {
                case "+":
                    op2 = Double.parseDouble(eval.peek());
                    eval.pop();
                    op1 = Double.parseDouble(eval.peek());
                    eval.pop();
                    eval.push(String.valueOf((op1+op2)));
                    break;
                case "-":
                    op2 = Double.parseDouble(eval.peek());;
                    eval.pop();
                    op1 = Double.parseDouble(eval.peek());;
                    eval.pop();
                    eval.push(String.valueOf((op1-op2)));
                    break;
                case "*":
                    op2 = Double.parseDouble(eval.peek());;
                    eval.pop();
                    op1 = Double.parseDouble(eval.peek());;
                    eval.pop();
                    eval.push(String.valueOf((op1*op2)));
                    break;
                case "/":
                    op2 = Double.parseDouble(eval.peek());;
                    eval.pop();
                    op1 = Double.parseDouble(eval.peek());;
                    eval.pop();
                    eval.push(String.valueOf((op1/op2)));
                    break;
                default:
                    eval.push(symbol);
                    break;
            }
        }
        return Double.parseDouble(eval.peek());
    }

    public static void main(String[] args)
    {
        System.out.println(isBalancedExpression("{}"));
        System.out.println(isBalancedExpression("({({)})}"));
        System.out.println(isBalancedExpression("({})"));

        System.out.println(evaluateExpression("5 4 5 * + 5 /"));
        System.out.println(evaluateExpression("4 5 + 7 2 - *"));
    }
}
