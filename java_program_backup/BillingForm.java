import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BillingForm extends JFrame implements ActionListener {

    JLabel lblName, lblAddress, lblPhone, lblProduct, lblQuantity, lblPrice, lblTotal;
    JTextField txtName, txtAddress, txtPhone, txtProduct, txtQuantity, txtPrice, txtTotal;
    JButton btnCalculate, btnSubmit;

    public BillingForm() {
        setTitle("Billing Information Form");
        setSize(500, 450);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Labels
        lblName = new JLabel("Customer Name:");
        lblName.setBounds(50, 30, 120, 25);
        add(lblName);

        lblAddress = new JLabel("Address:");
        lblAddress.setBounds(50, 70, 120, 25);
        add(lblAddress);

        lblPhone = new JLabel("Phone No:");
        lblPhone.setBounds(50, 110, 120, 25);
        add(lblPhone);

        lblProduct = new JLabel("Product Name:");
        lblProduct.setBounds(50, 150, 120, 25);
        add(lblProduct);

        lblQuantity = new JLabel("Quantity:");
        lblQuantity.setBounds(50, 190, 120, 25);
        add(lblQuantity);

        lblPrice = new JLabel("Price per unit:");
        lblPrice.setBounds(50, 230, 120, 25);
        add(lblPrice);

        lblTotal = new JLabel("Total Amount:");
        lblTotal.setBounds(50, 270, 120, 25);
        add(lblTotal);

        // Text Fields
        txtName = new JTextField();
        txtName.setBounds(200, 30, 200, 25);
        add(txtName);

        txtAddress = new JTextField();
        txtAddress.setBounds(200, 70, 200, 25);
        add(txtAddress);

        txtPhone = new JTextField();
        txtPhone.setBounds(200, 110, 200, 25);
        add(txtPhone);

        txtProduct = new JTextField();
        txtProduct.setBounds(200, 150, 200, 25);
        add(txtProduct);

        txtQuantity = new JTextField();
        txtQuantity.setBounds(200, 190, 200, 25);
        add(txtQuantity);

        txtPrice = new JTextField();
        txtPrice.setBounds(200, 230, 200, 25);
        add(txtPrice);

        txtTotal = new JTextField();
        txtTotal.setBounds(200, 270, 200, 25);
        txtTotal.setEditable(false); // Total is calculated
        add(txtTotal);

        // Buttons
        btnCalculate = new JButton("Calculate Total");
        btnCalculate.setBounds(50, 320, 150, 30);
        btnCalculate.addActionListener(this);
        add(btnCalculate);

        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(250, 320, 150, 30);
        btnSubmit.addActionListener(this);
        add(btnSubmit);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCalculate) {
            try {
                int quantity = Integer.parseInt(txtQuantity.getText());
                double price = Double.parseDouble(txtPrice.getText());
                double total = quantity * price;
                txtTotal.setText(String.format("%.2f", total));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Enter valid numeric values for Quantity and Price");
            }
        } else if (e.getSource() == btnSubmit) {
            String message = "Billing Details:\n" +
                    "Name: " + txtName.getText() + "\n" +
                    "Address: " + txtAddress.getText() + "\n" +
                    "Phone: " + txtPhone.getText() + "\n" +
                    "Product: " + txtProduct.getText() + "\n" +
                    "Quantity: " + txtQuantity.getText() + "\n" +
                    "Price per unit: " + txtPrice.getText() + "\n" +
                    "Total: " + txtTotal.getText();
            JOptionPane.showMessageDialog(this, message, "Billing Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new BillingForm();
    }
}
