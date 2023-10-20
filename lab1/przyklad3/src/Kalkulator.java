import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Kalkulator extends JFrame {

    private JPanel panel1;
    private JTextField JTextFieldB;
    private JTextField JTextFiledA;
    private JButton sumaButton;
    private JButton roznicaButton;
    private JButton IloczynButton;
    private JButton ilorazButton;
    private JButton wyjscieButton;
    private JLabel LabelScore;

    private double valueA, valueB, score;

    public static void main(String[] args) {
        Kalkulator obj1 = new Kalkulator();
        obj1.setVisible(true);
    }

    public Kalkulator() {
        super("Kalkulator dwóch liczb");
        this.setContentPane(this.panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int width = 400, height = 300;
        this.setSize(width,height);
        //this.pack();


        sumaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valueA = Double.parseDouble(JTextFiledA.getText());
                valueB = Double.parseDouble(JTextFieldB.getText());
                score = valueA + valueB;
                LabelScore.setText("Suma "+ String.valueOf(valueA) + " + " + String.valueOf(valueB) + " = " + String.valueOf(score));
            }
        });


        wyjscieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        IloczynButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valueA = Double.parseDouble(JTextFiledA.getText());
                valueB = Double.parseDouble(JTextFieldB.getText());
                score = valueA * valueB;
                LabelScore.setText("Iloczyn "+ String.valueOf(valueA) + " * " + String.valueOf(valueB) + " = " + String.valueOf(score));
            }
        });

        roznicaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valueA = Double.parseDouble(JTextFiledA.getText());
                valueB = Double.parseDouble(JTextFieldB.getText());
                score = valueA - valueB;
                LabelScore.setText("Różnica "+ String.valueOf(valueA) + " - " + String.valueOf(valueB) + " = " + String.valueOf(score));
            }
        });

        ilorazButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valueA = Double.parseDouble(JTextFiledA.getText());
                valueB = Double.parseDouble(JTextFieldB.getText());
                if(valueB==0) LabelScore.setText("Nie można dzielić przez 0! Spróbuj jeszcze raz");
                else {
                    score = valueA / valueB;
                    LabelScore.setText("Iloraz " + String.valueOf(valueA) + " / " + String.valueOf(valueB) + " = " + String.valueOf(score));
                }
            }
        });
    }


}
