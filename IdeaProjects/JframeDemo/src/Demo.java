import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Demo {
    private static JButton loginButton;
    public static void main(String[] args) {
        JFrame frame = new JFrame("Created By Yongbing Pan &Liehao Wu");
        frame.setSize(1000, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
        frame.setVisible(true);
    }
        private static void placeComponents(JPanel panel) {

            panel.setLayout(null);
            JLabel userLabel = new JLabel("SourceFile:");
            userLabel.setBounds(10,20,80,25);
            panel.add(userLabel);

           final JTextField userText = new JTextField(20);
            userText.setBounds(100,20,165,25);
            panel.add(userText);

            JLabel passwordLabel = new JLabel("TargetFile:");
            passwordLabel.setBounds(10,50,80,25);
            panel.add(passwordLabel);

            final JTextField passwordText = new JTextField(20);
            passwordText.setBounds(100,50,165,25);
            panel.add(passwordText);

            loginButton = new JButton("生成Excel");
            loginButton.setBounds(10, 80, 200, 25);
            panel.add(loginButton);

            loginButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   System.out.println(userText.getText());
                   System.out.println(passwordText.getText());
                }
            });
        }

    }

