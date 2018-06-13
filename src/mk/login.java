package mk;

/**
 *
 * @author Shagayegh
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class login implements ActionListener {

    private final int hGap = 20;
    private final int vGap = 20;
     JFrame jf;
    private JButton login, cancel;
    private JTextField username, password;
    private JLabel lname, lpass;

    login() {
        jf = new JFrame();

        JPanel contentpane = new JPanel(new BorderLayout(hGap, vGap));
        contentpane.setBorder(BorderFactory.createEmptyBorder(hGap, vGap, hGap, vGap));
        contentpane.setBorder(BorderFactory.createTitledBorder("Login Form"));
        contentpane.setOpaque(true);
        contentpane.setBackground(Color.YELLOW);
        //panel of textfields and labels
        JPanel txtarea = new JPanel(new GridLayout(2, 1, hGap, vGap));
        JPanel lblarea = new JPanel(new GridLayout(2, 1, hGap, vGap));
        //labels
        lname = new JLabel("Username");
        lpass = new JLabel("Password");
        lblarea.add(lname);
        lblarea.add(lpass);

        //Textfields
        username = new JTextField();
        username.setPreferredSize(new Dimension(150, 30));
        password = new JTextField();
        password.setPreferredSize(new Dimension(150, 30));
        txtarea.add(username);
        txtarea.add(password);
        contentpane.add(txtarea, BorderLayout.CENTER);
        contentpane.add(lblarea, BorderLayout.LINE_START);

        //Buttons
        JPanel btnarea = new JPanel(new GridLayout(1, 1, hGap, vGap));
        login = new JButton("Login");
        login.setPreferredSize(new Dimension(150, 30));
        login.addActionListener(this);
        cancel = new JButton("Cancel");
        cancel.setPreferredSize(new Dimension(150, 30));
        cancel.addActionListener(this);
        btnarea.add(login);
        btnarea.add(cancel);
        contentpane.add(btnarea, BorderLayout.PAGE_END);
        contentpane.setComponentOrientation(java.awt.ComponentOrientation.LEFT_TO_RIGHT);
        //setting contentpane on frame 
        jf.setContentPane(contentpane);
        jf.setLocationByPlatform(true);
        jf.setVisible(true);
        jf.pack();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            
          new fetchData();
        } else if (e.getSource() == cancel) {
               new btnCancel(jf);
          
        }
    }

    public void loginProcess() {

    }

    public static void main(String args[]) {
        new login();

    }

}
