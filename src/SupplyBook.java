import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class SupplyBook extends login {

    JTextField textField;
    JTextField textField_1;
    JTextField textField_2;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SupplyBook window = new SupplyBook();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public SupplyBook() {
        SupplyBookGUI();
    }


    private void SupplyBookGUI() {

        welcome();
        Label("Supply Books");

        JButton btnAddForBook = new JButton("Supply Book");
        btnAddForBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                String BookTitle = textField_1.getText();
                String BookAuthor = textField_2.getText();
                String driver ="com.mysql.jdbc.Driver";
                String url = "jdbc:mysql://localhost:3306/lbms_alpha";
                String privilages = "root";
                String password = "";

                try {
                    Class.forName(driver);
                    Connection con = DriverManager.getConnection(url, privilages, password);
                    Statement stm = con.createStatement();

                    if( textField_1.getText().isEmpty() || textField_2.getText().isEmpty())
                    {
                        JOptionPane.showMessageDialog(frame,"Invalid Input!","Error!",JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    String Nbook = "INSERT INTO `books` VALUES ( null,'"+BookTitle+ "','"+BookAuthor+ "')";
                    stm.executeUpdate(Nbook);
                    JOptionPane.showMessageDialog(frame,"New book added successfully");

                    textField_1.setText(null);
                    textField_2.setText(null);

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        btnAddForBook.setBounds(74, 215, 148, 23);
        frame.getContentPane().add(btnAddForBook);

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                frame.dispose();
                vendor.main("pass");
            }
        });

        btnBack.setBounds(232, 215, 123, 23);
        frame.getContentPane().add(btnBack);



        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(130, 141, 178, 20);
        frame.getContentPane().add(textField_1);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(130, 172, 178, 20);
        frame.getContentPane().add(textField_2);


        JLabel lblTitle = new JLabel("Title");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);

        lblTitle.setBounds(74, 135, 46, 29);
        frame.getContentPane().add(lblTitle);

        JLabel lblAuthor = new JLabel("Author");
        lblAuthor.setHorizontalAlignment(SwingConstants.CENTER);

        lblAuthor.setBounds(50, 166, 84, 29);
        frame.getContentPane().add(lblAuthor);
    }

}
