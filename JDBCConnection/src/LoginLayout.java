import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class LoginLayout extends JPanel {
    JLabel usernameLabel;
    JTextField usernameField;
    JPasswordField passwordField;
    public LoginLayout(){
        usernameLabel = new JLabel("Enter Username");
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        setLayout(null);
        usernameLabel.setBounds(120,120,40,40);
        this.add(usernameLabel);
        usernameLabel.setBounds(600,300,40,40);
        this.add(usernameField);
        passwordField.setBounds(700,300,40,40);
        add(passwordField);
    }
}
