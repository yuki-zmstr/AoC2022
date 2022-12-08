import java.io.*;
import java.util.*;

public class Day7 {
    public static void main(String args[]) throws FileNotFoundException {

        // creating File instance to reference text file in Java
        File text = new File("/Users/yukihidetakahashi/Desktop/AoC2022/in.txt");

        // Creating Scanner instance to read File in Java
        Scanner scnr = new Scanner(text);
        // Reading each line of the file using Scanner class
        String[] line;

        // have to sort by depth.
        // start adding from deepest one.

        Stack<String> parents = new Stack<String>();
        parents.push("/");
        HashMap<String, Integer> sizes = new HashMap<String, Integer>();
        sizes.put("/", 0);
        HashMap<String, ArrayList<String>> dirs = new HashMap<String, ArrayList<String>>();
        dirs.put("/", new ArrayList<String>());
        HashMap<Integer, ArrayList<String>> depth = new HashMap<Integer, ArrayList<String>>();
        depth.put(0, new ArrayList<String>());
        depth.get(0).add("/");
        int counter = 1;
        while (scnr.hasNextLine()) {
            line = scnr.nextLine().split(" ");
            if (line[0].equals("$") && line[1].equals("cd")) {
                if (line[2].equals("..")) {
                    counter--;
                    parents.pop();
                } else {
                    counter++;
                    if (depth.containsKey(counter)) {
                        // depth.get(counter).add(line[2]);
                    } else {
                        depth.put(counter, new ArrayList<String>());
                        // depth.get(counter).add(line[2]);
                    }
                    sizes.put(line[2], 0);
                    parents.push(line[2]);
                    dirs.put(line[2], new ArrayList<String>());
                }
            } else if (line[0].equals("$") && line[1].equals("ls")) {
                // do nothing.
            } else {
                if (line[0].equals("dir")) {
                    if (depth.containsKey(counter)) {
                        depth.get(counter).add(line[1]);
                    } else {
                        depth.put(counter, new ArrayList<String>());
                        depth.get(counter).add(line[1]);
                    }
                    dirs.get(parents.peek()).add(line[1]);
                } else {
                    sizes.put(parents.peek(), sizes.get(parents.peek()) + Integer.parseInt(line[0]));
                }
            }
            System.out.println(counter);
            System.out.println(sizes.toString());
            System.out.println(parents);
            System.out.println(depth);
            System.out.println(dirs);
            System.out.println();
        }

        int count = depth.size() - 1;

        while (count >= 0) {
            ArrayList<String> to_add = depth.get(count);
            if (to_add == null) {
                count--;
                continue;
            }
            for (String item : to_add) {
                ArrayList<String> to_add2 = dirs.get(item);
                if (to_add2 == null) {
                    continue;
                }
                for (String it : to_add2) {
                    if (sizes.containsKey(it)) {
                        sizes.put(item, sizes.get(item) + sizes.get(it));
                    }
                }
            }
            count--;
        }
        System.out.println(sizes);

        int sum = 0;
        for (Map.Entry<String, Integer> entry : sizes.entrySet()) {
            if (entry.getValue() <= 100000) {
                sum += entry.getValue();
            }
        }
        System.out.println(sum);
    }

}
