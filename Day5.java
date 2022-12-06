import java.io.*;
import java.util.*;

public class Day5 {

    public static void main(String args[]) throws FileNotFoundException {

        // creating File instance to reference text file in Java
        File text = new File("/Users/yukihidetakahashi/Desktop/AoC2022/in.txt");

        // Creating Scanner instance to read File in Java
        Scanner scnr = new Scanner(text);
        String[] line;
        // Reading each line of the file using Scanner class

        int number, from, to;
        String popped;
        ArrayList<ArrayList<String>> cargos = new ArrayList<ArrayList<String>>();
        ArrayList<String> one = new ArrayList<String>(Arrays.asList("D", "B", "J",
                "V"));
        ArrayList<String> two = new ArrayList<String>(Arrays.asList("P", "V", "B",
                "W", "R", "D", "F"));
        ArrayList<String> three = new ArrayList<String>(Arrays.asList("R", "G", "F",
                "L", "D", "C", "W", "Q"));
        ArrayList<String> four = new ArrayList<String>(Arrays.asList("W", "J", "P",
                "M", "L", "N", "D", "B"));
        ArrayList<String> five = new ArrayList<String>(Arrays.asList("H", "N", "B",
                "P", "C", "S", "Q"));
        ArrayList<String> six = new ArrayList<String>(Arrays.asList("R", "D", "B",
                "S", "N", "G"));
        ArrayList<String> seven = new ArrayList<String>(Arrays.asList("Z", "B", "P",
                "M", "Q", "F", "S", "H"));
        ArrayList<String> eight = new ArrayList<String>(Arrays.asList("W", "L",
                "F"));
        ArrayList<String> nine = new ArrayList<String>(Arrays.asList("S", "V", "F",
                "M", "R"));
        // ArrayList<String> one = new ArrayList<String>(Arrays.asList("N", "Z"));
        // ArrayList<String> two = new ArrayList<String>(Arrays.asList("M", "C", "D"));
        // ArrayList<String> three = new ArrayList<String>(Arrays.asList("P"));
        cargos.add(one);
        cargos.add(two);
        cargos.add(three);
        cargos.add(four);
        cargos.add(five);
        cargos.add(six);
        cargos.add(seven);
        cargos.add(eight);
        cargos.add(nine);
        System.out.println(cargos.toString());
        // array of string builders.
        while (scnr.hasNextLine()) {
            line = scnr.nextLine().split(" ");
            number = Integer.parseInt(line[1]);
            from = Integer.parseInt(line[3]);
            to = Integer.parseInt(line[5]);
            ArrayList<String> to_move = new ArrayList<>();
            for (int i = 1; i <= number; i++) {
                // cargos.get(to - 1).add(cargos.get(from - 1).remove(cargos.get(from -
                // 1).size() - 1));
                to_move.add(cargos.get(from - 1).remove(cargos.get(from - 1).size() - 1));
            }
            Collections.reverse(to_move);
            cargos.get(to - 1).addAll(to_move);
            to_move.clear();

        }
        System.out.println(cargos);
    }

}
