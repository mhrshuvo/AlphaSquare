import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class vendor extends login{

    public static void main(String p) {
        if(p == "pass"){
            EventQueue.invokeLater(() -> {
                    try {
                        vendor window = new vendor();
                        window.frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            );
        }

    }

    public vendor() {
        VendorPageGUI();
    }

    private void VendorPageGUI() {
        welcome();

        JLabel lblUserPage = new JLabel("Vendor Page");
        lblUserPage.setHorizontalAlignment(SwingConstants.CENTER);
        lblUserPage.setBounds(121, 66, 188, 29);
        frame.getContentPane().add(lblUserPage);

        JButton button = new JButton("Supply Book");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                frame.dispose();
                SupplyBook.main(null);
            }
        });

        button.setBounds(108, 108, 207, 23);
        frame.getContentPane().add(button);

        JButton button_1 = new JButton("Log Out");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                frame.dispose();
                login.main(null);
            }
        });
        button_1.setBounds(108, 142, 207, 23);
        frame.getContentPane().add(button_1);
    }

}
