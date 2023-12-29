import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JDialog {
    private JPanel panel1;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton okButton;
    private JButton cancelButton;

//    public static void main(String[] args) {
//        Login login = new Login(null);
//        User user = login.user;
//        if ( user != null) {
//            System.out.println("Succesful authorization of: "+user.name);
//            System.out.println("\t\tEmail: "+user.email);
//            System.out.println("\t\tPhone: "+user.phone);
//            System.out.println("\t\tAdress: "+user.address);
//        }
//        else System.out.println("Authorization cancelled");
//    }

    public Login(JFrame parent)  {
        super(parent);
        setTitle("Login");
        setContentPane(panel1);
        int width=450, height=350;
        setMinimumSize(new Dimension(width,height));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = textField1.getText();
                String password = String.valueOf(passwordField1.getPassword());

                user = getAutenticateUser(email,password);

                if(user != null) {
                    dispose();
                    Dashboard dashboard = new Dashboard();
                    dashboard.setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(
                            Login.this,
                            "Email or password invalid",
                            "Try again",
                            JOptionPane.ERROR_MESSAGE
                    );
                }

            }

        });
        setVisible(true);




        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public User user;
    private User getAutenticateUser(String email,String password) {
        User user = null;

        final String DB_URL = "jdbc:mysql://localhost/MyStore?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD ="";

        try {
            Connection conn = DriverManager.getConnection(DB_URL,USERNAME, PASSWORD);
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM users WHERE email=? AND password=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                user = new User();
                user.name = resultSet.getString("name");
                user.email = resultSet.getString("email");
                user.phone = resultSet.getString("phone");
                user.address = resultSet.getString("adress");
                user.password = resultSet.getString("password");
            }

            stmt.close();
            conn.close();

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
}
