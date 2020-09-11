import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class user extends login{

    public static void main(String p) {
        if(p=="pass"){
            EventQueue.invokeLater(() -> {
                    try {
                        user window = new user();
                        window.frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            );
        } else{
            login.main(null);
        }

    }

    public user() {
        UserPageGUI();
    }

    private void UserPageGUI() {

        welcome();
        Label("User page");

        JButton button = new JButton("Search for Book");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                frame.dispose();
                SearchBook.main("pass");
            }
        });
        button.setBounds(108, 108, 207, 23);
        frame.getContentPane().add(button);

        JButton  RequestBook= new JButton("Request for Book");
        RequestBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                frame.dispose();
              ReqBook.main("pass");

            }
        });
        RequestBook.setBounds(108, 142, 207, 23);
        frame.getContentPane().add(RequestBook);

        JButton btnComplaints = new JButton("Feedback");
        btnComplaints.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                frame.dispose();
                Feedback.main("pass");
            }
        });
        btnComplaints.setBounds(108, 175, 207, 23);
        frame.getContentPane().add(btnComplaints);

        JButton button_1 = new JButton("Log Out");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                frame.dispose();
                login.main(null);
            }
        });
        button_1.setBounds(108, 209, 207, 23);
        frame.getContentPane().add(button_1);
    }
}
