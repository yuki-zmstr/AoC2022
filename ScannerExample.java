import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * Java program to read files using Scanner class in Java.
 * java.util.Scanner is added on Java 5 and offers a convenient method to read
 * data
 *
 * @author
 */
public class ScannerExample {

    public static void main(String args[]) throws FileNotFoundException {

        // creating File instance to reference text file in Java
        File text = new File("/Users/yukihidetakahashi/Desktop/AoC 2022/in.txt");

        // Creating Scanner instance to read File in Java
        Scanner scnr = new Scanner(text);

        // Reading each line of the file using Scanner class
        int lineNumber = 1;
        while (scnr.hasNextLine()) {
            String line = scnr.nextLine();
            System.out.println("line " + lineNumber + " :" + line);
            lineNumber++;
        }

    }

}