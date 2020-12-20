import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.sql.*;

public class ReqBook extends login {
    private JTextField textField;
     JTextField textField_sub;

    private JTextArea textArea;
    private JTextArea textArea_1;
    private JTextArea textArea_2;
    Border border = BorderFactory.createLineBorder(Color.GRAY);

    public static void main(String p) {
        if (p.equals("pass")) {
            EventQueue.invokeLater(() -> {
                        try {
                            ReqBook window = new ReqBook();
                            window.frame.setVisible(true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
            );
        } else {
            login.main(null);
        }
    }

    public ReqBook() {
        ReqBookGUI();
    }

    public void ReqBookGUI() {
        welcome();
        Label("Request page");

        textField = new JTextField();
        textField.setBounds(10, 100, 204, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JButton button = new JButton("Search");
        button.addActionListener(e ->  {
                    if(textField.getText().isEmpty())
                    {
                        JOptionPane.showMessageDialog(frame,"Invalid Input!","Error!",JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    try {
                        String BookTitle = textField.getText();
                        boolean Search = false;
                        Class.forName(driver);
                        Connection con = DriverManager.getConnection(url, privilages, password);
                        Statement stm = con.createStatement();
                        ResultSet rs = stm.executeQuery("SELECT DISTINCT * FROM `books` where Title = '"+BookTitle+"' ");
                        System.out.println(rs);
                        while(rs.next()){
                            textArea.append(rs.getInt("BID") + "\n");
                            textArea_1.append(rs.getString("Title") + "\n");
                            textArea_2.append(rs.getString("Author") + "\n");
                            Search = true;
                        }

                        if (!Search ) {
                            JOptionPane.showMessageDialog(frame, "Book not found!", "Error!", JOptionPane.ERROR_MESSAGE);
                        }

                    } catch (Exception t) {
                        t.printStackTrace();
                    }

                }
        );
        button.setBounds(300, 100, 80, 23);
        frame.getContentPane().add(button);

        JLabel lblBookId = new JLabel(" Book Title ");
        lblBookId.setHorizontalAlignment(SwingConstants.CENTER);
        lblBookId.setBounds(180, 95, 150, 29);
        frame.getContentPane().add(lblBookId);

        JLabel lblId = new JLabel("ID");
        lblId.setHorizontalAlignment(SwingConstants.CENTER);
        lblId.setBounds(20, 120, 40, 29);
        frame.getContentPane().add(lblId);

        JLabel lblBookTitle = new JLabel("Title");
        lblBookTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblBookTitle.setBounds(82, 120, 179, 29);
        frame.getContentPane().add(lblBookTitle);

        JLabel lblAuthor = new JLabel("Author");
        lblAuthor.setHorizontalAlignment(SwingConstants.CENTER);
        lblAuthor.setBounds(271, 120, 136, 29);
        frame.getContentPane().add(lblAuthor);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 150, 50, 60);
        frame.getContentPane().add(scrollPane);
        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);
        textArea.setEditable(false);
        textArea.setBorder(border);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(70, 150, 200, 60);
        frame.getContentPane().add(scrollPane_1);
        textArea_1 = new JTextArea();
        scrollPane_1.setViewportView(textArea_1);
        textArea_1.setEditable(false);
        textArea_1.setBorder(border);

        JScrollPane scrollPane_2 = new JScrollPane();
        scrollPane_2.setBounds(280, 150, 160, 60);
        frame.getContentPane().add(scrollPane_2);
        textArea_2 = new JTextArea();
        scrollPane_2.setViewportView(textArea_2);
        textArea_2.setEditable(false);
        textArea_2.setBorder(border);

        textField_sub = new JTextField();
        textField_sub.setBounds(10, 225, 204, 20);
        frame.getContentPane().add(textField_sub);
        textField_sub.setColumns(10);

        JButton button_sub = new JButton("Submit Book Id");
        button_sub.addActionListener(e -> {
        //add event listener;
        }
        );
        button_sub.setBounds(240, 220, 120, 23);
        frame.getContentPane().add(button_sub);

        JButton button_1 = new JButton("Back");
        button_1.addActionListener( e ->  {
                    frame.dispose();
                    user.main("pass");
                }
        );
        button_1.setBounds(322, 258, 87, 23);
        frame.getContentPane().add(button_1);






    }
}


