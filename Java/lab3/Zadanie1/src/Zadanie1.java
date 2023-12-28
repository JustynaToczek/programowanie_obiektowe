import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.*;

public class Zadanie1 extends JFrame {
    private JPanel panel1;
    private JList list1;
    private JTextField textField0;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton saveNewButton;
    private JButton saveExistingButton;
    private JLabel yearsField;
    private ArrayList<ArrayList<Object>> tab;
    private ArrayList<Integer> tablicaWieku;

    public static void main(String[] args) {
        Zadanie1 zadanie1 = new Zadanie1();
        zadanie1.setVisible(true);
    }

    public Zadanie1() {
        super("App");
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 400);

        tab = new ArrayList<>();
        tab.add(new ArrayList<>(List.of("Jan Kowalski", "janek@gamil.com", "111111111", "Rzeszow ul. Lwowska 1", "2003")));
        tab.add(new ArrayList<>(List.of("Marian Nowak", "marian@gamil.com", "2223333222", "Kielnarowa 50B", "1980")));
        tab.add(new ArrayList<>(List.of("Janina Urban", "JaninaUrban@gamil.com", "9876543210", "Zielona Góra ul. Grunwaldzka 405", "2001")));
        tab.add(new ArrayList<>(List.of("Ewelina Nowak-Maciag", "Ewela@gamil.com", "444444555", "Kraków os. Pułku Lotniczego 3", "1995")));

      //  dane potrzebne do obliczania wieku
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        tablicaWieku = new ArrayList<>();

        //uzupelnienie tablicy wieku wiekiem pierwszych osob na liscie
        for (int i=0; i<4; i++) {
            tablicaWieku.add(currentYear - Integer.parseInt((String)tab.get(i).get(4)));
        }

        DefaultListModel listModel = new DefaultListModel<>();
        list1.setModel(listModel); //ustawienie modelu dla JList

        for (ArrayList<Object> element : tab) {
            listModel.addElement(element.get(0)); //ustawiam poczatkowe elementy do modelu listy
        }

        list1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                saveExistingButton.setEnabled(true); //włączenie możliwości użycia przycisku Save Existing

                //uzupełnienie wszystkich pól
                int selectedIndex = list1.getSelectedIndex();
                        textField0.setText((String) tab.get(selectedIndex).get(0));
                        textField1.setText((String) tab.get(selectedIndex).get(1));
                        textField2.setText((String) tab.get(selectedIndex).get(2));
                        textField3.setText((String) tab.get(selectedIndex).get(3));
                        textField4.setText((String) tab.get(selectedIndex).get(4));

                        yearsField.setText(tablicaWieku.get(selectedIndex) + " years");
            }
        });

        saveNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listModel.addElement(textField0.getText());

                    ArrayList<Object> newElement = new ArrayList<>(List.of(
                            textField0.getText(), textField1.getText(), textField2.getText(), textField3.getText(), textField4.getText()
                    ));

                tab.add(newElement);

                // Dodanie do tablicy wieku nowego elementu
                tablicaWieku.add(currentDate.getYear() - Integer.parseInt((String) newElement.get(4)));
            }
        });

        saveExistingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = list1.getSelectedIndex();

                ArrayList<Object> osobaZListy = tab.get(selectedIndex);
                osobaZListy.set(0,textField0.getText());
                osobaZListy.set(1,textField1.getText());
                osobaZListy.set(2,textField2.getText());
                osobaZListy.set(3,textField3.getText());
                osobaZListy.set(4,textField4.getText());

                //aktualizuję także wiek
                tablicaWieku.set(selectedIndex, currentDate.getYear() - Integer.parseInt((String) osobaZListy.get(4)));
                yearsField.setText(tablicaWieku.get(selectedIndex) + " years");

                // odświeżam model listy, co przyda się w przypadku jeśli zostało zmienione imię
                DefaultListModel listModel = (DefaultListModel) list1.getModel();
                listModel.set(selectedIndex, textField0.getText());
            }
        });
    }
}
