import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.sql.*;


public class SearchBook extends login{
    private JTextField textField;
    private JTextArea textArea;
    private JTextArea textArea_1;
    private JTextArea textArea_2;
    Border border = BorderFactory.createLineBorder(Color.GRAY);

    public static void main(String p) {
        if(p == "pass") {
            EventQueue.invokeLater(() -> {
                try {
                    SearchBook window = new SearchBook();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        else{
            login.main(null);
        }
    }

    public SearchBook() {
        SearchBookGUI();
    }

    private void SearchBookGUI() {

        String driver ="com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/lbms_alpha";
        String privilages = "root";
        String password = "";

        welcome();
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
                    ResultSet rs = stm.executeQuery("SELECT * FROM `books` where Title = '"+BookTitle+"' ");
                    System.out.println(rs);
                    while(rs.next()){
                              textArea.append(rs.getInt("BID") + "\n");
                              textArea_1.append(rs.getString("Title") + "\n");
                              textArea_2.append(rs.getString("Author") + "\n");
                        Search = true;
                    }

                    if (Search == false) {
                        JOptionPane.showMessageDialog(frame, "Book not found!", "Error!", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (Exception t) {
                    t.printStackTrace();
                }

            }
        );
        button.setBounds(20, 258, 80, 23);
        frame.getContentPane().add(button);

        JButton button_1 = new JButton("Back");
        button_1.addActionListener( e ->  {
                frame.dispose();
                user.main("pass");
            }
        );
        button_1.setBounds(322, 258, 87, 23);
        frame.getContentPane().add(button_1);

        JLabel lblUserPage = new JLabel("Search for Book");
        lblUserPage.setBounds(138, 63, 174, 29);
        lblUserPage.setHorizontalAlignment(SwingConstants.CENTER);
        frame.getContentPane().add(lblUserPage);

        textField = new JTextField();
        textField.setBounds(10, 230, 204, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 116, 50, 103);
        frame.getContentPane().add(scrollPane);

        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);
        textArea.setEditable(false);
        textArea.setBorder(border);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(70, 116, 200, 103);
        frame.getContentPane().add(scrollPane_1);

        textArea_1 = new JTextArea();
        scrollPane_1.setViewportView(textArea_1);
        textArea_1.setEditable(false);
        textArea_1.setBorder(border);

        JScrollPane scrollPane_2 = new JScrollPane();
        scrollPane_2.setBounds(280, 116, 160, 103);
        frame.getContentPane().add(scrollPane_2);

        textArea_2 = new JTextArea();
        scrollPane_2.setViewportView(textArea_2);
        textArea_2.setEditable(false);
        textArea_2.setBorder(border);

        JLabel lblId = new JLabel("ID");
        lblId.setHorizontalAlignment(SwingConstants.CENTER);
        lblId.setBounds(20, 92, 40, 29);
        frame.getContentPane().add(lblId);

        JLabel lblBookTitle = new JLabel("Title");
        lblBookTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblBookTitle.setBounds(82, 92, 179, 29);
        frame.getContentPane().add(lblBookTitle);

        JLabel lblAuthor = new JLabel("Author");
        lblAuthor.setHorizontalAlignment(SwingConstants.CENTER);
        lblAuthor.setBounds(271, 92, 136, 29);
        frame.getContentPane().add(lblAuthor);

        JButton btnClear = new JButton("Clear");
        btnClear.addActionListener(arg0 -> {
                textField.setText(null);
                textArea.setText(null);
                textArea_1.setText(null);
                textArea_2.setText(null);
            }
        );
        btnClear.setBounds(236, 258, 76, 23);
        frame.getContentPane().add(btnClear);

        JButton btnDisplayAll = new JButton("All book");
        btnDisplayAll.addActionListener(e ->  {
                try {

                    Class.forName(driver);
                    Connection con = DriverManager.getConnection(url, privilages, password);
                    Statement stm = con.createStatement();
                    ResultSet rs = stm.executeQuery("SELECT * FROM `books`");
                    System.out.println(rs);
                    while(rs.next()){
                        textArea.append(rs.getInt("BID") + "\n");
                        textArea_1.append(rs.getString("Title") + "\n");
                        textArea_2.append(rs.getString("Author") + "\n");
                    }
                } catch (Exception t) {
                    t.printStackTrace();
                }
            }
        );

        btnDisplayAll.setBounds(107, 258, 119, 23);
        frame.getContentPane().add(btnDisplayAll);

        JLabel lblBookId = new JLabel(" Book Title ");
        lblBookId.setHorizontalAlignment(SwingConstants.CENTER);
        lblBookId.setBounds(213, 225, 211, 29);
        frame.getContentPane().add(lblBookId);
    }
}
