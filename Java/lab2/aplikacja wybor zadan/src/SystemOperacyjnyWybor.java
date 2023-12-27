import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SystemOperacyjnyWybor extends JFrame {
    private JPanel panel1;
    private JRadioButton linuxRadioButton;
    private JRadioButton windowsRadioButton;
    private JRadioButton macRadioButton;
    private JLabel JLabelImage;
    private JButton okButton;
    private JButton powrótButton;

    private ImageIcon iconLinux = new ImageIcon(getClass().getResource("linux.png"));
    private ImageIcon iconWindows = new ImageIcon(getClass().getResource("windows.png"));
    private ImageIcon iconMac = new ImageIcon(getClass().getResource("mac.png"));

    private static ImageIcon resize(ImageIcon src, int destWidth, int destHeight) {
        return new ImageIcon(src.getImage().getScaledInstance(destWidth,destHeight,Image.SCALE_SMOOTH));
    }

    public static void main(String[] args) {
        SystemOperacyjnyWybor wybor = new SystemOperacyjnyWybor();
        wybor.setVisible(true);
    }

    public SystemOperacyjnyWybor() {
        super("Wybierz swój system operacyjny");
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300,300);


        linuxRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(linuxRadioButton.isSelected())
                    JLabelImage.setIcon(resize(iconLinux,120,120));
            }
        });

        windowsRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(windowsRadioButton.isSelected())
                    JLabelImage.setIcon(resize(iconWindows,120,120));
            }
        });

        macRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (macRadioButton.isSelected())
                    JLabelImage.setIcon(resize(iconMac,120,120));
            }
        });
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectOption = "";
                if(linuxRadioButton.isSelected()) selectOption = "Linux";
                if(windowsRadioButton.isSelected()) selectOption = "Windows";
                if(macRadioButton.isSelected()) selectOption = "Mac";

                JOptionPane.showMessageDialog(SystemOperacyjnyWybor.this,"Wybrano system operacyjny: "+selectOption);
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
