import java.sql.*;
public class dbcheck2{

    public static void main(String args[]){

        String driver ="com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/lbms_alpha";
        String privilages = "root";
        String password = "";

        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, privilages, password);
            Statement stm = con.createStatement();
/*
            String adb = "CREATE TABLE " +"books"+ "("
                    + "BID INT NOT NULL AUTO_INCREMENT,"
                    + "Title VARCHAR(45) NOT NULL,"
                    + "Author VARCHAR(45) NOT NULL,"
                    + "PRIMARY KEY (BID))";
            stm.executeUpdate(adb);

            String admin = "INSERT INTO `books` VALUES ( null,'arabic','Shuvo1')";
            stm.executeUpdate(admin);


            String adb = "CREATE TABLE " +"Feedback"+ "("
                    + "FeedID INT NOT NULL AUTO_INCREMENT,"
                    + "feedback VARCHAR(120) NOT NULL,"
                    + "PRIMARY KEY (FeedID))";
            stm.executeUpdate(adb);

 */


            ResultSet rs = stm.executeQuery("SELECT * FROM `books` where Title = 'english' ");
            while(rs.next()){
                System.out.println( " Book Database created : ID " + rs.getInt("BID")+" Title " +
                        rs.getString("Title")+ " Author " +
                        rs.getString("Author") )  ;
            }

        }catch (Exception e){

        }
    }
}

