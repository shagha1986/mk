/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mk;

/**
 *
 * @author Shagayegh
 */
import static com.mchange.v2.c3p0.impl.C3P0Defaults.password;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import org.hibernate.Session;
import entity.Tregister;
import java.util.Date;
import org.hibernate.Transaction;//alt +shift+i

public class Register implements ActionListener {

    static private int id;
    static public String rname;
    static public String rlastname;
    static public String remail;
    static public int rage;
    static public String rphone;
    static public Date rregisterDate;
    static public Date rlastLogin;
    static public String rusername;
    static public String rpassword;

    private final int hGap = 20;
    private final int vGap = 20;
    private JLabel[] labels;
    private JTextField[] fields;
    private JButton register, cancel;
    private JPanel labelPanel, txtfieldPanel;

    JFrame jf;
    static Session session = null;

    Register() {
        jf = new JFrame();
        labels = new JLabel[8];
        fields = new JTextField[8];
        register = new JButton("Register!");
        register.setPreferredSize(new Dimension(150, 30));
        register.addActionListener(this);
        cancel = new JButton("Cancel");
        cancel.setPreferredSize(new Dimension(150, 30));
        cancel.addActionListener(this);
        //register cancel area
        JPanel rcArea = new JPanel(new GridLayout(1, 1, hGap, vGap));
        //may be i should remove Lnames ...mal sehen 
        String[] Lnames = {"Name", "Lastname", "Age", "Phone", "Username", "Password", "Retype Password", "Email"};
        JPanel contentpane = new JPanel(new BorderLayout(hGap, vGap));
        labelPanel = new JPanel(new GridLayout(8, 1, hGap, vGap));
        //labelPanel.setBackground(Color.red);
        txtfieldPanel = new JPanel(new GridLayout(8, 1, hGap, vGap));
        //txtfieldPanel.setBackground(Color.CYAN);
        contentpane.setBorder(BorderFactory.createEmptyBorder(hGap, vGap, hGap, vGap));
        contentpane.setBorder(BorderFactory.createTitledBorder("Register Form"));
        labelPanel.setOpaque(true);
        txtfieldPanel.setOpaque(true);
        contentpane.setBackground(Color.orange);

        try {
            for (int i = 0; i < labels.length; i++) {
                //labels
                labels[i] = new JLabel(Lnames[i]);
                labelPanel.add(labels[i], BorderLayout.LINE_START);
                //Textfields
                fields[i] = new JTextField();
                fields[i].setPreferredSize(new Dimension(150, 30));
                txtfieldPanel.add(fields[i], BorderLayout.CENTER);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
        contentpane.add(labelPanel, BorderLayout.LINE_START);
        contentpane.add(txtfieldPanel, BorderLayout.CENTER);
        rcArea.add(register);
        rcArea.add(cancel);
        //contentpane.add(register, BorderLayout.PAGE_END);
        contentpane.add(rcArea, BorderLayout.PAGE_END);
        jf.setContentPane(contentpane);
        jf.setLocationByPlatform(true);
        jf.setVisible(true);
        jf.pack();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String[] Lnames = {"Name", "Lastname", "Age", "Phone", "Username", "Password", "Retype Password", "Email"};

        if (e.getSource() == register) {
            rname = fields[0].getText();
            rlastname = fields[1].getText();
            rage = Integer.parseInt(fields[2].getText());
            rphone = fields[3].getText();
            rusername = fields[4].getText();
            rpassword = fields[5].getText();
            rregisterDate = new Date();
            remail = fields[7].getText();
            Tregister tr = new Tregister(1, rname, rlastname, remail, rage, rphone, new Date(), new Date(), rusername, rpassword);
            insert(tr);

        }

//            if (fields[5].getText().equals(fields[6].getText())) {
//                password = fields[5].getText();
//            }
//        }
//        else if (e.getSource() == cancel) {
//        }
    }

    public static void insert(Tregister r) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(r);
        t.commit();//transaction is committed  
        System.out.println("donecxcxcxcxcxcxc");
        session.close();
    }

    public static void main(String args[]) {

        System.out.println(rname);

        new Register();
        System.out.println(rname);
        System.out.println(rlastname);
        System.out.println(remail);

    }

}
