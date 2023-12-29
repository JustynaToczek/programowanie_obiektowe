import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Register extends JDialog {
    private JPanel panel1;
    private JButton registerButton;
    private JButton cancelButton;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JTextField textField4;
    private JTextField textField3;
    private JTextField textField2;
    private JTextField textField1;

//    public static void main(String[] args) {
//        Register register = new Register(null);
//        User user = register.user;
//        if(user != null)
//            System.out.println("Succesful registration of: "+user.name);
//
//        else
//            System.out.println("Registration cancelled");
//
//    }
    public Register(JFrame parent) {
        super(parent);
        setTitle("create a new account");
        setContentPane(panel1);
        int width=450, height=475;
        setMinimumSize(new Dimension(width,height));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerUser();
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }

        });
        setVisible(true);
    } //koniec konstruktora

    private void registerUser() {
        String name = textField1.getText();
        String email = textField2.getText();
        String phone = textField3.getText();
        String adress = textField4.getText();
        String password = String.valueOf(passwordField1.getPassword());
        String confirmPassword = String.valueOf(passwordField2.getPassword());

        if(name.isEmpty() || email.isEmpty() || phone.isEmpty() || adress.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please enter all fields",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(!password.equals(confirmPassword)){
            JOptionPane.showMessageDialog(this,
                    "Confirm Password does not match",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        user = addUserToDatabase(name, email, phone, adress, password);
        if(user != null)
            dispose();
        else {
            JOptionPane.showMessageDialog(this,
                    "Failed to register new user",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public User user;

    private User addUserToDatabase(String name, String email, String phone, String adress, String password) {
        User user = null;


        //sprawdzenie polaczenia do bazy danych
        final String DB_URL = "jdbc:mysql://localhost/MyStore?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD ="";

        try {
            Connection conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO users (name, email, phone, adress, password) VALUES (?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,email);
            preparedStatement.setString(3,phone);
            preparedStatement.setString(4,adress);
            preparedStatement.setString(5,password);

            //insert row into the table
            int addedRows = preparedStatement.executeUpdate();
            if(addedRows > 0) {
                user = new User();
                user.name = name;
                user.email = email;
                user.phone = phone;
                user.address = adress;
                user.password = password;
            }
            //close connection
            stmt.close();
            conn.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
}
