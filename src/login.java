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
        frame = new JFrame("AlphaSquare");
        frame.setBounds(100, 100, 470, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground( Color.gray );

        ImageIcon i = new ImageIcon("IUBAT.png");
        JLabel Welcome = new JLabel("Welcome To IUBAT Library Management System",i,SwingConstants.HORIZONTAL);
        Welcome.setFont(new Font("", Font.BOLD, 16));
        Welcome.setBounds(27, 27, 397, 35);
        frame.getContentPane().add(Welcome);
    }
    public void Label( String l){
        JLabel label = new JLabel(String.format("%s", l));
        label.setFont(new Font("", Font.BOLD, 18));
        label.setBounds(153, 65, 200, 29);
        label.setForeground(Color.blue);
        frame.getContentPane().add(label);
    }

    public void successful(){
        ImageIcon i = new ImageIcon("IUBAT.png");
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


        //user button
        JButton User = new JButton("User");
        User.addActionListener( e -> {
                System.out.println(" librarian button pressed");
                loginDriver.main("User");
                frame.dispose();

        });

        User.setBounds(120, 105, 200, 30);
        frame.getContentPane().add(User);

        //librarian button
        JButton Librarian = new JButton("Librarian");
        Librarian.addActionListener( e -> {
                System.out.println(" librarian button pressed");
                loginDriver.main("Librarian");
                frame.dispose();
            }
        );
        Librarian.setBounds(120, 185, 198, 29);
        frame.getContentPane().add(Librarian);

        //Vendor button
        JButton Vendor = new JButton("Vendor");
        Vendor.addActionListener(e -> {
                System.out.println("vendor button pressed");
                loginDriver.main("Vendor");
                frame.dispose();
            }
        );
        Vendor.setBounds(120, 145, 198, 29);
        frame.getContentPane().add(Vendor);


        //admin
        JButton Admin = new JButton("Admin");
        Admin.addActionListener(e -> {
                System.out.println(" Admin button pressed");
                loginDriver.main("Admin");
                frame.dispose();
            }
        );
        Admin.setBounds(120, 225, 198, 29);
        frame.getContentPane().add(Admin);

    }

}

