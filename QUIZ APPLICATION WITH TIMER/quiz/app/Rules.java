package quiz.app;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Rules extends JFrame implements ActionListener {
    JButton Start, Back;
    String name;
    Rules(String name){
        this.name = name;
        setTitle("Rules");
        setSize(800,600);
        setLocation(300, 100);
        setLayout(null);
        setUndecorated(true);

        JLabel heading = new JLabel("Welcome " +name+ " to QUIZ TEST");
        heading.setBounds(250,100,700,20);
        heading.setFont(new Font("", Font.BOLD, 20));
        heading.setForeground(new Color(22,99,54));
        add(heading);

        JLabel rules = new JLabel();
        rules.setBounds(175,133,700,350);
        rules.setFont(new Font("", Font.PLAIN, 16));
        rules.setForeground(new Color(22,99,54));
        rules.setText(
                "<html>" +
                        "1. Participation in the quiz is free and open to all." +"<br><br>"+
                        "2. There are total 10 questions. "+"<br><br>"+
                        "3. You only have 10 seconds to answer the question." + "<br><br>"+
                        "4. Cell phones and other secondary devices are not allowed." +"<br><br>"+
                        "5. No talking and no head downs." +"<br><br>"+
                        "6. Look only the screen don't try to look around."+"<br><br>"+
                        "7. No one else can be in the room with you."+"<br><br>"+
                        "<html>"
        );
        add(rules);

        Back = new JButton("Back");
        Back.setBounds(280,460,100,30);
        Back.setBackground(new Color(22,99,54));
        Back.setForeground(Color.WHITE);
        Back.addActionListener(this);
        add(Back);

        Start = new JButton("Start");
        Start.setBounds(430,460,100,30);
        Start.setBackground(new Color(22,99,54));
        Start.setForeground(Color.WHITE);
        Start.addActionListener(this);
        add(Start);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bg2.jpg"));
        Image i = i1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i);
        JLabel image = new JLabel(i2);
        image.setBounds(0,0,800,600);
        add(image);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Start) {
            setVisible(false);
            new Quiz(name);
        }else {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        Rules rules = new Rules("User");

    }
}