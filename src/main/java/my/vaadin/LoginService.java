package my.vaadin;

import com.vaadin.navigator.Navigator;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;

import java.sql.*;

public class LoginService {
    // JDBC driver name and database URL
    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    final String DB_URL = "jdbc:mysql://localhost:3306/stonkav1";

    //  Database credentials
    final String USER = "stonka";
    final String PASS = "administrator";

    public LoginService(TextField email, TextField haslo, Navigator navigator, String view, String table) {
        login(email, haslo, navigator, view, table);
    }

    public void login(TextField email, TextField haslo, Navigator navigator, String view, String table){
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

            String sql = "SELECT email, haslo FROM " + table;
            ResultSet rs = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                String email1 = rs.getString("email");
                String haslo1 = rs.getString("haslo");

                if (email1.equals(email.getValue()) && haslo1.equals(haslo.getValue())){
                    Notification.show("Login i haslo poprawne.", "Zapraszamy!", Notification.Type.HUMANIZED_MESSAGE);
                    navigator.navigateTo(view);
                }
                else{
                    Notification.show("Login/Haslo niepoprawne!", "Spróbuj jeszcze raz.", Notification.Type.WARNING_MESSAGE);
                }
            }
            rs.close();
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
