import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;
//this file will be used to store components to the MVC until they are ready to be used

public class Locker {
    public static void main(String[] args) {


        //encrypts a message with the XOR method
        String mess = JOptionPane.showInputDialog(null, "Skriv");
        String finish ="";
        int key = '¤';
        String binaryKey = Integer.toBinaryString(key);
        for(int i = 0; i < mess.length(); i++){
            if (mess.charAt(i) == ' '){
                finish += mess.charAt(i);
            }
            else{
            String binaryMess = Integer.toBinaryString(mess.charAt(i));
            int binaryintMess = parseInt(binaryMess,2);
            int binaryintKey = parseInt(binaryKey,2);
            int xorTeck = binaryintMess^binaryintKey;
            finish += (char)xorTeck;
            }
        }

        //creating a file and writing in it
    try {
        FileWriter printer = new FileWriter("encrypted.txt");
        printer.write(finish);
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

    }
}