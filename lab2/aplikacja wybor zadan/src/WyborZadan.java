import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WyborZadan extends JFrame {
    private JPanel panel1;
    private JRadioButton wyborSystemuOperacyjnegoRadioButton;
    private JRadioButton wyborKursuProgramowaniaRadioButton;
    private JRadioButton zadanieLab1RadioButton;
    private JButton okButton;
    private JRadioButton zadanieLab2GraShrekRadioButton;
    private JButton wylogujButton;

    public static void main(String[] args) {
        WyborZadan wybor = new WyborZadan();
        wybor.setVisible(true);
    }

    public WyborZadan() {
        super("Wybierz jedną z opcji");
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        wylogujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Logowanie logowanie = new Logowanie();
                logowanie.setVisible(true);
            }
        });
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(wyborSystemuOperacyjnegoRadioButton.isSelected()) {
                    dispose();
                    SystemOperacyjnyWybor wyborSysOp = new SystemOperacyjnyWybor();
                    wyborSysOp.setVisible(true);
                }
                if(wyborKursuProgramowaniaRadioButton.isSelected()) {
                    dispose();
                    Kurs kurs = new Kurs();
                    kurs.setVisible(true);
                }
                if(zadanieLab1RadioButton.isSelected()) {
                    dispose();
                    Zgadywanka zgadywanka = new Zgadywanka();
                    zgadywanka.setVisible(true);
                }
                if(zadanieLab2GraShrekRadioButton.isSelected()) {
                    dispose();
                    Avatar avatar = new Avatar();
                    avatar.setVisible(true);
                }
            }
        });
    }
}
