import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.sql.*;

public class ReqBook extends login {

    public static void main(String p) {
        if (p == "pass") {
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

    }
}


