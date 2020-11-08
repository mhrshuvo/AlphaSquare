import java.awt.*;
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.sql.*;

public class ShowAllBooks extends login{

    JTextArea textArea,textArea_1,textArea_2;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
                try {
                    ShowAllBooks window = new ShowAllBooks();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        );
    }

    public ShowAllBooks() {
        BookVendorGUI();
    }

    private void BookVendorGUI() {
       welcome();
       Label("All Book list");

        JButton button_1 = new JButton("Back");
        button_1.addActionListener(e -> {
                frame.dispose();
                librarian.main("pass");
            }
        );
        button_1.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        button_1.setBounds(337, 227, 87, 23);
        frame.getContentPane().add(button_1);

        Border border = BorderFactory.createLineBorder(Color.GRAY);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 118, 62, 99);
        frame.getContentPane().add(scrollPane);

        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);
        textArea.setEditable(false);
        textArea.setBorder(border);
        Border border2 = BorderFactory.createLineBorder(Color.GRAY);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(82, 118, 179, 99);
        frame.getContentPane().add(scrollPane_1);

        textArea_1 = new JTextArea();
        scrollPane_1.setViewportView(textArea_1);
        textArea_1.setEditable(false);
        textArea_1.setBorder(border2);
        Border border3 = BorderFactory.createLineBorder(Color.GRAY);

        JScrollPane scrollPane_2 = new JScrollPane();
        scrollPane_2.setBounds(271, 118, 136, 98);
        frame.getContentPane().add(scrollPane_2);

        textArea_2 = new JTextArea();
        scrollPane_2.setViewportView(textArea_2);
        textArea_2.setEditable(false);
        textArea_2.setBorder(border3);

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

        JButton btnDisplay = new JButton("Display");
        btnDisplay.addActionListener(arg0 ->{
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
        btnDisplay.setBounds(239, 227, 87, 23);
        frame.getContentPane().add(btnDisplay);
    }

}
