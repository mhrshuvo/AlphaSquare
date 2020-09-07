import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;



public  class  loginDriver extends login  {

    // main class
    public static void main(String x ) {
        EventQueue.invokeLater(() -> {
            try {
                loginDriver window = new loginDriver(x);
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    } //end main class

    public loginDriver(String x ){
        loginGui(x);
    }



    public void DriveMain(String sa){
        switch (sa) {
            case "Librarian Login": {
                librarian.main(null);
                System.out.println("Librarian Login");
                break;
            }
            case "Vendor Login" : {
                //   vendor.main(null);
                System.out.println("Vendor Login");
                break;
            }
            case "User Login":{
                user.main("pass");
                break;
            }
            case "Admin Login" : {
                //admin.main(null);
                System.out.println("admin Login");
                break;
            }
        }

    }

    void CheckDatabase(String fN , String l ){
        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(e->{
            try {
                    @SuppressWarnings("resource")
                    BufferedReader Reader = new BufferedReader(new FileReader(fN));
                    String username = txtUserName.getText().trim();
                    String password = new String(passwordField.getPassword());

                    String line;

                    while((line = Reader.readLine())!= null){
                        String[] array = line.split(",");

                        if(array[0].equals(username) && array[1].equals(password)){
                            successful();
                            DriveMain(l);
                            frame.dispose();
                            return;
                        }

                    }
                    error();
                }catch (IOException t) {
                    t.printStackTrace();
                }
            }
        );
        btnLogin.setFont(new Font("", Font.BOLD, 15));
        btnLogin.setBounds(119, 194, 102, 23);
        frame.getContentPane().add(btnLogin);

        Label(l);

        JButton btnBack = new JButton("Back\r\n");
        btnBack.addActionListener(e -> {
                login.main(new String[]{});
                frame.dispose();
            }
        );
        btnBack.setFont(new Font("", Font.BOLD, 15));
        btnBack.setBounds(231, 194, 102, 23);
        frame.getContentPane().add(btnBack);
    }

    public  void loginGui(String Driver){

        System.out.println("working" + Driver);
        welcome();

        if(Driver == "User"){ //only user can register

            JLabel lblLoginOr = new JLabel("Login or");
            lblLoginOr.setFont(new Font("", Font.BOLD, 15));
            lblLoginOr.setBounds(115, 90, 59, 29);
            frame.getContentPane().add(lblLoginOr);

            JLabel lblRegister = new JLabel("Register an Account");
            lblRegister.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                //    Register.main(new String[]{});
                    frame.dispose();
                }
            });
            lblRegister.setForeground(Color.BLUE);
            lblRegister.setFont(new Font("", Font.BOLD, 15));
            lblRegister.setBounds(180, 90, 173, 29);
            frame.getContentPane().add(lblRegister);

        }

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
        txtUserName.setBounds(109, 118, 228, 27);
        frame.getContentPane().add(txtUserName);
        txtUserName.setColumns(10);


        passwordField = new JPasswordField();
        passwordField.setToolTipText("");
        passwordField.setFont(new Font("", Font.PLAIN, 15));
        passwordField.setBounds(109, 156, 228, 27);
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



        //********** stopping here 16-aug-2020 ********************

        switch (Driver){
            //password and user name check

            case "Librarian" : {
                String fileN = "LibrarianDatabase.txt";
                CheckDatabase(fileN,"Librarian Login");

                break;
            } // case Librarian end

            case "Vendor" : {
                String fileN = "VendorDatabase.txt";
                CheckDatabase(fileN,"Vendor Login");

                break;
            } //Case vendor end

            case "User" :{
                String fileN = "UserDatabase.txt";
                CheckDatabase(fileN,"User Login");
                break;
            }//case user end
            case "Admin" :{
                String fileN = "AdminDatabase.txt";
                CheckDatabase(fileN,"Admin Login");
                break;
            }//case admin end

        }

    }

}
