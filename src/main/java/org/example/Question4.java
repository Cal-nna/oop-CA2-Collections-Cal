package org.example;

import java.util.Scanner;
import java.util.Stack;

/**
 *  Name: Alex Broccadinho
 *  Class Group: SD2A
 */

public class Question4  // Flood Fill (Stack, 2D Array)
{
    public static void main(String[] args) {
        start();
    }
    public static void start()
    {
        int[][] arr = floodFillStart();

        arr[0][3] = -1;
        arr[1][3] = -1;
        arr[2][5] = -1;
        arr[4][7] = -1;
        arr[4][8] = -1;
        arr[5][3] = -1;
        arr[2][9] = -1;
        arr[7][3] = -1;
        arr[6][0] = -1;
        arr[4][4] = -1;
        arr[9][1] = -1;

        System.out.println("Matrix before flood fill: ");
        display(arr);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the starting Row (0-9): ");
        int StartRow = sc.nextInt();
        System.out.println("Enter the starting Column (0-9): ");
        int StartColumn = sc.nextInt();

        if(StartRow < 0 || StartRow >= arr.length || StartColumn < 0 || StartColumn >= arr[0].length || arr[StartRow][StartColumn] == -1){
            System.out.println("Invalid Starting Position");
            return;
        }

        fill(StartRow, StartColumn, arr);

        System.out.println("Matrix after flood fill: ");
        display(arr);
    }

    /*
        Starter function to create the 2D array and populate it with zeros
     */
    public static int[][]  floodFillStart() {
        Scanner kb = new Scanner(System.in);
        int[][] arr = new int[10][10];
        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 10; y++)
            {
                arr[x][y] = 0;
            }
        }
        return arr;
    }
    /*
        Helper function to display the image
     */
    public static void display(int[][] arr)
    {
        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 10; y++)
            {
                System.out.printf("%4d", arr[x][y]);
            }
            System.out.println();
        }
    }
    private static void fill(int r, int c, int[][] arr)
    {
        Stack<Cell> stack = new Stack<>();
        stack.push(new Cell(r,c));

        int fillValue = 1;

        while(!stack.isEmpty()){
            Cell cell = stack.pop();
            int row = cell.row;
            int col = cell.col;

            if(row < 0 || row >= arr.length || col < 0 || col >= arr[row].length){
                continue;
            }

            if(arr[row][col] == 0) {
                arr[row][col] = fillValue++;
                System.out.println("Filling row " + row + " col " + col);


                stack.push(new Cell(row - 1, col));//North
                stack.push(new Cell(row + 1, col));//South
                stack.push(new Cell(row, col + 1));//East
                stack.push(new Cell(row, col - 1));//West
            }
        }
    }
    static class Cell{
        int row, col;

        Cell(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

}