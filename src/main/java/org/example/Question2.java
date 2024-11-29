package org.example;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * Name:
 * Class Group:
 */
public class Question2  // Car Parking - Stack
{
    public static void runSimulation() {
        Deque<Integer> driveway = new ArrayDeque<>();
        Deque<Integer> street = new ArrayDeque<>();

        Scanner sc = new Scanner(System.in);
        System.out.println(" ** Enter Positive numbers to add cars: \n ** Enter Negative numbers to remove cars: \n ** Enter 0 to Stop: ");

        while (true) {
            System.out.println("Your Input: ");
            if (!sc.hasNextInt()) {
                System.out.println("please enter a valid input");
                sc.next();
                continue;
            }

            int input = sc.nextInt();

            if (input == 0) {
                System.out.println("Simulation Stopped...");
                break;
            } else if (input > 0) {
                driveway.push(input);
                System.out.println("Car " + input + " Added to Driveway ");
            } else {
                int carToRemove = -input;
                if (driveway.isEmpty()) {
                    System.out.println("Driveway is Empty. Cannot remove car.");
                    continue;
                }
                boolean found = false;

                System.out.println("Moving cars to the street: ");
                while (!driveway.isEmpty()) {
                    int topCar = driveway.pop();
                    if (topCar == carToRemove) {
                        System.out.println("Car " + carToRemove + " removed from Driveway");
                        found = true;
                        break;
                    } else {
                        street.push(topCar);
                        System.out.println(topCar + " ");
                    }
                }
                while (!street.isEmpty()) {
                    driveway.push(street.pop());
                }
                if (!found) {
                    System.out.println("\n Car " + carToRemove + " removed from Driveway");
                }
            }

            System.out.println("Current state of driveway " + driveway);
        }
        sc.close();
    }

    public static void main(String[] args) {
        runSimulation();
    }
}
