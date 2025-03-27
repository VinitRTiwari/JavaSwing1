import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Calculator {
    private JTextField display;
    private String num1 = "", num2 = "", operator = "";

    public Calculator() {
        // Create the main frame
        JFrame frame = new JFrame("Java Calsii");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());

        // Create display field
        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        frame.add(display, BorderLayout.NORTH);

        // Create panel for buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        // Button labels
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "C", "0", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.addActionListener(new ButtonClickListener());
            panel.add(button);
        }

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    // Button Action Listener
    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String buttonText = e.getActionCommand();

            if ("0123456789".contains(buttonText)) {
                display.setText(display.getText() + buttonText);
            } else if ("/*-+".contains(buttonText)) {
                num1 = display.getText();
                operator = buttonText;
                display.setText("");
            } else if (buttonText.equals("=")) {
                num2 = display.getText();
                double result = calculate(Double.parseDouble(num1), Double.parseDouble(num2), operator);
                display.setText(String.valueOf(result));
            } else if (buttonText.equals("C")) {
                display.setText("");
                num1 = num2 = operator = "";
            }
        }
    }

    // Perform calculations
    private double calculate(double a, double b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return b != 0 ? a / b : 0;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
