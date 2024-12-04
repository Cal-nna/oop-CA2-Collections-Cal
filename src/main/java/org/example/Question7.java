package org.example;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *  Name:
 *  Class Group:
 */
public class Question7 { // Shares Tax Calculations (Queue)

    // Block class to represent a batch of shares
    static class Block {
        int quantity;
        double price;

        public Block(int quantity, double price) {
            this.quantity = quantity;
            this.price = price;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Queue<Block> queue = new LinkedList<>();
        String command;

        // Display instructions
        System.out.println("Welcome to the Stock Trading Simulator!");
        System.out.println("Commands:");
        System.out.println("  - buy <quantity> <price>: To buy shares at a specific price.");
        System.out.println("  - sell <quantity> <price>: To sell shares at a specific price.");
        System.out.println("  - quit: To exit the program.");
        System.out.println("Start entering your commands below:");

        do {
            System.out.print("> ");
            command = in.next();

            if (command.equalsIgnoreCase("buy")) {
                // Buy
                int qty = in.nextInt();
                double price = in.nextDouble();
                queue.add(new Block(qty, price)); // Add a new block to the queue
                System.out.println("Bought " + qty + " shares at $" + price + " per share.");
            } else if (command.equalsIgnoreCase("sell")) {
                // Sell
                int qtyToSell = in.nextInt();
                double sellPrice = in.nextDouble();
                double totalGain = 0.0;

                while (qtyToSell > 0 && !queue.isEmpty()) {
                    Block block = queue.peek(); // Get the first block
                    if (block.quantity <= qtyToSell) {
                        // Sell entire block
                        int soldQty = block.quantity;
                        totalGain += soldQty * (sellPrice - block.price);
                        qtyToSell -= soldQty;
                        queue.poll(); // Remove the block from the queue
                    } else {
                        // Sell part of the block
                        totalGain += qtyToSell * (sellPrice - block.price);
                        block.quantity -= qtyToSell;
                        qtyToSell = 0;
                    }
                }

                if (qtyToSell > 0) {
                    System.out.println("Not enough shares to sell!");
                }
                System.out.printf("Sold shares. Total gain: $%.2f%n", totalGain);
            } else if (!command.equalsIgnoreCase("quit")) {
                // invalid command check
                System.out.println("Invalid command. Use 'buy', 'sell', or 'quit'.");
            }
        } while (!command.equalsIgnoreCase("quit"));

        System.out.println("Goodbye! Thank you for using the Stock Trading Simulator.");
        in.close();
    }
}
