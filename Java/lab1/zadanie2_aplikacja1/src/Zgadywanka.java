import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Zgadywanka extends JFrame{
    private JPanel panel1;
    private JTextField textWpisz;
    private JButton sprawdzButton;
    private JButton wyjscieButton;
    private JButton zmienButton;
    private JLabel sprawdzField;

    private int randomNumer;

    private double valueIn;

    public static void main(String[] args) {
        Zgadywanka gra = new Zgadywanka();
        gra.setVisible(true);
    }
    public Zgadywanka() {
        super("Zgadnij liczbę");
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int width = 500, height = 250;
        this.setSize(width,height);


        //generowanie losowej liczby z wybranego zakresu
        Random random = new Random();
        randomNumer = random.nextInt(1,5);


        sprawdzButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valueIn = Double.parseDouble(textWpisz.getText());
                if(valueIn==randomNumer) sprawdzField.setText("Brawo! Liczba o której myślę to: " + String.valueOf(randomNumer));
                else sprawdzField.setText("Tym razem się nie udało!\nSpróbuj zgadnąć jeszcze raz");

            }
        });
        zmienButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                randomNumer = random.nextInt(1,5);
                sprawdzField.setText("Liczba została zmieniona, spróbuj zgadywać jeszcze raz!");
            }
        });
        wyjscieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }


}
