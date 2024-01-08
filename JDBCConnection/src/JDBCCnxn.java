import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JDBCCnxn extends JPanel{
    public JPanel signUpPanel;
    public JButton backToWelcomeScreenButton;
    public JButton submitButton;
    public JTextField usernameField;
    public JTextField emailField;
    public JPasswordField passwordField;
    public JPasswordField cPasswordField;

    JDBCCnxn(){

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String email = emailField.getText();
                String password = String.valueOf(passwordField.getPassword());
                System.out.println(password);
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        setLayout(new GridLayout());
    }
}
