import java.io.*;
import java.time.format.FormatStyle;
import java.util.*;

public class Day6 {
    public static void main(String args[]) throws FileNotFoundException {

        // creating File instance to reference text file in Java
        File text = new File("/Users/yukihidetakahashi/Desktop/AoC2022/in.txt");

        // Creating Scanner instance to read File in Java
        Scanner scnr = new Scanner(text);
        // Reading each line of the file using Scanner class
        // while (scnr.hasNextLine()) {

        // }

        String line = scnr.nextLine();
        String str;
        for (int i = 0; i < line.length() - 13; i++) {
            str = line.substring(i, i + 14);
            if (check(str)) {
                System.out.println(i + 14);
                return;
            }
        }
    }

    public static boolean check(String s) {
        // check if string s is unique.
        Set<Character> unique = new HashSet<Character>();
        for (char c : s.toCharArray()) {
            unique.add(c);
        }
        if (s.length() == unique.size()) {
            // all unique
            return true;
        }
        return false;
    }

}
