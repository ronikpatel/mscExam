import javax.swing.*;
import java.awt.*;

public class BGColorSwing extends JFrame {

    public BGColorSwing(String colorName) {
        setTitle("Background Color Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel
        JPanel panel = new JPanel();

        // Set background color based on input string
        switch (colorName.toLowerCase()) {
            case "red":
                panel.setBackground(Color.RED);
                break;
            case "green":
                panel.setBackground(Color.GREEN);
                break;
            case "blue":
                panel.setBackground(Color.BLUE);
                break;
            case "yellow":
                panel.setBackground(Color.YELLOW);
                break;
            case "pink":
                panel.setBackground(Color.PINK);
                break;
            case "orange":
                panel.setBackground(Color.ORANGE);
                break;
            default:
                panel.setBackground(Color.WHITE);
        }

        // Add label to show which color is selected
        JLabel label = new JLabel("Background color: " + colorName, SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(label);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        String color = "pink"; // default color
        if (args.length > 0) {
            color = args[0]; // pass color as command-line argument
        }
        new BGColorSwing(color);
    }
}
