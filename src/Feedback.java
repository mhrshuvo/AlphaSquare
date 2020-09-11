import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class Feedback extends login {


    private JTextArea textArea;

    public static void main(String p) {
        if(p=="pass"){
            EventQueue.invokeLater(() -> {
                    try {
                        Feedback window = new Feedback();
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


    public Feedback() {
        FeedbackGUI();
    }


    private void FeedbackGUI() {
        welcome();
        Label("Feedback");


        JButton btnSubmit = new JButton("Submit");
        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                File log = new File("Feedback.txt");

                String Feedback = textArea.getText().trim();

                if(textArea.getText().isEmpty()){
                    JOptionPane.showMessageDialog(frame,"Invalid Input!","Error!",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try{
                    if(!log.exists()){
                        log.createNewFile();
                    }

                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(log,true));
                    bufferedWriter.write(Feedback);
                    bufferedWriter.newLine();
                    bufferedWriter.close();
                    JOptionPane.showMessageDialog(frame,"Thanks for your feedback!");

                } catch(IOException n) {
                }
            }
        });

        btnSubmit.setBounds(84, 215, 131, 23);
        frame.getContentPane().add(btnSubmit);

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                frame.dispose();
                user.main("pass");
            }
        });

        btnBack.setBounds(222, 215, 125, 23);
        frame.getContentPane().add(btnBack);


        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(48, 95, 330, 109);
        frame.getContentPane().add(scrollPane);

        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);
    }
}
