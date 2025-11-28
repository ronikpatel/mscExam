import java.awt.*;
import java.awt.event.*;

public class LoginFormAWT extends Frame implements ActionListener {

    Label lblUser, lblPass;
    TextField txtUser, txtPass;
    Button btnLogin;
    Label lblMessage;

    public LoginFormAWT() {
        // Frame setup
        setTitle("Login Form");
        setSize(400, 250);
        setLayout(null); // Absolute positioning
        setBackground(Color.LIGHT_GRAY);

        // Username Label and TextField
        lblUser = new Label("Username:");
        lblUser.setBounds(50, 50, 80, 30);
        add(lblUser);

        txtUser = new TextField();
        txtUser.setBounds(150, 50, 180, 30);
        add(txtUser);

        // Password Label and TextField
        lblPass = new Label("Password:");
        lblPass.setBounds(50, 100, 80, 30);
        add(lblPass);

        txtPass = new TextField();
        txtPass.setBounds(150, 100, 180, 30);
        txtPass.setEchoChar('*'); // Hide password characters
        add(txtPass);

        // Login Button
        btnLogin = new Button("Login");
        btnLogin.setBounds(150, 150, 80, 30);
        btnLogin.addActionListener(this);
        add(btnLogin);

        // Message Label
        lblMessage = new Label();
        lblMessage.setBounds(50, 200, 300, 30);
        lblMessage.setForeground(Color.RED);
        add(lblMessage);

        // Window Closing
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    // Handle button click
    @Override
    public void actionPerformed(ActionEvent e) {
        String username = txtUser.getText();
        String password = txtPass.getText();

        // Simple authentication (hardcoded for demo)
        if (username.equals("admin") && password.equals("12345")) {
            lblMessage.setText("Login Successful!");
            lblMessage.setForeground(Color.GREEN);
        } else {
            lblMessage.setText("Invalid Username or Password");
            lblMessage.setForeground(Color.RED);
        }
    }

    public static void main(String[] args) {
        new LoginFormAWT();
    }
}
