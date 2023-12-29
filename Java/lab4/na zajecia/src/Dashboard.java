import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Dashboard extends JFrame {
    private JPanel panel1;
    private JButton registerButton;
    private JButton editButton;
    private JButton deleteButton;
    private JButton clearButton;
    private JTable ClientsTable;
    private JButton closeButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;

    public Dashboard() {
        super("DashboardForm");

        setContentPane(panel1);
        int width=800, height=600;
        setMinimumSize(new Dimension(width,height));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //wywołnie metody do utworzenia tabeli
        createTable();

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Login login = new Login(null);
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");
            }
        });

        // I wersja z tworzeniem tabeli
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if( textField1.getText().equals("") ||
                        textField2.getText().equals("") ||
                        textField3.getText().equals("") ||
                        textField4.getText().equals(""))
                    JOptionPane.showMessageDialog(null,"Proszę podać wszytskie dane");
                else {
                    String data[] = {
                        textField1.getText(),
                        textField2.getText(),
                        textField3.getText(),
                        textField4.getText()
                    };
                    DefaultTableModel tblModel = (DefaultTableModel)ClientsTable.getModel();
                    tblModel.addRow(data);
                    JOptionPane.showMessageDialog(null,"Dodano poprawnie dane");
                    textField1.setText("");
                    textField2.setText("");
                    textField3.setText("");
                    textField4.setText("");

                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel tblModel = (DefaultTableModel) ClientsTable.getModel();

                if(ClientsTable.getSelectedRowCount()==1)
                    tblModel.removeRow(ClientsTable.getSelectedRow());
                else {
                    if (ClientsTable.getRowCount() == 0)
                        JOptionPane.showMessageDialog(null,"Brak danych do usunięcia");
                    else
                        JOptionPane.showMessageDialog(null,"Proszę zaznaczyć tylko jeden wiersz ...");
                }
            }
        });
        //LISTENER KLIKNANIA W POSZCZEGOLNE WIERSZE TABELI
        ClientsTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = ClientsTable.getSelectedRow(); //get selected row index
                DefaultTableModel model = (DefaultTableModel) ClientsTable.getModel();
               // getValueAt(row index, column index)
                textField1.setText(model.getValueAt(row,0).toString()); //selected row: column 1
                textField2.setText(model.getValueAt(row,1).toString()); //selected row: column 2
                textField3.setText(model.getValueAt(row,2).toString()); //selected row: column 3
                textField4.setText(model.getValueAt(row,3).toString()); //selected row: column 4

            }
        });
        //AKTUALIZACJA DANYCH W TABELI
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = ClientsTable.getSelectedRow(); //get selected row index
                DefaultTableModel model = (DefaultTableModel) ClientsTable.getModel();

                    if( textField1.getText().equals("") ||
                            textField2.getText().equals("") ||
                            textField3.getText().equals("") ||
                            textField4.getText().equals(""))
                        JOptionPane.showMessageDialog(null,"Proszę podać wszytskie dane");
                    else {
                        model.setValueAt(textField1.getText(),row,0);
                        model.setValueAt(textField2.getText(),row,1);
                        model.setValueAt(textField3.getText(),row,2);
                        model.setValueAt(textField4.getText(),row,3);
                        };
            }
        });
    } //koniec konstruktora

    private void createTable() {
        Object[][] data = {

        };

        ClientsTable.setModel(new DefaultTableModel(
                data,
                new String[]{"First and last name",
                        "e-mail",
                        "Phone",
                        "Adress"
                } // kolumny tabeli
        ));

        TableColumnModel columns = ClientsTable.getColumnModel();

        DefaultTableCellRenderer centerRendered = new DefaultTableCellRenderer();
        centerRendered.setHorizontalAlignment(JLabel.CENTER);
        columns.getColumn(0).setCellRenderer(centerRendered);
        columns.getColumn(1).setCellRenderer(centerRendered);
        columns.getColumn(2).setCellRenderer(centerRendered);
        columns.getColumn(3).setCellRenderer(centerRendered);
    }

    private boolean connectToDatanbase() {
        boolean hasRegistredUsers = false;

        //spr podłaczenia do bazy
        final String MYSQL_SERVER_URL = "jdbc:mysql://localhost/";
        final String DB_URL = "jdbc:mysql://localhost/MyStore?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try{
            //fist connet to MYSQL server and create the database if not created
            Connection conn = DriverManager.getConnection(MYSQL_SERVER_URL, USERNAME,PASSWORD);
            Statement statement = conn.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS MyStore");
            statement.close();;
            conn.close();

            //connect to the database and create the table "users if not created
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            statement = conn.createStatement();

            String sql = "CREATE TABLE IF NOT EXISTS users (" +
                    "id INT(10) NOT NULL PRIMARY KEY AUTO_INCREMENT," +
                    "name VARCHAR(200) NOT NULL," +
                    "email VARCHAR(200) NOT NULL UNIQUE," +
                    "phone varchar(200)," +
                    "address VARCHAR(200)," +
                    "password VARCHAR(200) NOT NULL)";
            statement.executeUpdate(sql);

            //check if we have user in the table users
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM users");

            if(resultSet.next()){
                int numUsers = resultSet.getInt(1);
                if (numUsers > 0){
                    hasRegistredUsers = true;
                }
            }

            statement.close();
            conn.close();


        }catch (Exception e){
            e.printStackTrace();
        }

        return hasRegistredUsers;
    }

}
