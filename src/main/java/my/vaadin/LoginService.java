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
    public static int userIndex;


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

            String sql = "SELECT id" + table + ",email, haslo FROM " + table;
            ResultSet rs = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set
            boolean access = false;
            while(!access && rs.next()){
                //Retrieve by column name
                userIndex = rs.getInt(1);
                String email1 = rs.getString("email");
                String haslo1 = rs.getString("haslo");


                if (email1.equals(email.getValue()) && haslo1.equals(haslo.getValue())){
                    email.setValue("");
                    haslo.setValue("");
                    Notification.show("Login i haslo poprawne.", "Zapraszamy!", Notification.Type.HUMANIZED_MESSAGE);
                    navigator.navigateTo(view);
                    access = true;
                    System.out.println(userIndex);

                }
                else{
                    Notification.show("Login/Haslo niepoprawne!", "Spróbuj jeszcze raz.", Notification.Type.WARNING_MESSAGE);
                    access = false;
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
