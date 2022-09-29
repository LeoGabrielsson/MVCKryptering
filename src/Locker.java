import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
//this document will be used to store components to the MVC until they are ready to be used

public class Locker {
    public static void main(String[] args) {
        //creating a file and writing in it
    try {
        FileWriter printer = new FileWriter("encrypted.txt");
        printer.write("It will be done sire.");
        printer.close();
        System.out.println("File made and/or updated.");
    } catch (
    IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
    //reading the file
        try {
            File myObj = new File("encrypted.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
}}