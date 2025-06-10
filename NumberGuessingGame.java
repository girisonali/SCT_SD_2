import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Guess the Number");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(176, 224, 230));

        Random rand = new Random();
        int[] secret = {rand.nextInt(100) + 1};
        int[] attempts = {0};

        JLabel label = new JLabel("Enter a number (1-100):");
        label.setBounds(150, 30, 200, 25);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(new Color(0, 0, 128));
        frame.add(label);

        JTextField textField = new JTextField();
        textField.setBounds(175, 60, 150, 30);
        frame.add(textField);

        JLabel feedback = new JLabel("");
        feedback.setBounds(100, 150, 300, 25);
        feedback.setHorizontalAlignment(SwingConstants.CENTER);
        feedback.setForeground(new Color(0, 0, 128));
        frame.add(feedback);

        JButton guessButton = new JButton("Guess");
        guessButton.setBounds(120, 110, 100, 30);
        guessButton.setBackground(new Color(0, 0, 128));
        guessButton.setForeground(Color.WHITE);
        frame.add(guessButton);

        JButton restartButton = new JButton("Restart");
        restartButton.setBounds(280, 110, 100, 30);
        restartButton.setBackground(new Color(0, 0, 128));
        restartButton.setForeground(Color.WHITE);
        frame.add(restartButton);

        guessButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int guess = Integer.parseInt(textField.getText());
                    attempts[0]++;
                    if (guess < 1 || guess > 100) {
                        feedback.setText("Please enter a number 1 to 100.");
                    } else if (guess < secret[0]) {
                        feedback.setText("Too low. Try again.");
                    } else if (guess > secret[0]) {
                        feedback.setText("Too high. Try again.");
                    } else {
                        feedback.setText("Correct in " + attempts[0] + " tries!");
                    }
                } catch (NumberFormatException ex) {
                    feedback.setText("Invalid input. Enter a number.");
                }
            }
        });

        restartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                secret[0] = rand.nextInt(100) + 1;
                attempts[0] = 0;
                textField.setText("");
                feedback.setText("Game restarted.");
            }
        });

        frame.setVisible(true);
    }
}
