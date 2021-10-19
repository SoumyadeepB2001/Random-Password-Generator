import java.util.Scanner;
import java.awt.event.*;
import javax.swing.*;

public class PasswordGenerator extends JFrame implements ActionListener, KeyListener {
    JFrame f = new JFrame("Password Generator");
    JButton submitButton, clearButton;
    JTextField t;
    JTextField tt;

    PasswordGenerator() {
        JLabel lb0 = new JLabel("Enter the required length of your password:");
        JLabel lb1 = new JLabel("Your new password is:");
        t = new JTextField(50);
        tt = new JTextField(50);
        tt.setEditable(false);
        submitButton = new JButton("Submit");
        clearButton = new JButton("Clear");
        lb0.setBounds(75, 50, 1000, 30);
        lb1.setBounds(75, 90, 1000, 30);
        t.setBounds(400, 50, 200, 30);
        tt.setBounds(400, 90, 400, 30);
        submitButton.setBounds(315, 170, 80, 30);
        clearButton.setBounds(420, 170, 80, 30);
        t.addKeyListener(this);
        submitButton.addActionListener(this);
        clearButton.addActionListener(this);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.add(lb0);
        f.add(t);
        f.add(submitButton);
        f.add(clearButton);
        f.add(tt);
        f.setSize(830, 300);
        f.add(lb1);
        f.setLayout(null);
        f.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent evt) {
        if ((evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') || evt.getKeyChar() == '\b') {
            t.setEditable(true);
        } else {
            t.setEditable(false);
            JOptionPane.showMessageDialog(null, "Enter a numerical value");
        }
    }

    @Override
    public void keyPressed(KeyEvent evt) {
    }

    @Override
    public void keyReleased(KeyEvent evt) {
    }

    public void actionPerformed(ActionEvent evt) {

        if (evt.getSource() == submitButton) {
            char ch[] = new char[94];
            for (int i = 33; i <= 126; i++)
                ch[i - 33] = (char) i;
            String pass = "";
            Scanner sc = new Scanner(System.in);
            String s = t.getText();
            if (!s.equals("")) {
                int n = Integer.parseInt(s);
                for (int i = 0; i < n; i++) {
                    int rnd = (int) (Math.random() * ch.length);
                    pass = pass + ch[rnd];
                }
                tt.setText(pass);
                tt.setEditable(true);
            } else
                JOptionPane.showMessageDialog(null, "Enter the length of your password");
        }

        else {
            t.setText("");
            tt.setText("");
            tt.setEditable(false);
        }

    }

    public static void main(String args[]) {
        new PasswordGenerator();
    }
}