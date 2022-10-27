package MVCKryptering;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Sköter programmet
public class Controller extends JFrame {
    Model model;
    View view;
    public Controller(Model m, View v) {
        this.model = m;
        this.view = v;
        this.setContentPane(view.getPanel());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        view.setCryptListener(new cryptListener());
    }
    private class cryptListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model.setMess(view.getTxt());
            model.setKey(view.getKey());
            model.cryptingPart();
            view.setCrypt(model.getFinish());
        }
    }
    public static void main(String[] args) {
        Model m = new Model();
        View v = new View();
        Controller thisIsTheProgram = new Controller(m,v);
        thisIsTheProgram.setVisible(true);

        }
    }