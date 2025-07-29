package fibonacci.network;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class FibonacciClientGUI extends JFrame {

    private JTextField textField;
    private JButton calculateButton;
    private JLabel resultLabel;

    public FibonacciClientGUI() {
        setTitle("Fibonacci Client");
        setSize(400, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        textField = new JTextField(10);
        calculateButton = new JButton("Calculate");
        resultLabel = new JLabel("Result will appear here");

        add(new JLabel("Enter a number:"));
        add(textField);
        add(calculateButton);
        add(resultLabel);

        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                	int number = Integer.parseInt(textField.getText());
                	if (number < 0) {
                	    resultLabel.setText("Please enter a positive number");
                	    return;
                	}

                    try (
                        Socket socket = new Socket("localhost", 5000);
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    ) {
                        out.println(number);
                        String response = in.readLine();
                        resultLabel.setText("Fibonacci: " + response);
                    } catch (IOException ex) {
                        resultLabel.setText("Connection error: " + ex.getMessage());
                    }

                } catch (NumberFormatException ex) {
                    resultLabel.setText("Please enter a valid number");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FibonacciClientGUI client = new FibonacciClientGUI();
            client.setVisible(true);
        });
    }
}
