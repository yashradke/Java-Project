import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URI;

public class LoginFrame extends JFrame {
    private JTextField emailOrMobileField;
    private JPasswordField passwordField;
    private JCheckBox rememberMeCheckbox;
    
    // Define the login details
    private static final String USERNAME = "training@jalaacademy.com";
    private static final String PASSWORD = "jobprogram";
    
    public LoginFrame() {
        // Set frame properties
        setTitle("Login Page");
        setSize(400, 250); // Increased height to accommodate login details
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Create panel for login components
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(5, 2, 10, 10)); // Increased rows to accommodate login details
        
        // Add components to panel
        loginPanel.add(new JLabel("Email or Mobile No:"));
        emailOrMobileField = new JTextField();
        loginPanel.add(emailOrMobileField);
        
        loginPanel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        loginPanel.add(passwordField);
        
        rememberMeCheckbox = new JCheckBox("Remember Me");
        loginPanel.add(rememberMeCheckbox);
        
        JButton signInButton = new JButton("Sign In");
        signInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Perform sign-in logic here
                String emailOrMobile = emailOrMobileField.getText();
                String password = new String(passwordField.getPassword());
                boolean rememberMe = rememberMeCheckbox.isSelected();
                System.out.println("Sign In: Email/Mobile: " + emailOrMobile + ", Password: " + password + ", Remember Me: " + rememberMe);
                
                // Check if the entered credentials match the predefined login details
                if (USERNAME.equals(emailOrMobile) && PASSWORD.equals(password)) {
                    // Redirect to the specified URL after successful sign-in
                    String redirectUrl = "https://magnus.jalatechnologies.com/Home/Index";
                    try {
                        Desktop.getDesktop().browse(new URI(redirectUrl));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    // Display an error message for incorrect credentials
                    JOptionPane.showMessageDialog(LoginFrame.this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        loginPanel.add(signInButton);
        
        JButton forgotPasswordButton = new JButton("Forgot Password");
        forgotPasswordButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Perform forgot password logic here
                System.out.println("Forgot Password");
            }
        });
        loginPanel.add(forgotPasswordButton);
        
        // Add login details to the panel
        loginPanel.add(new JLabel("Login details:"));
        loginPanel.add(new JLabel("Username: " + USERNAME));
        loginPanel.add(new JLabel("Password: " + PASSWORD));
        
        // Create panel for header
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        headerPanel.add(new JLabel("JALA ACADEMY"));
        
        // Add panels to frame
        setLayout(new BorderLayout());
        add(headerPanel, BorderLayout.NORTH);
        add(loginPanel, BorderLayout.CENTER);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }
}
