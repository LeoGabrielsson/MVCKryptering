package MVCKryptering;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Kommunicerar med användaren och programmet
public class View {
    private JPanel panel;
    private JTextField txt;
    private JTextField key;
    private JTextField crypt;
    private JButton cryptButton;

    public View() {

    }

    public JPanel getPanel() {
        return panel;
    }

    public String getTxt() {
        return txt.getText();
    }

    public String getKey() {
        return key.getText();
    }

    public void setCrypt(String c) {
        crypt.setText(c);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("View");
        frame.setContentPane(new View().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void setCryptListener(ActionListener cryptListener) {
        cryptButton.addActionListener(cryptListener);
    }
}
