package org.example;

import java.io.*;
import java.util.*;
import java.util.regex.*;

/**
 *  Name:
 *  Class Group:
 */
public class Question5 {    //Java Identifier Count (Map)

    public static void readFile(String fileName)
    {
        Map<String, Integer> identiferCountMap = new TreeMap<>();
        Map<String, List<String>> identiferLineMap = new HashMap<>();

        Pattern identifierPattern = Pattern.compile("\\b[A-Za-z_][A-Za-z0-9_]*\\b");

        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line = null;
            int lineNumber = 0;

            while((line = reader.readLine()) !=null){
                lineNumber ++;
                Matcher matcher = identifierPattern.matcher(line);
                while(matcher.find()){
                    String identifer = matcher.group();

                    identiferCountMap.put(identifer, identiferCountMap.getOrDefault(identifer, 0) + 1);

                    identiferLineMap.putIfAbsent(identifer, new ArrayList<>());
                    identiferLineMap.get(identifer).add(lineNumber + " ");
                }
            }
        }catch(IOException e){
            System.out.println("Error reading file"+ fileName);
            return;
        }

        System.out.println("Identifiers, their counts, lines of code: ");
        for(String identifer : identiferCountMap.keySet()){
            System.out.println("\nIdentifier: "+identifer + " \nCount: " + identiferCountMap.get(identifer)+ " \nLine:" + identiferLineMap.get(identifer));
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        readFile("C:\\Users\\AGBro\\IdeaProjects\\oop-CA2-Collections-STARTER-Nov24\\src\\main\\java\\org\\example\\Question2.java");
    }
}
