import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BulbSwing extends JFrame implements ActionListener {

    JButton onButton, offButton;
    boolean bulbOn = false;

    public BulbSwing() {
        // Frame setup
        setTitle("Bulb ON/OFF");
        setSize(300, 350);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Buttons
        onButton = new JButton("Turn ON");
        onButton.setBounds(50, 250, 90, 30);
        onButton.addActionListener(this);
        add(onButton);

        offButton = new JButton("Turn OFF");
        offButton.setBounds(150, 250, 90, 30);
        offButton.addActionListener(this);
        add(offButton);

        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); // Clear previous drawings

        // Draw bulb outline
        g.setColor(Color.BLACK);
        g.fillOval(100, 50, 100, 150);

        // Bulb color based on state
        if (bulbOn) {
            g.setColor(Color.YELLOW);
        } else {
            g.setColor(Color.GRAY);
        }
        g.fillOval(100, 50, 100, 150);

        // Label
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString(bulbOn ? "Bulb is ON" : "Bulb is OFF", 110, 220);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == onButton) {
            bulbOn = true;
        } else if (e.getSource() == offButton) {
            bulbOn = false;
        }
        repaint();
    }

    public static void main(String[] args) {
        new BulbSwing();
    }
}
