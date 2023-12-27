import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tlumacz extends JFrame{
    private JPanel panel1;
    private JButton poziomoButton;
    private JButton pionowoButton;
    private JButton ciasteczkoButton;
    private JButton tortButton;
    private JButton herbataButton;
    private JButton kawaButton;
    private JButton prezentButton;
    private JButton urodzinyButton;
    private JLabel przetlumaczone;



    public static void main(String[] args) {
        Tlumacz obj1 = new Tlumacz();
        obj1.setVisible(true);
    }

    public Tlumacz() {
        super("Tłumacz słów z polskiego na angielski");
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int width = 500, height = 300;
        this.setSize(width,height);

        poziomoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    przetlumaczone.setText("Tłumaczenie słowa na język angielski: horizontally");
            }
        });
        pionowoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    przetlumaczone.setText("Tłumaczenie słowa na język angielski: vertically");
            }
        });
        tortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    przetlumaczone.setText("Tłumaczenie słowa na język angielski: cake");
            }
        });
        ciasteczkoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    przetlumaczone.setText("Tłumaczenie słowa na język angielski: cookie");
            }
        });
        herbataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    przetlumaczone.setText("Tłumaczenie słowa na język angielski: tea");
            }
        });
        kawaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    przetlumaczone.setText("Tłumaczenie słowa na język angielski: coffee");
            }
        });
        urodzinyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    przetlumaczone.setText("Tłumaczenie słowa na język angielski: birthday");
            }
        });
        prezentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    przetlumaczone.setText("Tłumaczenie słowa na język angielski: gift");
            }
        });
    }
}
