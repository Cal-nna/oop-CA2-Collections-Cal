package org.example;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

/**
 *  Name:
 *  Class Group:
 */
public class Question8 { // Shares Tax Calculations (Queue for Multiple Companies)

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

        // Map to hold queues for symbols
        Map<String, Queue<Block>> stockMap = new HashMap<>();
        String command;

        // Display instructions
        System.out.println("Welcome to the Multi-Company Stock Trading Simulator!");
        System.out.println("Commands:");
        System.out.println("  - buy <symbol> <quantity> <price>: To buy shares of a company at a specific price.");
        System.out.println("  - sell <symbol> <quantity> <price>: To sell shares of a company at a specific price.");
        System.out.println("  - quit: To exit the program.");
        System.out.println("Start entering your commands below:");

        do {
            System.out.print("> ");
            command = in.next();

            if (command.equalsIgnoreCase("buy")) {
                // Buy command
                String symbol = in.next();
                int qty = in.nextInt();
                double price = in.nextDouble();

                // create the queue for the stock symbol
                stockMap.putIfAbsent(symbol, new LinkedList<>());
                stockMap.get(symbol).add(new Block(qty, price));

                System.out.println("Bought " + qty + " shares of " + symbol + " at €" + price + " per share.");
            } else if (command.equalsIgnoreCase("sell")) {
                // Sell command
                String symbol = in.next();
                int qtyToSell = in.nextInt();
                double sellPrice = in.nextDouble();

                // Check if the stock exists
                if (!stockMap.containsKey(symbol) || stockMap.get(symbol).isEmpty()) {
                    System.out.println("You don't own any shares of " + symbol + ".");
                    continue;
                }

                Queue<Block> queue = stockMap.get(symbol);
                double totalGain = 0.0;

                // Process the sale using FIFO logic
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
                    System.out.println("Not enough shares of " + symbol + " to sell!");
                }
                System.out.printf("Sold shares of %s. Total gain: €%.2f%n", symbol, totalGain);

                // Remove empty queues
                if (queue.isEmpty()) {
                    stockMap.remove(symbol);
                }
            } else if (!command.equalsIgnoreCase("quit")) {
                // Handle invalid command
                System.out.println("Invalid command. Use 'buy', 'sell', or 'quit'.");
            }
        } while (!command.equalsIgnoreCase("quit"));

        System.out.println("Goodbye! Thank you for using the Multi-Company Stock Trading Simulator.");
        in.close();
    }
}
