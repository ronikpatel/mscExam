import java.awt.*;
import java.awt.event.*;

public class CalculatorAWT extends Frame implements ActionListener {

    Label l1, l2, l3;
    TextField t1, t2, t3;
    Button b1, b2, b3, b4;

    public CalculatorAWT() {

        setLayout(null);  // manual layout

        l1 = new Label("Enter No1:");
        l2 = new Label("Enter No2:");
        l3 = new Label("Answer:");

        t1 = new TextField();
        t2 = new TextField();
        t3 = new TextField();

        b1 = new Button("Addition");
        b2 = new Button("Subtraction"); 
        b3 = new Button("Multiplication");
        b4 = new Button("Division");

        // Set positions (x, y, width, height)
        l1.setBounds(50, 0, 120, 30);
        t1.setBounds(180, 70, 150, 30);

        l2.setBounds(50, 120, 120, 30);
        t2.setBounds(180, 120, 150, 30);

        l3.setBounds(50, 170, 120, 30);
        t3.setBounds(180, 170, 150, 30);

        b1.setBounds(50, 230, 100, 30);
        b2.setBounds(160, 230, 100, 30);
        b3.setBounds(270, 230, 120, 30);
        b4.setBounds(400, 230, 100, 30);

        // Add components
        add(l1); add(t1);
        add(l2); add(t2);
        add(l3); add(t3);

        add(b1); add(b2); add(b3); add(b4);

        // Register Listener
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);

        // Window Close
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        setTitle("Simple Calculator");
        setSize(550, 350);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int n1 = Integer.parseInt(t1.getText());
            int n2 = Integer.parseInt(t2.getText());
            int ans = 0;

            if (e.getSource() == b1)
                ans = n1 + n2;
            else if (e.getSource() == b2)
                ans = n1 - n2;
            else if (e.getSource() == b3)
                ans = n1 * n2;
            else if (e.getSource() == b4)
                ans = n1 / n2;

            t3.setText(String.valueOf(ans));

        } catch (Exception ex) {
            t3.setText("Invalid Input");
        }
    }

    public static void main(String[] args) {
        new CalculatorAWT();
    }
}