package quiz.app;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Login extends JFrame implements ActionListener {
    JButton Back, Next;
    JTextField text;

    public Login(){
        setTitle("My Quiz Game");
        setSize(1000,500); // frame size
        setLocation(200, 150); // for set frame location(center or anywhere)
        setUndecorated(true);

        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icons/background.jpeg"));
        Image i = icon1.getImage().getScaledInstance(550, 500,Image.SCALE_DEFAULT); // scale up
        ImageIcon icon2 = new ImageIcon(i);
        JLabel img = new JLabel(icon2); // for visible image in my frame
        img.setBounds(450,0,550,500);
        add(img);

        JLabel heading = new JLabel("QUIZ TEST");
        heading.setBounds(140,60,300,45);
        heading.setFont(new Font("", Font.BOLD, 40));
        heading.setForeground(new Color(255,200,0)); // change font color
        add(heading);

        JLabel name = new JLabel("Enter Your Name");
        name.setBounds(160,150,300,20);
        name.setFont(new Font("", Font.BOLD, 18));
        name.setForeground(new Color(255,200,0));
        add(name);

        text = new JTextField();
        text.setBounds(80,200,300,25);
        text.setFont(new Font("Times New Roman", Font.BOLD,18));
        add(text);

        Back = new JButton("Back");
        Back.setBounds(100,270,120,25);
        Back.setBackground(new Color(255,200,0));
        Back.setForeground(Color.WHITE);
        Back.addActionListener(this); // for button click
        add(Back);

        Next = new JButton("Next");
        Next.setBounds(250,270,120,25);
        Next.setBackground(new Color(255,200,0));
        Next.setForeground(Color.WHITE);
        Next.addActionListener(this);
        add(Next);

        getContentPane().setBackground(Color.WHITE); // for my frame background change
        setLayout(null); // remove default borders
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Next) {
            String name = text.getText();
            setVisible(false);
            new Rules(name);
        }else if (e.getSource() == Back) {
            System.exit(51);
        }
    }
    public static void main(String[] args) {

        new Login();
    }
}
