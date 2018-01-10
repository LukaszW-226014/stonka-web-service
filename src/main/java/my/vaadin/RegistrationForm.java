package my.vaadin;

import com.vaadin.event.ShortcutAction;
import com.vaadin.ui.Notification;

import java.sql.*;

public class RegistrationForm extends RegistrationFormDesign {

    public RegistrationForm() {
        save.setClickShortcut(ShortcutAction.KeyCode.ENTER);
        cancel.setClickShortcut(ShortcutAction.KeyCode.ESCAPE);
        save.addClickListener(clickEvent -> this.addClient());
    }

    public void addClient(){
        // JDBC driver name and database URL
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://localhost:3306/stonkav1";

        //  Database credentials
        final String USER = "stonka";
        final String PASS = "administrator";
        String imie1 = imie.getValue();
        String nazwisko1 = nazwisko.getValue();
        String pesel1 = pesel.getValue();
        String email1 = email.getValue();
        String haslo1 = haslo.getValue();

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

//            String sql = "INSERT INTO klienci(imie, nazwisko, pesel, email, haslo) "
//                    + "VALUES (" + imie1 + "," + nazwisko1 + "," + pesel1 + "," + email1 + "," + haslo1 + ")";
            String sql = "INSERT INTO  klienci VALUES (2,'janek','dzbanek','94110201234', 'janek12@gmail.com', 'janek1')";
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
