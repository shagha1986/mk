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

public class MK_Login extends JFrame implements ActionListener {

    private final int hGap = 20;
    private final int vGap = 20;

    private String[] borderConstraints = {
        BorderLayout.LINE_START,
        BorderLayout.LINE_END,};

    private JPanel borderPanel;
    private JButton[] buttons;
    private JFrame jf;
    private JLabel txt;

    private MK_Login() {

        jf = new JFrame();
        buttons = new JButton[2];
        String[] names = {"Login", "Register"};
        JPanel contentpane = new JPanel(new GridLayout(0, 1, hGap, vGap));
        contentpane.setBorder(BorderFactory.createEmptyBorder(hGap, vGap, hGap, vGap));//khalafe jahate aghrabe haye saat top left bottom right
        borderPanel = new JPanel(new BorderLayout(hGap, vGap));
        borderPanel.setBorder(BorderFactory.createTitledBorder("Login Box"));
        borderPanel.setOpaque(true);
        borderPanel.setBackground(Color.WHITE);
        txt = new JLabel("Please Login to continue.\nOr Register.");

        for (int i = 0; i < 2; i++) {
            buttons[i] = new JButton(names[i]);
            buttons[i].setPreferredSize(new Dimension(100, 50));
            buttons[i].addActionListener(this);
            borderPanel.add(buttons[i], borderConstraints[i]);

        }

        txt = new JLabel("Please Login to continue.\nOr Register.");
        borderPanel.add(txt, BorderLayout.PAGE_START);

        contentpane.add(borderPanel);
        jf.setContentPane(contentpane);
        jf.setLocationByPlatform(true);
        jf.setVisible(true);
        jf.pack();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            if (((JButton) e.getSource()).getText() == "Login") {
                new login();
            } else {
                new Register();
            }
        }
    }

    public static void main(String args[]) {
        new MK_Login();

    }

}
