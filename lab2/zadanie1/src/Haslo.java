import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Haslo extends JFrame {
    private JPanel panel1;
    private JButton button1;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JButton OKbutton;

    private String haslo = "codejava";


    public static void main(String[] args) {
        Haslo haslo = new Haslo();
        haslo.setVisible(true);
    }

    public Haslo() {
        super("Swing JPasswordField Demo Program");
        this.setContentPane(panel1);
        this.setSize(350,200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        OKbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userPassword1 = new String(passwordField1.getPassword());
                String userPassword2 = new String(passwordField2.getPassword());
                boolean arePasswordsEqual = userPassword1.equals(userPassword2);

                if(arePasswordsEqual && (userPassword1.equals(haslo)))
                    JOptionPane.showMessageDialog(Haslo.this, "Congratulations! You entered correct password!");
                else if(userPassword1.equalsIgnoreCase(userPassword2) || userPassword1.length() == userPassword2.length() && (!arePasswordsEqual))
                    JOptionPane.showMessageDialog(Haslo.this, "Wrong password!");
                else JOptionPane.showMessageDialog(Haslo.this, "Passwords are not matched!");
            }
        });

    }
}
