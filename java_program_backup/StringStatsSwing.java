import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StringStatsSwing extends JFrame implements ActionListener {

    JLabel lblInput, lblLength, lblWords;
    JTextField txtInput;
    JButton btnCount;

    public StringStatsSwing() {
        setTitle("String Statistics");
        setSize(400, 250);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Input label
        lblInput = new JLabel("Enter text:");
        lblInput.setBounds(50, 50, 80, 25);
        add(lblInput);

        // Text field
        txtInput = new JTextField();
        txtInput.setBounds(150, 50, 180, 25);
        add(txtInput);

        // Count button
        btnCount = new JButton("Count");
        btnCount.setBounds(150, 100, 80, 25);
        btnCount.addActionListener(this);
        add(btnCount);

        // Output labels
        lblLength = new JLabel("String Length: ");
        lblLength.setBounds(50, 150, 300, 25);
        add(lblLength);

        lblWords = new JLabel("Total Words: ");
        lblWords.setBounds(50, 180, 300, 25);
        add(lblWords);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = txtInput.getText();

        int length = text.length();

        String trimmedText = text.trim();
        int words = trimmedText.isEmpty() ? 0 : trimmedText.split("\\s+").length;

        lblLength.setText("String Length: " + length);
        lblWords.setText("Total Words: " + words);
    }

    public static void main(String[] args) {
        new StringStatsSwing();
    }
}
