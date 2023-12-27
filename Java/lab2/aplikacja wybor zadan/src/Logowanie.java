import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Logowanie extends JFrame {
    private JPanel panel1;
    private JTextField loginField;
    private JPasswordField passwordField;
    private JButton zalogujButton;
    private JButton wyjscieButton;
    private final String pass = "admin"; //login i haslo

    public static void main(String[] args) {
        Logowanie logowanie = new Logowanie();
        logowanie.setVisible(true);
    }

    public Logowanie() {
        super("zaloguj się");
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,200);

        zalogujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userLogin = loginField.getText();
                String userPassword = new String(passwordField.getPassword());

                if((!userLogin.equals(pass)) || (!userPassword.equals(pass)))
                    JOptionPane.showMessageDialog(Logowanie.this,"Nieprawidłowy login lub hasło!");
                else if(userLogin.equals(pass) && userPassword.equals(pass)) {
                    JOptionPane.showMessageDialog(Logowanie.this,"Poprawnie zalogowano!");
                    dispose();
                    WyborZadan wyborZadan = new WyborZadan();
                    wyborZadan.setVisible(true);
                }
            }
        });
    }
}
