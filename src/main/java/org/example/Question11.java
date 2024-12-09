package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Name: Adil, Callum and Alex
 * Class Group: SD2A
 */
public class Question11 {

//TODO ALGORITHM OF Q11
//    The algorithm now proceeds as follows:
//    Let "from" be the starting point.
//    Add DistanceTo(from, 0) to a priority queue.
//    Construct a map shortestKnownDistance from city names to distances.
//    While the priority queue is not empty
//    Get its smallest element.
//    If its target is not a key in shortestKnownDistance
//    Let d be the distance to that target.
//    Put (target, d) into shortestKnownDistance.
//    For all cities c that have a direct connection from target
//    Add DistanceTo(c, d + distance from target to c) to the priority queue.


    public static void main(String[] args) throws FileNotFoundException {
        // Define the filename for the input data
        String file = "CitiesDistances.txt";

        //It Reads the input file and store the lines in a list
        List<String> lines = readFile(file);

        //  Extract the "From" city from the first line
        //The split() method splits a string into an array of substrings
        // using a regular expression as the separator.
        String from = lines.get(0).split(" ")[0];

        //  Create a map to represent the graph:
        //    - Keys: Cities(String)
        //    - Values: Maps of neighboring cities and their distances(TreeSet<DistanceTo>)
        Map<String, TreeSet<DistanceTo>> NetofCity = new HashMap<>();

        // Build the graph by iterating through the input lines
        for (String line : lines) {
            // 6. Split each line into city1, city2, and distance
            String[] elements = line.split(" ");
            String city1 = elements[0];
            String city2 = elements[1];
            int distance = Integer.parseInt(elements[2]);
            //parseInt Converts String into Integer

            // Add connections to the graph (undirected graph)
            NetofCity.putIfAbsent(city1, new TreeSet<>());//This line checks if the city1 already exists as a key in the NetofCity map.
            // If city1 does not exist, it adds a new entry to the map with city1 as the key and a new TreeSet<DistanceTo> as the value.
            NetofCity.get(city1).add(new DistanceTo(city2, distance));

            NetofCity.putIfAbsent(city2, new TreeSet<>());
            NetofCity.get(city2).add(new DistanceTo(city1, distance));

//
        }

        //  Initialize Dijkstra's algorithm
        PriorityQueue<DistanceTo> queue = new PriorityQueue<>();
        queue.add(new DistanceTo(from, 0)); // Add starting city to the queue with distance 0
        Map<String, Integer> shortestDistance = new HashMap<>();

        //  Dijkstra's algorithm: Find the shortest paths to all cities
        while (!queue.isEmpty()) {
            // Extract the city with the shortest distance from the queue
            DistanceTo current = queue.poll();//.poll() = This method returns the element at the front of the container or the head of the Queue.
            // It returns null when the Queue is empty
            String target = current.getTarget();
            int distance = current.getDistance();

            //  If the shortest distance to this city is not already known
            if (!shortestDistance.containsKey(target)) {
                //  Record the shortest distance to this city
                shortestDistance.put(target, distance);

                //  Explore neighbors of the current city
                if (NetofCity.containsKey(target)) {
                    for (DistanceTo neighbor : NetofCity.get(target)) {
                        // If the shortest distance to the neighbor is not yet known
                        if (!shortestDistance.containsKey(neighbor.getTarget())) {
                            // Calculate tentative distance to the neighbor
                            queue.add(new DistanceTo(neighbor.getTarget(), distance + neighbor.getDistance()));
                        }
                    }
                }
            }
        }

        // Prints the calculated shortest distances from the "FROM" = first city of first line
        //in the file
        System.out.println("Cheapest distances from " + from + " TO all cities");
        for (Map.Entry<String, Integer> entry : shortestDistance.entrySet()) {
            String city = entry.getKey();//KEY IN MAP IS THE CITY
            int distance = entry.getValue();// VALUE IN MAP IS THE DISTANCE
            System.out.printf(from+" TO "+city+" = " +distance+"\n");
        }
    }//READFILE METHOD

    // Class to read the input file
    public static List<String> readFile(String filename) throws FileNotFoundException {
        File inputFile = new File(filename);
        List<String> lines = new ArrayList<>();
        try (Scanner sc = new Scanner(inputFile)) {
            while (sc.hasNextLine()) {
                lines.add(sc.nextLine().trim());
            }
        }
        return lines;
    }
}