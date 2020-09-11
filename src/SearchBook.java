import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;
import java.io.*;

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
        welcome();
        JButton button = new JButton("Search");

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    BufferedReader Reader = new BufferedReader(new FileReader("BookDatabase.txt"));
                    String BookID = textField.getText().trim();
                    String BookTitle = textField.getText().trim();
                    String BookAuthor = textField.getText().trim();
                    boolean Search = false;
                    String line;

                    if (textField.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Invalid Input!", "Error!", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    while ((line = Reader.readLine()) != null) {
                        String[] array = line.split(",");

                        if (array[0].equals(BookID) || array[1].equals(BookTitle) || array[2].equals(BookAuthor)) {
                            textArea.append(array[0] + "\n");
                            textArea_1.append(array[1] + "\n");
                            textArea_2.append(array[2] + "\n");
                            Search = true;
                        }
                    }

                    if (Search == false) {
                        JOptionPane.showMessageDialog(frame, "Book not found!", "Error!", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (IOException t) {
                    t.printStackTrace();
                }
            }
        });
        button.setBounds(20, 258, 80, 23);
        frame.getContentPane().add(button);

        JButton button_1 = new JButton("Back");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                frame.dispose();
                user.main("pass");
            }
        });
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
        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                textField.setText(null);
                textArea.setText(null);
                textArea_1.setText(null);
                textArea_2.setText(null);
            }
        });
        btnClear.setBounds(236, 258, 76, 23);
        frame.getContentPane().add(btnClear);

        JButton btnDisplayAll = new JButton("Display All");
        btnDisplayAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {

                    BufferedReader Reader = new BufferedReader(new FileReader("BookDatabase.txt"));

                    String line;

                    textArea.setText(null);

                    while((line = Reader.readLine())!= null){
                        String[] array = line.split(",");

                        textArea.append(array[0]+"\n");
                        textArea_1.append(array[1]+"\n");
                        textArea_2.append(array[2]+"\n");

                    }

                } catch (IOException t) {
                    t.printStackTrace();
                }
            }
        });

        btnDisplayAll.setBounds(107, 258, 119, 23);
        frame.getContentPane().add(btnDisplayAll);

        JLabel lblBookId = new JLabel("Book ID / Title / Author");
        lblBookId.setHorizontalAlignment(SwingConstants.CENTER);
        lblBookId.setBounds(213, 225, 211, 29);
        frame.getContentPane().add(lblBookId);
    }
}