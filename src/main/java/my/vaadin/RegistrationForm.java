package my.vaadin;

import com.vaadin.event.ShortcutAction;
import com.vaadin.ui.Notification;

import java.sql.*;
import java.time.LocalDate;

public class RegistrationForm extends RegistrationFormDesign{
    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    final String DB_URL = "jdbc:mysql://localhost:3306/stonkav1";

    //  Database credentials
    final String USER = "stonka";
    final String PASS = "administrator";



    public RegistrationForm() {
        save.setClickShortcut(ShortcutAction.KeyCode.ENTER);
        cancel.setClickShortcut(ShortcutAction.KeyCode.ESCAPE);
        //save.addClickListener(clickEvent -> this.addClient());
        pesel.setMaxLength(11);
        nrDomu.setMaxLength(4);
        kod.setMaxLength(2);
        pocztowy.setMaxLength(3);
    }

    public void updateClient(){
        String imie1 = imie.getValue();
        String nazwisko1 = nazwisko.getValue();
        String pesel1 = pesel.getValue();
        String email1 = email.getValue();
        String haslo1 = haslo.getValue();
        LocalDate data1 = data.getValue();
        System.out.println(data1);
        String ulica1 = ulica.getValue();
        String numer1 = nrDomu.getValue();
        String miejscowosc1 = miejscowosc.getValue();
        String kod1 = kod.getValue();
        String pocztowy1 = pocztowy.getValue();

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

            String sql = "UPDATE klienci SET imie = " + "\'" + imie1 + "\'" + ","
                    + "nazwisko = " + "\'" + nazwisko1 + "\'" + ","
                    + "pesel = " + "\'" + pesel1 + "\'" + ","
                    + "email = " + "\'" + email1 + "\'" + ","
                    + "haslo = " + "\'" + haslo1 + "\'" + ","
                    + "dataUrodzenia = " + "\'" + data1.toString() + "\'" + ","
                    + "ulica = " + "\'" + ulica1 + "\'" + ","
                    + "nrDomu = " + "\'" + numer1 + "\'" + ","
                    + "miejscowosc = " + "\'" + miejscowosc1 + "\'" + ","
                    + "kod = " + "\'" + kod1 + "\'" + ","
                    + "pocztowy = " + "\'" + pocztowy1 + "\' WHERE idKlienci =" + LoginService.userIndex;

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

    public void downloadClient(){
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

            String sql;
            sql = "SELECT imie, nazwisko, pesel, email, haslo, dataUrodzenia, ulica, nrDomu, miejscowosc, kod, pocztowy FROM klienci WHERE idKlienci =" + LoginService.userIndex;
            //String sql = "INSERT INTO  klienci VALUES (2,'janek','dzbanek','94110201234', 'janek12@gmail.com', 'janek1')";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                imie.setValue(rs.getString("imie"));
                nazwisko.setValue(rs.getString("nazwisko"));
                pesel.setValue(rs.getString("pesel"));
                email.setValue(rs.getString("email"));
                haslo.setValue(rs.getString("haslo"));
                data.setValue(LocalDate.parse(rs.getString("dataUrodzenia")));
                ulica.setValue(rs.getString("ulica"));
                nrDomu.setValue(rs.getString("nrDomu"));
                miejscowosc.setValue(rs.getString("miejscowosc"));
                kod.setValue(rs.getString("kod"));
                pocztowy.setValue(rs.getString("pocztowy"));
            }
            //stmt.executeUpdate(sql);
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

    public void addClient(){

        String imie1 = imie.getValue();
        String nazwisko1 = nazwisko.getValue();
        String pesel1 = pesel.getValue();
        String email1 = email.getValue();
        String haslo1 = haslo.getValue();
        LocalDate data1 = data.getValue();
        String ulica1 = ulica.getValue();
        String numer1 = nrDomu.getValue();
        String miejscowosc1 = miejscowosc.getValue();
        String kod1 = kod.getValue();
        String pocztowy1 = pocztowy.getValue();

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

            String sql = "INSERT INTO klienci(imie, nazwisko, pesel, email, haslo, dataUrodzenia, ulica, nrDomu, miejscowosc, kod, pocztowy) "
                    + "VALUES (" + "\'" + imie1 + "\'" + "," + "\'" + nazwisko1 + "\'" + "," + "\'" + pesel1 + "\'" + "," + "\'" + email1 + "\'" + "," + "\'" + haslo1 + "\'" + "," + "\'" + data1.toString() + "\'"+ "," + "\'" + ulica1 + "\'"+ "," + "\'" + numer1 + "\'"+ "," + "\'" + miejscowosc1 + "\'"+ "," + "\'" + kod1 + "\'" + "," + "\'" + pocztowy1 + "\'"+ ")";
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
