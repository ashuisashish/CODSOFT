package quiz.app;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {

    String ques[][] = new String[10][5];
    String ans[][] = new String[10][2];
    String userAns[][] = new String[10][1];
    JLabel qno, question;
    JRadioButton op1, op2, op3, op4;
    ButtonGroup gpOptions;
    JButton submit,next;

    public static int count = 0;
    public static int score = 0;
    public static int timer = 20;
    public static int ans_given = 0;

    String name;
    Quiz(String name) {
        this.name = name;
        setBounds(50, 0, 1300, 750);
        getContentPane().setBackground(Color.WHITE); // frame background change

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1300, 300);
        add(image);

        qno = new JLabel();
        qno.setBounds(100, 350, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);

        question = new JLabel();
        question.setBounds(150, 350, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);

        ques[0][0] = "Number of primitive data types in Java are.?";
        ques[0][1] = "6";
        ques[0][2] = "7";
        ques[0][3] = "8";
        ques[0][4] = "9";

        ques[1][0] = "What is the size of float and double in java.?";
        ques[1][1] = "32 and 64";
        ques[1][2] = "32 and 32";
        ques[1][3] = "64 and 64";
        ques[1][4] = "64 and 32";

        ques[2][0] = "Automatic type conversion is possible in which of the possible cases?";
        ques[2][1] = "Byte to int";
        ques[2][2] = "Int to Long";
        ques[2][3] = "Long to int";
        ques[2][4] = "Short to int";

        ques[3][0] = "When an array is passed to a method, what does the method receive?";
        ques[3][1] = "The reference of the array";
        ques[3][2] = "A copy of the array";
        ques[3][3] = "Length of the array";
        ques[3][4] = "Copy of first element";

        ques[4][0] = "Arrays in java are.?";
        ques[4][1] = "Object References";
        ques[4][2] = "Objects";
        ques[4][3] = "Primitive data type";
        ques[4][4] = "None";

        ques[5][0] = "When is the object created with new keyword?";
        ques[5][1] = "At rum time";
        ques[5][2] = "At compile time";
        ques[5][3] = "Depends on the code";
        ques[5][4] = "None";

        ques[6][0] = "Identify the corrected definition of a package.?";
        ques[6][1] = "A package is a collection of editing tools";
        ques[6][2] = "A package is a collection of Classes";
        ques[6][3] = "A package is a collection of Classes and interfaces";
        ques[6][4] = "A package is a collection of interfaces";

        ques[7][0] = "compareTo() returns";
        ques[7][1] = "True";
        ques[7][2] = "False";
        ques[7][3] = "An int value";
        ques[7][4] = "None";

        ques[8][0] = "To which of the following does the class string belong to.";
        ques[8][1] = "java.lang";
        ques[8][2] = "java.awt";
        ques[8][3] = "java.applet";
        ques[8][4] = "java.String";

        ques[9][0] = "Total constructor string class have.?";
        ques[9][1] = "3";
        ques[9][2] = "7";
        ques[9][3] = "13";
        ques[9][4] = "20";

        ans[0][1] = "8";
        ans[1][1] = "32 and 64";
        ans[2][1] = "Int to Long";
        ans[3][1] = "The reference of the array";
        ans[4][1] = "Objects";
        ans[5][1] = "At rum time";
        ans[6][1] = "A package is a collection of Classes and interfaces";
        ans[7][1] = "An int value";
        ans[8][1] = "java.lang";
        ans[9][1] = "13";

        op1 = new JRadioButton();
        op1.setBounds(170, 400, 700, 30);
        op1.setBackground(Color.WHITE);
        op1.setFont(new Font("Dialog1", Font.PLAIN, 20));
        add(op1);

        op2 = new JRadioButton();
        op2.setBounds(170, 440, 700, 30);
        op2.setBackground(Color.WHITE);
        op2.setFont(new Font("Dialog2", Font.PLAIN, 20));
        add(op2);

        op3 = new JRadioButton();
        op3.setBounds(170, 480, 700, 30);
        op3.setBackground(Color.WHITE);
        op3.setFont(new Font("Dialog3", Font.PLAIN, 20));
        add(op3);

        op4 = new JRadioButton();
        op4.setBounds(170, 520, 700, 30);
        op4.setBackground(Color.WHITE);
        op4.setFont(new Font("Dialog4", Font.PLAIN, 20));
        add(op4);

        gpOptions = new ButtonGroup();
        gpOptions.add(op1);
        gpOptions.add(op2);
        gpOptions.add(op3);
        gpOptions.add(op4);

        next = new JButton("Next");
        next.setBounds(600, 600, 200, 30);
        next.setFont(new Font("Tahoma", Font.PLAIN, 18));
        next.setBackground(new Color(22, 99, 54));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        submit = new JButton("Submit");
        submit.setBounds(850, 600, 200, 30);
        submit.setForeground(Color.BLACK);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 18));
        submit.setBackground(new Color(255, 215, 0));
        submit.setEnabled(false);
        submit.addActionListener(this);
        add(submit);

        start(count);
        setUndecorated(true);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            op1.setEnabled(true);
            op2.setEnabled(true);
            op3.setEnabled(true);
            op4.setEnabled(true);

            ans_given = 1;
            if (gpOptions.getSelection() == null) {
                userAns[count][0] = "";
            } else {
                userAns[count][0] = gpOptions.getSelection().getActionCommand();
            }

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            count++;
            start(count);
        }
        else if (ae.getSource() == submit) {
            ans_given = 1;
            if (gpOptions.getSelection() == null) {
                userAns[count][0] = "";
            } else {
                userAns[count][0] = gpOptions.getSelection().getActionCommand();
            }

            for (int i = 0; i < userAns.length; i++) {
                if (userAns[i][0].equals(ans[i][1])) {
                    score += 10;
                } else {
                    score += 0;
                }
            }
            setVisible(false);
            new Score(name, score);
        }
    }

    public void paint(Graphics g) {
        super.paint(g);

        String time = "Time left - " + timer + " seconds"; // 20
        g.setColor(Color.RED);
        g.setFont(new Font("", Font.BOLD, 25));

        if (timer > 0) {
            g.drawString(time, 1000, 500);
        } else {
            g.drawString("Times up!", 1000, 500);
        }

        timer--;

        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (ans_given == 1) {
            ans_given = 0;
            timer = 20;
        } else if (timer < 0) {
            timer = 20;
            op1.setEnabled(true);
            op2.setEnabled(true);
            op3.setEnabled(true);
            op4.setEnabled(true);

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) { // submit button
                if (gpOptions.getSelection() == null) {
                    userAns[count][0] = "";
                } else {
                    userAns[count][0] = gpOptions.getSelection().getActionCommand();
                }

                for (int i = 0; i < userAns.length; i++) {
                    if (userAns[i][0].equals(ans[i][1])) {
                        score += 10;
                    } else {
                        score += 0;
                    }
                }
                setVisible(false);
                new Score(name, score);
            } else { // next button
                if (gpOptions.getSelection() == null) {
                    userAns[count][0] = "";
                } else {
                    userAns[count][0] = gpOptions.getSelection().getActionCommand();
                }
                count++;
                start(count);
            }
        }
    }

    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText(ques[count][0]);
        op1.setText(ques[count][1]);
        op1.setActionCommand(ques[count][1]);

        op2.setText(ques[count][2]);
        op2.setActionCommand(ques[count][2]);

        op3.setText(ques[count][3]);
        op3.setActionCommand(ques[count][3]);

        op4.setText(ques[count][4]);
        op4.setActionCommand(ques[count][4]);

        gpOptions.clearSelection();
    }

    public static void main(String[] args) {
        new Quiz("User");
    }
}
