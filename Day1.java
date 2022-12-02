import java.io.*;
import java.util.*;

public class Day1 {

    public static void main(String args[]) throws FileNotFoundException {

        // creating File instance to reference text file in Java
        File text = new File("/Users/yukihidetakahashi/Desktop/AoC 2022/in.txt");

        // Creating Scanner instance to read File in Java
        Scanner scnr = new Scanner(text);

        List<Integer> list = new ArrayList<Integer>();
        int sum = 0;

        // Reading each line of the file using Scanner class
        while (scnr.hasNextLine()) {
            String line = scnr.nextLine();
            if (line.isEmpty()) {
                list.add(sum);
                sum = 0;
            } else {
                sum += Integer.parseInt(line);
            }
        }
        list.add(sum);
        Collections.sort(list);
        list = list.subList(list.size() - 3, list.size());
        System.out.println(list);
    }
}
