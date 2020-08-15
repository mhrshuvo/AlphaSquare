import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class login {

    JFrame frame;
    JTextField txtUserName ,txtName,txtEmail;
    JPasswordField passwordField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    login window = new login();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public login() {
        loginGUI();
    }

    public void welcome(){
        frame = new JFrame("IUBAT team AlphaSquare");
        frame.setBounds(100, 100, 470, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        ImageIcon i = new ImageIcon("IUBAT.png");
        JLabel Welcome = new JLabel("Welcome To IUBAT Library Management System",i,SwingConstants.HORIZONTAL);
        Welcome.setFont(new Font("", Font.BOLD, 16));
        Welcome.setBounds(27, 27, 397, 35);
        frame.getContentPane().add(Welcome);
    }
    public void successful(){
        ImageIcon i = new ImageIcon("download.png");
        JOptionPane.showMessageDialog(frame,"Welcome to IUBAT Library Management System","login Successfull",JOptionPane.PLAIN_MESSAGE,i);
    }
    public void error(){
        ImageIcon i = new ImageIcon("download.png");
        JOptionPane.showMessageDialog(frame,"Invalid Username or Password","Error!",JOptionPane.ERROR_MESSAGE,i);
    }

    public void loginGUI() {
        welcome();

        JLabel LIS = new JLabel("Log in as");
        LIS.setHorizontalAlignment(SwingConstants.CENTER);
        LIS.setFont(new Font("", Font.BOLD, 16));
        LIS.setForeground(Color.blue);
        LIS.setBounds(20, 60, 397, 29);
        frame.getContentPane().add(LIS);


        //librarian button
        JButton Librarian = new JButton("Librarian");
        Librarian.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(" librarian button pressed");
               // loginDriver.main("Librarian");
                frame.dispose();
            }
        });
        Librarian.setFont(new Font("", Font.BOLD, 14));
        Librarian.setBounds(120, 105, 200, 30);
        frame.getContentPane().add(Librarian);

        //Vendor button
        JButton Vendor = new JButton("Vendor");
        Vendor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("vendor button pressed");
              //  loginDriver.main("Vendor");
                frame.dispose();
            }
        });
        Vendor.setFont(new Font("", Font.BOLD, 15));
        Vendor.setBounds(120, 145, 198, 29);
        frame.getContentPane().add(Vendor);

        //user button
        JButton User = new JButton("User");
        User.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(" librarian button pressed");
             //   loginDriver.main("User");
                frame.dispose();
            }
        });
        User.setFont(new Font("", Font.BOLD, 15));
        User.setBounds(120, 185, 198, 29);
        frame.getContentPane().add(User);

        //admin
        JButton Admin = new JButton("Admin");
        Admin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(" Admin button pressed");
                //   loginDriver.main("Admin");
                frame.dispose();
            }
        });
        Admin.setFont(new Font("", Font.BOLD, 15));
        Admin.setBounds(120, 225, 198, 29);
        frame.getContentPane().add(Admin);

    }

}

