import java.io.*;
import java.rmi.StubNotFoundException;
import java.util.*;

public class Day2 {

    public static void main(String args[]) throws FileNotFoundException {

        // creating File instance to reference text file in Java
        File text = new File("/Users/yukihidetakahashi/Desktop/AoC 2022/in.txt");

        // Creating Scanner instance to read File in Java
        Scanner scnr = new Scanner(text);

        String[] arr;
        String first, second;

        int sum = 0;

        // Reading each line of the file using Scanner class
        while (scnr.hasNextLine()) {
            String line = scnr.nextLine();
            arr = line.split(" ");
            first = arr[0];
            second = arr[1];
            if (first.equals("A")) {
                if (second.equals("X")) {
                    sum += 3;
                } else if (second.equals("Y")) {
                    sum += 4;
                } else {
                    sum += 8;
                }
            } else if (first.equals("B")) {
                if (second.equals("X")) {
                    sum += 1;
                } else if (second.equals("Y")) {
                    sum += 5;
                } else {
                    sum += 9;
                }
            } else {
                if (second.equals("X")) {
                    sum += 2;
                } else if (second.equals("Y")) {
                    sum += 6;
                } else {
                    sum += 7;
                }
            }
        }
        System.out.println(sum);
    }
}
