import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Main extends JFrame {
    String url;
    Properties properties;
    static Connection connection = null;
    JPanel initialPanel;
    JDBCCnxn signUpPanel;
    LoginLayout loginLayout;

    Main(){
        initialPanel = new InitialPanel(this).InitialPanel;

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new MigLayout());
        setVisible(true);

        setContentPane(new LoginLayout());
        pack();

    }
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/javaConn";
        Properties properties = new Properties();
        properties.setProperty("user","postgres");
        properties.setProperty("password","postgres");
        try{
            connection = DriverManager.getConnection(url,properties);
            System.out.println("Connection Established");
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        Main m = new Main();
    }

    public void changeToSignUpPanel(){
        System.out.println("Hellow ");
        setContentPane(signUpPanel);
        signUpPanel.setVisible(true);
        System.out.println(this.getContentPane().getComponentCount());
        this.pack();
        this.setVisible(true);
    }

    public void changeToLoginPanel(){
        signUpPanel.setVisible(false);
        this.setVisible(false);
    }

}