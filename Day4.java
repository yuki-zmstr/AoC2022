import java.io.*;
import java.rmi.StubNotFoundException;
import java.util.*;

public class Day4 {

    public static void main(String args[]) throws FileNotFoundException {

        // creating File instance to reference text file in Java
        File text = new File("/Users/yukihidetakahashi/Desktop/AoC2022/in.txt");

        // Creating Scanner instance to read File in Java
        Scanner scnr = new Scanner(text);

        String line;
        String[] arr;

        int sum = 0;
        // Reading each line of the file using Scanner class
        while (scnr.hasNextLine()) {
            line = scnr.nextLine();
            arr = line.split(",");
            // if (check(arr[0], arr[1]) && check(arr[1], arr[0])) {
            // sum++;
            // } else if (check(arr[0], arr[1]) || check(arr[1], arr[0])) {
            // sum++;
            // }
            if (!check(arr[0], arr[1])) {
                sum++;
            }
        }
        System.out.println(sum);
    }

    public static boolean check(String a, String b) {
        // check if a contains b
        // check if min a is <= min b and max a >= max b

        // check if a and b overlap
        // if max_a < min_b or min_a > max_b, no overlap
        int min_a = Integer.parseInt(a.split("-")[0]);
        int max_a = Integer.parseInt(a.split("-")[1]);
        int min_b = Integer.parseInt(b.split("-")[0]);
        int max_b = Integer.parseInt(b.split("-")[1]);
        if (max_a < min_b || min_a > max_b) {
            System.out.println("false");
            return true;
        }
        System.out.println("true");
        return false;
    }

}
