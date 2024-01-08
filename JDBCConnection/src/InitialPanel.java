import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InitialPanel  extends MigLayout {
    public JPanel InitialPanel;
    public JButton loginButton;
    public JButton signUpButton;
    public JLabel welcomeLabel;

    public InitialPanel(Main rootFrame){
        //setVisible(true);
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rootFrame.changeToSignUpPanel();
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rootFrame.changeToLoginPanel();
            }
        });
    }
}
