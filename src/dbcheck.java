import java.sql.*;
public class dbcheck{

    public static String CreateDbAT(String tNamw) {

            String ret = "CREATE TABLE " +tNamw+ "("
            + "UID INT NOT NULL,"
            + "NAME VARCHAR(45) NOT NULL,"
            + "PASSWORD INT NOT NULL,"
            + "EMAIL VARCHAR(45) NOT NULL,"
            + "PRIMARY KEY (UID))";
            return ret;
    }

    static final String driver ="com.mysql.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost:3306/lbms_alpha";
    static final String privilages = "root";
    static final String password = "";

    public static void main(String args[]){
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, privilages, password);

            Statement stm = con.createStatement();
//uncomment for crete admin table

            String adb = CreateDbAT("AdminDb");
            stm.executeUpdate(adb);
            String udb = CreateDbAT("UserDb");
            stm.executeUpdate(udb);
            String vdb = CreateDbAT("VendorDb");
            stm.executeUpdate(vdb);
            String ldb = CreateDbAT("LibrarianDb");
            stm.executeUpdate(ldb);



//uncomment for set admin password
            String admin = "INSERT INTO `Admindb` VALUES ( 1,'admin','1234','psnbshuvo@gmail.com')";
            stm.executeUpdate(admin);
            String User = "INSERT INTO `UserDb` VALUES ( 1,'admin','1234','psnbshuvo@gmail.com')";
            stm.executeUpdate(User);
            String Vendor = "INSERT INTO `VendorDb` VALUES ( 1,'admin','1234','psnbshuvo@gmail.com')";
            stm.executeUpdate(Vendor);
            String Librarian = "INSERT INTO `LibrarianDb` VALUES ( 1,'admin','1234','psnbshuvo@gmail.com')";
            stm.executeUpdate(Librarian);

            ResultSet rs = stm.executeQuery("SELECT * FROM `admin`");
            while(rs.next()){
                System.out.println( " admin table created : ID " + rs.getInt("UID")+" Name " +
                        rs.getString("NAME")+ " Password " +
                        rs.getString("PASSWORD")+ " Email " +
                        rs.getString("EMAIL") )  ;
            }







        }catch (Exception e){

        }
// test


    }
}

