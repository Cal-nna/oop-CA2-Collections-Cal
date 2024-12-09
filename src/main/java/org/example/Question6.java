package org.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 *  Name: Adil Manzoor
 *  Class Group: SD2A
 */
public class Question6 {


    private static Queue<String> takeoffQueue = new LinkedList<>();
    private static Queue<String> landingQueue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            System.out.print("Enter command (takeoff, land, next, quit): ");
            command = scanner.nextLine();

            switch (command) {
                case "takeoff":
                    System.out.print("Enter flight code: ");
                    String takeoffFlight = scanner.nextLine();
                    takeoffQueue.offer(takeoffFlight);
                    break;
                case "land":
                    System.out.print("Enter flight code: ");
                    String landingFlight = scanner.nextLine();
                    landingQueue.offer(landingFlight);
                    break;
                case "next":
                    processNextFlight();
                    break;
                case "quit":
                    System.out.println("Exiting simulation...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }
    }

    private static void processNextFlight() {
        if (!landingQueue.isEmpty()) {
            String landingFlight = landingQueue.poll();
            System.out.println("Landing: " + landingFlight);
        } else if (!takeoffQueue.isEmpty()) {
            String takeoffFlight = takeoffQueue.poll();
            System.out.println("Taking off: " + takeoffFlight);
        } else {
            System.out.println("No flights waiting.");
        }
    }
}