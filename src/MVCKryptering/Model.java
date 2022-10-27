package MVCKryptering;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//Arbetar med programmet
public class Model {
    private String mess = "";
    private String key = "";
    private String finish = "";

    public void setMess(String mess) {
        this.mess = mess;
    }
    public String getMess(){
        return mess;
    }

    public void setKey(String key) {
        this.key = key;
    }
    public String getKey(){
        return key;
    }

    public String getFinish() {
        return finish;
    }

    public void cryptingPart() {
        String result = "";
        while (key.length() < mess.length()) {
            key = biggaKey(key);
        }
        for (int i = 0 ; i < mess.length() ; i++) {
            result += (char)crypt(mess.charAt(i), key.charAt(i));
        }
        finish = result;
    }

    private int crypt(int m, int k) {
        return m^k;
    }

    private String biggaKey(String key) {
        return key+key;
    }

    private static String messRead() {
        String messFile = null;
        try {
            File myObj = new File("message.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                messFile = myReader.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return messFile;
    }
    private void filePart() {
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

    public static void main(String[] args) {
        //String m = JOptionPane.showInputDialog(null, "Text");
        String k = JOptionPane.showInputDialog(null, "Nyckel");
        String m = messRead();
        Model cryptModel = new Model();
        cryptModel.setMess(m);
        cryptModel.setKey(k);
        cryptModel.cryptingPart();
        cryptModel.filePart();
    }
}