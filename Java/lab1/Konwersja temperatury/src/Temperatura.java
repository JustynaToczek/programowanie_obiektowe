import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Temperatura extends JFrame{
    private JPanel panel1;
    private JTextField JTextWpisz;
    private JButton konwertujButton;
    private JLabel JLabelWynik;

    private double valueIn, valueOut;

    public static void main(String[] args) {
         Temperatura object1 = new Temperatura();
         object1.setVisible(true);
    }

    public Temperatura() {
        super("Konwerter temperatury");
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int width = 400, height=200;
        this.setSize(width,height);
        konwertujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valueIn = Double.parseDouble(JTextWpisz.getText());
                valueOut = valueIn * 9/5 + 32;
                JLabelWynik.setText(String.valueOf(valueOut));
            }
        });
    }
}
