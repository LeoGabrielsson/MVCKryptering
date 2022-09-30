import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.Integer.parseInt;
//this file will be used to store components to the MVC until they are ready to be used

public class Locker {
    public static void main(String[] args) {
        //krypterar ett meddelande med XOR metoden
        int teck = 'd';
        int key = '¤';
        String binaryKey = Integer.toBinaryString(key);
        String binaryTeck = Integer.toBinaryString(teck);
        int IntbinaryTeck = parseInt(binaryTeck,2);
        int IntbinaryKey = parseInt(binaryKey,2);
        int xorTeck = IntbinaryTeck^IntbinaryKey;


        //creating a file and writing in it
    try {
        FileWriter printer = new FileWriter("encrypted.txt");
        printer.write(xorTeck);
        printer.close();
        System.out.println("File made and/or updated.");
    } catch (
    IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }

    //reading said file
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