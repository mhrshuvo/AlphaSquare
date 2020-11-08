import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class EditBook extends login {

    JTextField textField;
    JTextArea textArea,textArea_1,textArea_2,textArea_3,textArea_4,textArea_5;
    Border border = BorderFactory.createLineBorder(Color.GRAY);

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EditBook window = new EditBook();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public EditBook() {
        EditBookGUI();
    }

    private void EditBookGUI() {
       welcome();
       Label("Edit Book");

        JButton button = new JButton("Search");
        button.addActionListener(e ->  {
                try {

                    String BookTitle = textField.getText();
                    boolean Search = false;

                    if(textField.getText().isEmpty())
                    {
                        JOptionPane.showMessageDialog(frame,"Invalid Input!","Error!",JOptionPane.ERROR_MESSAGE);
                        return;
                    }

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

                    if(Search == false){
                        JOptionPane.showMessageDialog(frame,"Book not found!","Error!",JOptionPane.ERROR_MESSAGE);
                    }

                } catch (Exception t) {

                }
            }
        );
        button.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        button.setBounds(20, 258, 87, 23);
        frame.getContentPane().add(button);

        JButton button_1 = new JButton("Back");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                frame.dispose();
                //LibrarianPage.main(null);
            }
        });
        button_1.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        button_1.setBounds(300, 258, 87, 23);
        frame.getContentPane().add(button_1);


        textField = new JTextField();
        textField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        textField.setBounds(10, 219, 204, 26);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        textArea = new JTextArea();
        textArea.setBounds(12, 117, 60, 27);
        frame.getContentPane().add(textArea);
        textArea.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        textArea.setEditable(false);
        textArea.setBorder(border);

        textArea_1 = new JTextArea();
        textArea_1.setBounds(84, 117, 177, 27);
        frame.getContentPane().add(textArea_1);
        textArea_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        textArea_1.setEditable(false);
        textArea_1.setBorder(border);

        textArea_2 = new JTextArea();
        textArea_2.setBounds(273, 117, 134, 27);
        frame.getContentPane().add(textArea_2);
        textArea_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        textArea_2.setEditable(false);
        textArea_2.setBorder(border);

        JLabel lblId = new JLabel("ID");
        lblId.setHorizontalAlignment(SwingConstants.CENTER);
        lblId.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        lblId.setBounds(20, 92, 40, 29);
        frame.getContentPane().add(lblId);

        JLabel lblBookTitle = new JLabel("Title");
        lblBookTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblBookTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        lblBookTitle.setBounds(82, 92, 179, 29);
        frame.getContentPane().add(lblBookTitle);

        JLabel lblAuthor = new JLabel("Author");
        lblAuthor.setHorizontalAlignment(SwingConstants.CENTER);
        lblAuthor.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        lblAuthor.setBounds(271, 92, 136, 29);
        frame.getContentPane().add(lblAuthor);

        JButton btnClear = new JButton("Clear");
        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                textField.setText(null);
                textArea.setText(null);
                textArea_1.setText(null);
                textArea_2.setText(null);
                textArea_3.setText(null);
                textArea_4.setText(null);
                textArea_5.setText(null);
            }
        });
        btnClear.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        btnClear.setBounds(214, 258, 76, 23);
        frame.getContentPane().add(btnClear);

        JLabel lblBookId = new JLabel("Book ID");
        lblBookId.setHorizontalAlignment(SwingConstants.CENTER);
        lblBookId.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        lblBookId.setBounds(213, 219, 87, 29);
        frame.getContentPane().add(lblBookId);

        JLabel lblNewId = new JLabel("New ID");
        lblNewId.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewId.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        lblNewId.setBounds(10, 151, 62, 29);
        frame.getContentPane().add(lblNewId);

        textArea_3 = new JTextArea();
        textArea_3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        textArea_3.setBounds(11, 176, 60, 27);
        textArea_3.setBorder(border);
        frame.getContentPane().add(textArea_3);

        JLabel lblNewTitle = new JLabel("New Title");
        lblNewTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        lblNewTitle.setBounds(82, 151, 179, 29);
        frame.getContentPane().add(lblNewTitle);

        textArea_4 = new JTextArea();
        textArea_4.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        textArea_4.setBounds(83, 176, 177, 27);
        textArea_4.setBorder(border);
        frame.getContentPane().add(textArea_4);

        JLabel lblNewAuthor = new JLabel("New Author");
        lblNewAuthor.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewAuthor.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        lblNewAuthor.setBounds(271, 151, 136, 29);
        frame.getContentPane().add(lblNewAuthor);

        textArea_5 = new JTextArea();
        textArea_5.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        textArea_5.setBounds(272, 176, 134, 27);
        textArea_5.setBorder(border);
        frame.getContentPane().add(textArea_5);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.addActionListener( e -> {
                String BookTitle = textField.getText();

                String NBookTitle = textArea_4.getText();
                String NAuthor = textArea_5.getText();

                try {
                    Class.forName(driver);
                    Connection con = DriverManager.getConnection(url, privilages, password);
                    Statement stm = con.createStatement();
                    stm.executeUpdate("Update books set title = "+NBookTitle+"set author ="+NAuthor+"where title ="+BookTitle );
                    System.out.println("update successful");


                }catch (Exception t){

                }

//                try (BufferedReader BReader = new BufferedReader(new FileReader("BookDatabase.txt"))){
//
//                    while ((line = BReader.readLine()) != null) {
//                        String array[] = line.split(",");
//
//                        if(array[0].equals(BookID))
//                        {
//                            String oldInfo = String.format(array[0] + "," + array[1] + "," + array[2]);
//                            String newData = oldData.replaceAll(oldInfo, info);
//                            FileWriter FWriter = new FileWriter("BookDatabase.txt");
//                            BufferedWriter BWriter = new BufferedWriter(FWriter);
//                            BWriter.write(newData);
//                            BWriter.close();
//                            JOptionPane.showMessageDialog(null, "Book is updated!","Update Book",JOptionPane.INFORMATION_MESSAGE);
//                        }
//                    }
//
//                } catch (Exception a){
//                    a.printStackTrace();
//                }
            }
            );
        btnUpdate.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        btnUpdate.setBounds(117, 258, 87, 23);
        frame.getContentPane().add(btnUpdate);
    }

}

