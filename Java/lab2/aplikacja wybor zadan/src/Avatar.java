import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Avatar extends JFrame {
    private JPanel panel1;
    private JRadioButton shrekRadioButton;
    private JRadioButton fionaRadioButton;
    private JRadioButton osiolRadioButton;
    private JRadioButton ciastekRadioButton;
    private JRadioButton kotWButachRadioButton;
    private JLabel JLabelImage;
    private JButton okButton;
    private ButtonGroup buttonGroup1;
    private ImageIcon iconShrek = new ImageIcon(getClass().getResource("shrek.jpg"));
    private ImageIcon iconFiona = new ImageIcon(getClass().getResource("fiona.jpg"));
    private ImageIcon iconKot = new ImageIcon(getClass().getResource("kot.jpg"));
    private ImageIcon iconCiastek = new ImageIcon(getClass().getResource("ciastek.jpeg"));
    private ImageIcon iconOsiol = new ImageIcon(getClass().getResource("osiol.jpg"));

    private static ImageIcon resize(ImageIcon src, int destWidth, int destHeight) {
        return new ImageIcon(src.getImage().getScaledInstance(destWidth,destHeight, Image.SCALE_SMOOTH));
    }

    public static void main(String[] args) {
        Avatar avatar = new Avatar();
        avatar.setVisible(true);
    }


    public Avatar() {
        super("Wybierz swoją postać");
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(450,400);
        //this.pack();

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectOption = "";
                if(shrekRadioButton.isSelected()) selectOption = "Shrek";
                if(fionaRadioButton.isSelected()) selectOption = "Fiona";
                if(kotWButachRadioButton.isSelected()) selectOption = "Kot w butach";
                if(osiolRadioButton.isSelected()) selectOption = "Osioł";
                if(ciastekRadioButton.isSelected()) selectOption = "Ciastek";

                JOptionPane.showMessageDialog(Avatar.this,"Wybrano postać: "+selectOption);

                dispose();
                Przeciwnicy przeciwnicy = new Przeciwnicy();
                przeciwnicy.setVisible(true);
            }
        });

        shrekRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(shrekRadioButton.isSelected())
                    JLabelImage.setIcon(resize(iconShrek, 230, 150));
            }
        });

        fionaRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(fionaRadioButton.isSelected())
                    JLabelImage.setIcon(resize(iconFiona,150,180));
            }
        });
        osiolRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(osiolRadioButton.isSelected())
                    JLabelImage.setIcon(resize(iconOsiol,150,150));
            }
        });
        ciastekRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ciastekRadioButton.isSelected())
                    JLabelImage.setIcon(resize(iconCiastek,150,150));
            }
        });
        kotWButachRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(kotWButachRadioButton.isSelected())
                    JLabelImage.setIcon(resize(iconKot,150,150));
            }
        });
    }

}
