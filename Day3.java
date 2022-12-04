import java.io.*;
import java.rmi.StubNotFoundException;
import java.util.*;

public class Day3 {

    public static void main(String args[]) throws FileNotFoundException {

        // creating File instance to reference text file in Java
        File text = new File("/Users/yukihidetakahashi/Desktop/AoC2022/in.txt");

        // Creating Scanner instance to read File in Java
        Scanner scnr = new Scanner(text);

        int sum = 0;
        int counter = 0;

        String compare = "";
        StringBuilder compare2 = new StringBuilder();

        // Reading each line of the file using Scanner class
        while (scnr.hasNextLine()) {
            String line = scnr.nextLine();
            // String firstHalf = line.substring(0, line.length() / 2);
            // for (int i = firstHalf.length(); i < line.length(); i++) {
            // if (firstHalf.contains(Character.toString(line.charAt(i)))) {
            // // System.out.println(priority(line.charAt(i)));
            // sum += priority(line.charAt(i));
            // break;
            // }
            // }
            if (counter % 3 == 0) {
                counter = 1;
                compare = line;
                compare2 = new StringBuilder();
                continue;
            }
            if (counter % 3 == 1) {
                counter = 2;
                for (int i = 0; i < line.length(); i++) {
                    if (compare.contains(Character.toString(line.charAt(i)))) {
                        compare2.append(line.charAt(i));
                    }
                }
                continue;
            }
            if (counter % 3 == 2) {
                counter = 3;
                for (int i = 0; i < line.length(); i++) {
                    if (compare2.toString().contains(Character.toString(line.charAt(i)))) {
                        System.out.println(priority(line.charAt(i)));
                        sum += priority(line.charAt(i));
                        break;

                    }
                }
                // continue;
            }
        }
        System.out.println(sum);
    }

    public static int priority(Character s) {
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return alphabet.indexOf(s) + 1;
    }
}
