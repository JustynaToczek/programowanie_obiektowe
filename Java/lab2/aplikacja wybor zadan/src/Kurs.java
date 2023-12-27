import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Kurs extends JFrame{
    private JPanel panel1;
    private JCheckBox option1;
    private JCheckBox option2;
    private JCheckBox option3;
    private JCheckBox option4;
    private JButton OKButton;
    private JButton powrótButton;

    public static void main(String[] args) {
        Kurs kurs = new Kurs();
        kurs.setVisible(true);
    }
    public Kurs() {
        super("Wybór kursu");
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,300);


        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float cena = 0;
                String msg = "";
                if(option1.isSelected()) {
                    cena += 3500;
                    msg += "Java #price 3500 PLN\n";
                }
                if(option2.isSelected()) {
                    cena += 3000;
                    msg += "C# #price 3000 PLN\n";
                }
                if(option3.isSelected()) {
                    cena += 4000;
                    msg += "C++ #price 4000 PLN\n";
                }
                if(option4.isSelected()) {
                    cena += 5000;
                    msg += "Python #price 5000 PLN\n";
                }
                msg += "======================================\n";

                JOptionPane.showMessageDialog(null,msg+"Razem: "+cena);
            }
        });
        powrótButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                WyborZadan wybor = new WyborZadan();
                wybor.setVisible(true);
            }
        });
    }
}


