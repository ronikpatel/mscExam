import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorForm extends JFrame implements ActionListener {

    JTextField txtNum1, txtNum2, txtAnswer;
    JButton btnAdd, btnSub, btnMul, btnDiv;

    public CalculatorForm() {
        setTitle("Simple Calculator");
        setSize(450, 200);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Label and TextField for Number 1
        JLabel lblNum1 = new JLabel("Enter No1:");
        lblNum1.setBounds(20, 20, 70, 25);
        add(lblNum1);

        txtNum1 = new JTextField();
        txtNum1.setBounds(100, 20, 100, 25);
        add(txtNum1);

        JLabel lblTextBox = new JLabel("TextBox");
        lblTextBox.setBounds(210, 20, 80, 25);
        add(lblTextBox);

        // Label and TextField for Number 2
        JLabel lblNum2 = new JLabel("Enter No2:");
        lblNum2.setBounds(20, 60, 70, 25);
        add(lblNum2);

        txtNum2 = new JTextField();
        txtNum2.setBounds(100, 60, 100, 25);
        add(txtNum2);

        // Label and TextField for Answer
        JLabel lblAnswer = new JLabel("Answer:");
        lblAnswer.setBounds(20, 100, 70, 25);
        add(lblAnswer);

        txtAnswer = new JTextField();
        txtAnswer.setBounds(100, 100, 100, 25);
        txtAnswer.setEditable(false);
        add(txtAnswer);

        // Buttons
        btnAdd = new JButton("Addition");
        btnAdd.setBounds(220, 20, 90, 25);
        btnAdd.addActionListener(this);
        add(btnAdd);

        btnSub = new JButton("Subtraction");
        btnSub.setBounds(320, 20, 110, 25);
        btnSub.addActionListener(this);
        add(btnSub);

        btnMul = new JButton("Multiplication");
        btnMul.setBounds(220, 60, 110, 25);
        btnMul.addActionListener(this);
        add(btnMul);

        btnDiv = new JButton("Division");
        btnDiv.setBounds(340, 60, 90, 25);
        btnDiv.addActionListener(this);
        add(btnDiv);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(txtNum1.getText());
            double num2 = Double.parseDouble(txtNum2.getText());
            double result = 0;

            if (e.getSource() == btnAdd) {
                result = num1 + num2;
            } else if (e.getSource() == btnSub) {
                result = num1 - num2;
            } else if (e.getSource() == btnMul) {
                result = num1 * num2;
            } else if (e.getSource() == btnDiv) {
                if (num2 == 0) {
                    JOptionPane.showMessageDialog(this, "Cannot divide by zero!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                result = num1 / num2;
            }

            txtAnswer.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new CalculatorForm();
    }
}
