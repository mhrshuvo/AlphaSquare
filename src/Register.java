import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Register extends login{

    JButton btnNewButton;
    private JButton btnBack;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
                try {
                    Register window = new Register();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        );
    }

    public Register() {

        RegisterGUI();

    }

    public void RegisterGUI() {

        frame = new JFrame("Create An Account");
        frame.setBounds(100, 100, 450, 341);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblCreateAnAccount = new JLabel("Create An Account");
        lblCreateAnAccount.setFont(new Font("", Font.BOLD, 18));
        lblCreateAnAccount.setBounds(135, 25, 173, 27);
        frame.getContentPane().add(lblCreateAnAccount);

        JLabel lblLoginOrRegister = new JLabel("Register or");
        lblLoginOrRegister.setFont(new Font("", Font.BOLD, 15));
        lblLoginOrRegister.setBounds(101, 56, 113, 29);
        frame.getContentPane().add(lblLoginOrRegister);

        JLabel lblRegister = new JLabel("Login to your Account");
        lblRegister.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                login.main(null);
                frame.dispose();
            }
        });
        lblRegister.setForeground(Color.BLUE);
        lblRegister.setFont(new Font("", Font.BOLD, 15));
        lblRegister.setBounds(193, 56, 179, 29);
        frame.getContentPane().add(lblRegister);

        txtUserName = new JTextField();
        txtUserName.addFocusListener(new FocusAdapter() {

            @Override
            public void focusGained(FocusEvent e) {
                txtUserName.selectAll();
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(txtUserName.getText().isEmpty()){
                    txtUserName.setText("User Name");
                }
            }
        });
        txtUserName.setFont(new Font("", Font.PLAIN, 15));
        txtUserName.setText("User Name");
        txtUserName.setBounds(101, 94, 239, 27);
        frame.getContentPane().add(txtUserName);
        txtUserName.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setToolTipText("");
        passwordField.setFont(new Font("", Font.PLAIN, 15));
        passwordField.setBounds(101, 132, 239, 27);
        char passwordChar;
        passwordChar = passwordField.getEchoChar();
        passwordField.setEchoChar((char) 0);
        passwordField.setText("Password");
        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                passwordField.setText("");
                passwordField.setEchoChar(passwordChar);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(passwordField.getPassword().length == 0){
                    passwordField.setText("Password");
                    passwordField.setEchoChar((char) 0);
                }
            }
        });
        frame.getContentPane().add(passwordField);

        txtName = new JTextField();
        txtName.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                txtName.setText("");
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(txtName.getText().isEmpty()){
                    txtName.setText("Name");
                }
            }
        });
        txtName.setText("Name");
        txtName.setFont(new Font("", Font.PLAIN, 15));
        txtName.setColumns(10);
        txtName.setBounds(101, 173, 239, 27);
        frame.getContentPane().add(txtName);

        txtEmail = new JTextField();
        txtEmail.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                txtEmail.setText("");
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(txtEmail.getText().isEmpty()){
                    txtEmail.setText("Email");
                }
            }
        });
        txtEmail.setText("Email");
        txtEmail.setFont(new Font("", Font.PLAIN, 15));
        txtEmail.setColumns(10);
        txtEmail.setBounds(101, 211, 239, 27);
        frame.getContentPane().add(txtEmail);

        btnNewButton = new JButton("Register");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String username = txtUserName.getText().trim();
                String password = new String(passwordField.getPassword());
                String name = txtName.getText().trim();
                String email = txtEmail.getText().trim();
              //  File log = new File("UserDatabase.txt");
              //  String line;

                try {
                    /*       ----mhrshuvo----
                ###### Text file DATABASE ######
                     ----mhrshuvo----       */
                    /*
                    BufferedReader Reader = new BufferedReader(new FileReader("UserDatabase.txt"));

                    while((line = Reader.readLine())!= null){
                        String[] array = line.split(",");

                        if(array[0].equals(username) || array[3].equals(email)){
                            JOptionPane.showMessageDialog(frame,"User existed!","Error!",JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                try{
                    if(!log.exists()){
                        log.createNewFile();
                    }

                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(log,true));
                    bufferedWriter.write(username + "," + password + "," + name + "," + email);
                    bufferedWriter.newLine();
                    bufferedWriter.close();
                    JOptionPane.showMessageDialog(frame,"Registration is successful!");

                     */

             /*       ----mhrshuvo----
                ###### SQL DATABASE ######
                     ----mhrshuvo----       */

                    String driverName = "com.mysql.jdbc.Driver";
                    Class.forName(driverName);
                    String serverName = "localhost:3306";
                    String mydatabase = "lbms_alpha";
                    String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
                    String DBusername = "root";
                    String DBpassword = "";
                    Connection con = DriverManager.getConnection(url, DBusername, DBpassword);
                    System.out.println("Connected");
                    Statement stm = con.createStatement();
                    String user = "INSERT INTO `UserDb` VALUES ( null,'"+username+"', '"+password+"', '"+email+"')";
                    System.out.println(user);
                    stm.executeUpdate(user);
                    System.out.println("insert done");
                    loginDriver.main("User");

                } catch(Exception n) {
                }

            }
        });
        btnNewButton.setFont(new Font("", Font.BOLD, 15));
        btnNewButton.setBounds(121, 258, 100, 27);
        frame.getContentPane().add(btnNewButton);

        btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginDriver.main("User");
                frame.dispose();
            }
        });
        btnBack.setFont(new Font("", Font.BOLD, 15));
        btnBack.setBounds(231, 258, 100, 27);
        frame.getContentPane().add(btnBack);

    }

}

