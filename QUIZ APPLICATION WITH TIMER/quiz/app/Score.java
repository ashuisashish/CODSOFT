package quiz.app;

import javax.swing.*;
import java.awt.*;

public class Score extends JFrame {

    Score(String name, int score, int correct, int incorrect) {

        setSize(750, 550);
        setLocation(300, 80);
        setLayout(null);
        setUndecorated(true);

        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
        Image i2 = icon1.getImage().getScaledInstance(200, 150, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(30, 200, 200, 150);
        add(image);

        JLabel heading = new JLabel("Thank you " + name + " for Playing QUIZ Test ");
        heading.setBounds(90, 80, 700, 30);
        heading.setFont(new Font("", Font.BOLD, 26));
        heading.setForeground(Color.WHITE);
        add(heading);

        JLabel scoreLabel = new JLabel("Your Score is " + score);
        scoreLabel.setBounds(250, 180, 300, 30);
        scoreLabel.setFont(new Font("", Font.BOLD, 26));
        scoreLabel.setForeground(Color.WHITE);
        add(scoreLabel);

        JLabel correctLabel = new JLabel("Correct Answers: " + correct);
        correctLabel.setBounds(250, 220, 300, 30);
        correctLabel.setFont(new Font("", Font.BOLD, 26));
        correctLabel.setForeground(Color.WHITE);
        add(correctLabel);

        JLabel incorrectLabel = new JLabel("Incorrect Answers: " + incorrect);
        incorrectLabel.setBounds(250, 260, 300, 30);
        incorrectLabel.setFont(new Font("", Font.BOLD, 26));
        incorrectLabel.setForeground(Color.WHITE);
        add(incorrectLabel);

        JButton exit = new JButton("EXIT");
        exit.setBounds(250, 320, 120, 25);
        exit.setBackground(new Color(255, 200, 0));
        exit.setForeground(Color.WHITE);
        add(exit);

        exit.addActionListener(e -> {
            setVisible(false);
            new Login(); // back to login page
        });

        ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("icons/scorebg.jpg"));
        Image i = icon2.getImage().getScaledInstance(750, 550, Image.SCALE_DEFAULT);
        ImageIcon img = new ImageIcon(i);
        JLabel images = new JLabel(img);
        images.setBounds(0, 0, 750, 550);
        add(images);

        setVisible(true);
    }

    public static void main(String[] args) {
        Score sc = new Score("User", 0, 0, 0);
    }
}
