import javax.swing.*;

import static java.lang.Integer.parseInt;

//Arbetar med programmet
public class Model {
    public  void CryptModel(){
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
    }
}
