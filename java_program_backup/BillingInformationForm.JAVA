import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BillingInformationForm extends JFrame implements ActionListener {

    // Components declaration
    JTextField txtFirstName, txtLastName, txtEmail, txtZip;
    JRadioButton rbMale, rbFemale;
    JCheckBox cbTelugu, cbEnglish, cbHindi;
    JTextArea txtAddress;
    JComboBox<String> cbState, cbCreditCard;
    JButton btnSubmit;

    public BillingInformationForm() {
        setTitle("Billing Information");
        setSize(450, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); // Using absolute positioning for simplicity

        // Label for the form title
        JLabel lblTitle = new JLabel("Billing Information");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitle.setBounds(150, 10, 200, 30);
        add(lblTitle);

        // First Name
        JLabel lblFirstName = new JLabel("First Name:");
        lblFirstName.setBounds(30, 60, 100, 25);
        add(lblFirstName);

        txtFirstName = new JTextField();
        txtFirstName.setBounds(150, 60, 200, 25);
        add(txtFirstName);

        // Last Name
        JLabel lblLastName = new JLabel("Last Name:");
        lblLastName.setBounds(30, 100, 100, 25);
        add(lblLastName);

        txtLastName = new JTextField();
        txtLastName.setBounds(150, 100, 200, 25);
        add(txtLastName);

        // Gender
        JLabel lblGender = new JLabel("Gender:");
        lblGender.setBounds(30, 140, 100, 25);
        add(lblGender);

        rbMale = new JRadioButton("Male");
        rbMale.setBounds(150, 140, 70, 25);
        rbFemale = new JRadioButton("Female");
        rbFemale.setBounds(230, 140, 80, 25);

        // Group radio buttons
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(rbMale);
        genderGroup.add(rbFemale);

        add(rbMale);
        add(rbFemale);

        // Languages
        JLabel lblLanguages = new JLabel("Languages:");
        lblLanguages.setBounds(30, 180, 100, 25);
        add(lblLanguages);

        cbTelugu = new JCheckBox("Telugu");
        cbTelugu.setBounds(150, 180, 80, 25);
        cbEnglish = new JCheckBox("English");
        cbEnglish.setBounds(230, 180, 80, 25);
        cbHindi = new JCheckBox("Hindi");
        cbHindi.setBounds(310, 180, 80, 25);

        add(cbTelugu);
        add(cbEnglish);
        add(cbHindi);

        // Email
        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(30, 220, 100, 25);
        add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(150, 220, 200, 25);
        add(txtEmail);

        // Address
        JLabel lblAddress = new JLabel("Address:");
        lblAddress.setBounds(30, 260, 100, 25);
        add(lblAddress);

        txtAddress = new JTextArea();
        txtAddress.setBounds(150, 260, 200, 80);
        txtAddress.setLineWrap(true);
        txtAddress.setWrapStyleWord(true);
        JScrollPane scrollAddress = new JScrollPane(txtAddress);
        scrollAddress.setBounds(150, 260, 200, 80);
        add(scrollAddress);

        // State Dropdown
        JLabel lblState = new JLabel("State:");
        lblState.setBounds(30, 360, 100, 25);
        add(lblState);

        String[] states = {"Choose State", "Andhra Pradesh", "Telangana", "Karnataka", "Tamil Nadu", "Kerala"};
        cbState = new JComboBox<>(states);
        cbState.setBounds(150, 360, 200, 25);
        add(cbState);

        // Zip
        JLabel lblZip = new JLabel("Zip:");
        lblZip.setBounds(30, 400, 100, 25);
        add(lblZip);

        txtZip = new JTextField();
        txtZip.setBounds(150, 400, 200, 25);
        add(txtZip);

        // Credit Card Type Dropdown
        JLabel lblCreditCard = new JLabel("Credit Card Type:");
        lblCreditCard.setBounds(30, 440, 120, 25);
        add(lblCreditCard);

        String[] creditCards = {"Choose Credit Card", "Visa", "MasterCard", "American Express", "Discover"};
        cbCreditCard = new JComboBox<>(creditCards);
        cbCreditCard.setBounds(150, 440, 200, 25);
        add(cbCreditCard);

        // Submit Button
        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(180, 490, 100, 30);
        btnSubmit.addActionListener(this);
        add(btnSubmit);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Gather all input values on submit
        String firstName = txtFirstName.getText();
        String lastName = txtLastName.getText();

        String gender = "";
        if (rbMale.isSelected()) gender = "Male";
        else if (rbFemale.isSelected()) gender = "Female";

        StringBuilder languages = new StringBuilder();
        if (cbTelugu.isSelected()) languages.append("Telugu ");
        if (cbEnglish.isSelected()) languages.append("English ");
        if (cbHindi.isSelected()) languages.append("Hindi ");

        String email = txtEmail.getText();
        String address = txtAddress.getText();
        String state = (String) cbState.getSelectedItem();
        String zip = txtZip.getText();
        String creditCard = (String) cbCreditCard.getSelectedItem();

        // Show the gathered information
        String message = "Billing Information Submitted:\n\n" +
                         "Name: " + firstName + " " + lastName + "\n" +
                         "Gender: " + gender + "\n" +
                         "Languages: " + languages.toString().trim() + "\n" +
                         "Email: " + email + "\n" +
                         "Address: " + address + "\n" +
                         "State: " + state + "\n" +
                         "Zip: " + zip + "\n" +
                         "Credit Card Type: " + creditCard;

        JOptionPane.showMessageDialog(this, message, "Submission Successful", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        new BillingInformationForm();
    }
}
