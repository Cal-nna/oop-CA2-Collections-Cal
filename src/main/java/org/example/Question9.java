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
        System.out.println("Please enter equation");
        equation = in.nextLine().trim();

        Stack<Integer> stack = new Stack<>();

        char plus = '+';
        char minus = '-';
        char multiply = '*';
        char division = '/';


        for (int i = 0; i < equation.length(); i++) {

            //check
            if (equation.charAt(i) != plus && equation.charAt(i) != minus &&
                    equation.charAt(i) != multiply && equation.charAt(i) != division)
            {  // we have a number, so push to stack
                int num = (equation.charAt(i)-'0');
                //NUMBERS ARE PUSHED IN STACK
                stack.push(num);

            } else  // else, it is not a number, assume operator, ...
                if (equation.charAt(i) == plus) {
                    stack.push(stack.pop() + stack.pop()); //ADD

                } else if (equation.charAt(i) == minus) {
                    stack.push(stack.pop() - stack.pop()); //SUBTRACT

                } else if (equation.charAt(i) == multiply) {
                    stack.push(stack.pop() * stack.pop()); // MULTIPLY

                } else if (equation.charAt(i) == division) {
                    stack.push(stack.pop() / stack.pop()); // DIVISION

                }
        }
        System.out.println("_________________________________");
        System.out.println("FINAL ANSWER " + stack.pop());


    }
}