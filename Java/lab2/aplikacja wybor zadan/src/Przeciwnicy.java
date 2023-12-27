import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Przeciwnicy extends JFrame {
    private JPanel panel1;
    private JCheckBox wrozkaCheckBox;
    private JCheckBox lordCheckBox;
    private JCheckBox ksiazeCheckBox;
    private JCheckBox kapitanCheckBox;
    private JButton okButton;
    private JButton powrotButton;


    public static void main(String[] args) {
        Przeciwnicy przeciwnicy = new Przeciwnicy();
        przeciwnicy.setVisible(true);
    }

    public Przeciwnicy() {
        super("Wybierz wrogów");
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = "";
                int reward = 0;

                if(lordCheckBox.isSelected()) {
                    message += "Lord Farquaard (reward 200$)\n";
                    reward += 200;
                }
                if(wrozkaCheckBox.isSelected()) {
                    message += "Wróżka Chrzestna (reward 400$)\n";
                    reward += 400;
                }
                if(ksiazeCheckBox.isSelected()) {
                    message += "Książę z Bajki (reward 350$)\n";
                    reward += 350;
                }
                if(kapitanCheckBox.isSelected()) {
                    message += "Kapitan Hak (reward 150$)\n";
                    reward += 150;
                }
                message += "-------------------------------------------\n";

                JOptionPane.showMessageDialog(Przeciwnicy.this,"Wybrano wrogów:\n"+message+"Jeśli wygrasz, zdobędziesz "+reward+"$");
            }
        });
        powrotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                WyborZadan wybor = new WyborZadan();
                wybor.setVisible(true);
            }
        });
    }
}
