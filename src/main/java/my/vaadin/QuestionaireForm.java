package my.vaadin;

import com.vaadin.event.ShortcutAction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class QuestionaireForm extends QuestionaireFormDesign {

    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    final String DB_URL = "jdbc:mysql://localhost:3306/stonkav1";

    //  Database credentials
    final String USER = "stonka";
    final String PASS = "administrator";

    public QuestionaireForm() {
        save.setClickShortcut(ShortcutAction.KeyCode.ENTER);
        cancel.setClickShortcut(ShortcutAction.KeyCode.ESCAPE);
    }

    public void addAnkieta(){

        String tytul1 = tytul.getValue();
        String opis1 = opis.getValue();
        int id1 = (Integer) idAnalityka.getData();

        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            String sql = "INSERT INTO ankiety(tytul, opis, analitycy_idAnalityk) "
                    + "VALUES (" + "\'" + tytul1 + "\'" + "," + "\'" + opis1 + "\'" + "," + "\'" + id1 + "\'" + ")";
            //String sql = "INSERT INTO  klienci VALUES (2,'janek','dzbanek','94110201234', 'janek12@gmail.com', 'janek1')";
            //ResultSet rs = stmt.executeQuery(sql);

            stmt.executeUpdate(sql);
            //rs.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Done!");
    }
}
