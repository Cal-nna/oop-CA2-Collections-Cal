package org.example;

import java.util.Scanner;
import java.util.Stack;
/**
 *  Name:
 *  Class Group:
 */
public class Question9 {

    /*
        Reads in an equation from the user
     */
    public static void main(String[] args) {
        String equation;
        Scanner in = new Scanner(System.in);
        //3*4+5
        //3+(4+5)
        System.out.println("ACCEPTABLE FORMAT: n*n+n, n+(n+n)");
        System.out.println("Please enter equation");
        equation = in.nextLine().trim();

        //2 stacks
        Stack<Integer> number_stack = new Stack<>();
        Stack<Character> operator_stack = new Stack<>();

        char plus = '+';
        char minus = '-';
        char multiply = '*';
        char division = '/';
        char parenthesis = '(';
        char parenthesis2 = ')';



        for (int i = 0; i < equation.length(); i++) {

            //check to see if its not a operator
            if (equation.charAt(i) != plus && equation.charAt(i) != minus && equation.charAt(i) != parenthesis2 &&
                    equation.charAt(i) != multiply && equation.charAt(i) != division && equation.charAt(i) != parenthesis) {  // we have a number, so push to stack
                int num = (equation.charAt(i) - '0');
                //NUMBERS ARE PUSHED IN STACK
                number_stack.push(num);
                // else, it is not a number, assume operator, ...
            } else if (equation.charAt(i) == plus || equation.charAt(i) == minus || equation.charAt(i) == parenthesis ||
                    equation.charAt(i) == multiply || equation.charAt(i) == division || equation.charAt(i) == parenthesis2) {
                //push into operator stack
                operator_stack.push(equation.charAt(i));
            }

        }

        System.out.println("OPERATOR STACK: "+operator_stack);
        System.out.println("NUMBER STACK: "+number_stack);


        //ONLY +-*/
        if(operator_stack.size() == 2){
            while(!operator_stack.isEmpty()) {
                //pop both operators in stack
                char operator = operator_stack.pop();//OP 1
                char operator2 = operator_stack.pop();//OP 2

                // X & +
                if(operator == multiply && operator2 == plus) {
                    number_stack.push(number_stack.pop() * number_stack.pop());
                    number_stack.push(number_stack.pop() + number_stack.pop());

                    // + & X
                } else if(operator == plus && operator2 == multiply) {
                    //TOP NUMBER OUT
                    int number1 = number_stack.pop();
                    //MULTIPLY 2 NUMBERS
                    number_stack.push(number_stack.pop() * number_stack.pop());
                    //ADD NUMBER BACK IN STACK
                    number_stack.push(number1);
                    //ADD 2 NUMBERS
                    number_stack.push(number_stack.pop() + number_stack.pop());

                } else if(operator == minus && operator2 == multiply) {
                    int number1 = number_stack.pop();
                    number_stack.push(number_stack.pop() * number_stack.pop());
                    number_stack.push(number1);
                    number_stack.push(number_stack.pop() - number_stack.pop());
                }
            }// END OF WHILE LOOP BRACKET
            System.out.println("_________________________________");
            System.out.println("FINAL ANSWER " + number_stack.pop());

        }

        //() && +-*/
        if(operator_stack.size() == 4){
            while(!operator_stack.isEmpty()) {
                //pop both operators in stack
                char operator = operator_stack.pop();//OP 1 )
                char operator2 = operator_stack.pop();//OP 2 +-*/
                char operator3 = operator_stack.pop();//OP 3 (
                char operator4 = operator_stack.pop();//OP 4 +-*/

                // X & +
                if(operator == parenthesis2) {
                    if (operator2 == plus) {//EVALUATE THE TOP
                        number_stack.push(number_stack.pop() + number_stack.pop());
                    } else if (operator2 == minus) {
                        number_stack.push(number_stack.pop() - number_stack.pop());
                    } else if (operator2 == multiply) {
                        number_stack.push(number_stack.pop() * number_stack.pop());
                    } else if (operator2 == division) {
                        number_stack.push(number_stack.pop() / number_stack.pop());
                    }

                    if (operator4 == plus) {
                        number_stack.push(number_stack.pop() + number_stack.pop());
                    } else if (operator4 == minus) {
                        number_stack.push(number_stack.pop() - number_stack.pop());
                    } else if (operator4 == multiply) {
                        number_stack.push(number_stack.pop() * number_stack.pop());
                    } else if (operator4 == division) {
                        number_stack.push(number_stack.pop() / number_stack.pop());
                    }
                }
            }
        }
        System.out.println("_________________________________");
        System.out.println("FINAL ANSWER " + number_stack.pop());


    }//2LB
}//LB

