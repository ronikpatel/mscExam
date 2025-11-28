import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeSwing extends JFrame implements Runnable {

    JLabel timeLabel;
    Thread t;

    public DateTimeSwing() {
        // Frame setup
        setTitle("Current Date and Time");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel with pink background
        JPanel panel = new JPanel();
        panel.setBackground(Color.PINK);
        panel.setLayout(new GridBagLayout()); // Center content

        // Label to display date and time
        timeLabel = new JLabel();
        timeLabel.setForeground(Color.RED);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(timeLabel);

        add(panel);

        // Start the thread to update time
        t = new Thread(this);
        t.start();

        setVisible(true);
    }

    @Override
    public void run() {
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE, dd MMMM yyyy HH:mm:ss");
        while (true) {
            Date date = new Date();
            timeLabel.setText(formatter.format(date));
            try {
                Thread.sleep(1000); // update every second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new DateTimeSwing();
    }
}
