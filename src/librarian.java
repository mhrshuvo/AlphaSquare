import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class librarian extends login {

    public static void main(String p) {
        if(p=="pass"){
            EventQueue.invokeLater(() ->{
                        try {
                            librarian window = new librarian();
                            window.frame.setVisible(true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
            );
        }else{
            login.main(null);
        }
    }

    public librarian() {
        LibrarianPageGUI();
    }

    private void LibrarianPageGUI() {
        welcome();
        Label(" Librarian Page");
        JButton button = new JButton("Add Book");
        button.addActionListener(e -> {
            System.out.println("Add book button pressed");
                frame.dispose();
              //  AddBook.main(null);
            }
        );

        button.setBounds(108, 99, 207, 23);
        frame.getContentPane().add(button);
        JButton button_1 = new JButton("Log Out");
        button_1.addActionListener(e ->  {
            System.out.println("Logout button pressed");
                frame.dispose();
                login.main(null);
            }
        );
        button_1.setBounds(108, 227, 207, 23);
        frame.getContentPane().add(button_1);

        JButton btnTracking = new JButton("View Book from Vendor");
        btnTracking.addActionListener(e ->  {
            System.out.println("View Book from Vendor button pressed");
                frame.dispose();
              //  BookVendor.main(null);
            }
        );
        btnTracking.setBounds(108, 159, 207, 23);
        frame.getContentPane().add(btnTracking);

        JButton btnViewFeedback = new JButton("View Feedback");
        btnViewFeedback.addActionListener(e -> {
            System.out.println("View Feedback button pressed");
                frame.dispose();
               // ViewFeedback.main(null);
            }
        );
        btnViewFeedback.setBounds(108, 193, 207, 23);
        frame.getContentPane().add(btnViewFeedback);

        JButton btnEditBook = new JButton("Edit Book");
        btnEditBook.addActionListener(e ->  {
            System.out.println("Edit Book button pressed");
                frame.dispose();
                //EditBook.main(null);
            }
        );
        btnEditBook.setBounds(108, 130, 207, 23);
        frame.getContentPane().add(btnEditBook);
    }
}

