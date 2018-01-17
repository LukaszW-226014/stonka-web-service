package my.vaadin;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminPanel extends AdminPanelDesign implements View, SwitchView {

    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    final String DB_URL = "jdbc:mysql://localhost:3306/stonkav1";

    //  Database credentials
    final String USER = "stonka";
    final String PASS = "administrator";



    public AdminPanel(Navigator navigator) {
        downloadAnkietyTable();
        downloadSklepyTable();
        usersTabSheet();
        home.addClickListener(clickEvent -> this.goToView(navigator, ""));
    }

    public void usersTabSheet(){
        TabSheet users = new TabSheet();
        uzytPanel.addComponent(users);
        Panel tab1admins = new Panel();
        tab1admins.setHeight("350");
        downloadAdminTable(tab1admins);
        users.addTab(tab1admins, "Administratorzy");

        //#2
        Panel tab2anal = new Panel();
        tab2anal.setHeight("350");
        downloadAnalTable(tab2anal);
        users.addTab(tab2anal, "Analitycy");

        //#3
        Panel tab3kier = new Panel();
        users.addTab(tab3kier, "Kierownicy");

        //#4
        Panel tab4klien = new Panel();
        users.addTab(tab4klien, "Klienci");

    }


    public void downloadSklepyTable(){
        List<Sklepy> sklepyList = new ArrayList<>();

        Connection conn2 = null;
        Statement stmt3 = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn2 = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt3 = conn2.createStatement();

            String sql3;
            sql3 = "SELECT idSklepy, miejscowosc, ulica, nrBudynku, kodPocztowy FROM sklepy";
            //String sql = "INSERT INTO  klienci VALUES (2,'janek','dzbanek','94110201234', 'janek12@gmail.com', 'janek1')";
            ResultSet rs3 = stmt3.executeQuery(sql3);
            while (rs3.next()){
                int i = 0;
                int id1 = rs3.getInt("idSklepy");
                String miejscowosc1 = rs3.getString("miejscowosc");
                String ulica1 = rs3.getString("ulica");
                int nrBudynku1 = rs3.getInt("nrBudynku");
                String kodPocztowy1 = rs3.getString("kodPocztowy");
                sklepyList.add(new Sklepy(id1, miejscowosc1, ulica1, nrBudynku1, kodPocztowy1));
                System.out.println(sklepyList.get(i).toString());
                i++;
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
                if(stmt3!=null)
                    conn2.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn2!=null)
                    conn2.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Done!");

        //create grid
        Grid<Sklepy> sklepyGrid = new Grid<>();
        sklepyGrid.setItems(sklepyList);
        sklepyGrid.addColumn(Sklepy::getIdSklepu).setCaption("ID");
        sklepyGrid.addColumn(Sklepy::getMiejscowosc).setCaption("Miejscowosc");
        sklepyGrid.addColumn(Sklepy::getUlica).setCaption("Ulica");
        sklepyGrid.addColumn(Sklepy::getNrBudynku).setCaption("Nr Budynku");
        sklepyGrid.addColumn(Sklepy::getKodPocztowy).setCaption("Kod Pocztowy");
        sklepyGrid.setSizeFull();
        sklepyPanel.setContent(sklepyGrid);
    }

    public void downloadAnalTable(Panel panel){
        List<Analitycy> analList = new ArrayList<>();

        Connection conn2 = null;
        Statement stmt3 = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn2 = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt3 = conn2.createStatement();

            String sql3;
            sql3 = "SELECT idAnalitycy, imie, nazwisko, email, pesel FROM analitycy";
            //String sql = "INSERT INTO  klienci VALUES (2,'janek','dzbanek','94110201234', 'janek12@gmail.com', 'janek1')";
            ResultSet rs3 = stmt3.executeQuery(sql3);
            while (rs3.next()){
                int i = 0;
                int id1 = rs3.getInt("idAnalitycy");
                String imie1 = rs3.getString("imie");
                String nazwisko1 = rs3.getString("nazwisko");
                String email1 = rs3.getString("email");
                String pesel1 = rs3.getString("pesel");
                analList.add(new Analitycy(id1, imie1, nazwisko1, email1, pesel1));
                System.out.println(analList.get(i).toString());
                i++;
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
                if(stmt3!=null)
                    conn2.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn2!=null)
                    conn2.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Done!");

        //create grid
        Grid<Analitycy> analGrid = new Grid<>();
        analGrid.setItems(analList);
        analGrid.addColumn(Analitycy::getId).setCaption("ID");
        analGrid.addColumn(Analitycy::getImie).setCaption("Imie");
        analGrid.addColumn(Analitycy::getNazwisko).setCaption("Nazwisko");
        analGrid.addColumn(Analitycy::getEmail).setCaption("Email");
        analGrid.addColumn(Analitycy::getPesel).setCaption("Pesel");
        analGrid.setSizeFull();
        panel.setContent(analGrid);
    }


    public void downloadAdminTable(Panel panel){
        List<Administratorzy> adminList = new ArrayList<>();

        Connection conn2 = null;
        Statement stmt3 = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn2 = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt3 = conn2.createStatement();

            String sql3;
            sql3 = "SELECT idAdministratorzy, imie, nazwisko, email, pesel FROM administratorzy";
            //String sql = "INSERT INTO  klienci VALUES (2,'janek','dzbanek','94110201234', 'janek12@gmail.com', 'janek1')";
            ResultSet rs3 = stmt3.executeQuery(sql3);
            while (rs3.next()){
                int i = 0;
                int id1 = rs3.getInt("idAdministratorzy");
                String imie1 = rs3.getString("imie");
                String nazwisko1 = rs3.getString("nazwisko");
                String email1 = rs3.getString("email");
                String pesel1 = rs3.getString("pesel");
                adminList.add(new Administratorzy(id1, imie1, nazwisko1, email1, pesel1));
                System.out.println(adminList.get(i).toString());
                i++;
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
                if(stmt3!=null)
                    conn2.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn2!=null)
                    conn2.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Done!");

        //create grid
        Grid<Administratorzy> adminGrid = new Grid<>();
        adminGrid.setItems(adminList);
        adminGrid.addColumn(Administratorzy::getId).setCaption("ID");
        adminGrid.addColumn(Administratorzy::getImie).setCaption("Imie");
        adminGrid.addColumn(Administratorzy::getNazwisko).setCaption("Nazwisko");
        adminGrid.addColumn(Administratorzy::getEmail).setCaption("Email");
        adminGrid.addColumn(Administratorzy::getPesel).setCaption("Pesel");
        adminGrid.setSizeFull();
        panel.setContent(adminGrid);
    }

    public void downloadAnkietyTable(){
        List<Ankiety> ankietyList = new ArrayList<>();

        Connection conn2 = null;
        Statement stmt3 = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn2 = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt3 = conn2.createStatement();

            String sql3;
            sql3 = "SELECT idAnkieta, tytul, opis FROM ankiety";
            //String sql = "INSERT INTO  klienci VALUES (2,'janek','dzbanek','94110201234', 'janek12@gmail.com', 'janek1')";
            ResultSet rs3 = stmt3.executeQuery(sql3);
            while (rs3.next()){
                int i = 0;
                int id1 = rs3.getInt("idAnkieta");
                String tytul1 = rs3.getString("tytul");
                String opis1 = rs3.getString("opis");
                ankietyList.add(new Ankiety(id1, tytul1, opis1));
                System.out.println(ankietyList.get(i).toString());
                i++;
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
                if(stmt3!=null)
                    conn2.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn2!=null)
                    conn2.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Done!");

        //create grid
        Grid<Ankiety> ankietyGrid = new Grid<>();
        ankietyGrid.setItems(ankietyList);
        ankietyGrid.addColumn(Ankiety::getIdAnkiety).setCaption("ID");
        ankietyGrid.addColumn(Ankiety::getTytul).setCaption("Tytul");
        ankietyGrid.addColumn(Ankiety::getOpis).setCaption("Opis");
        //ankietyGrid.addSelectionListener(selectionEvent -> this.loadAnkieta(ankietyGrid.getSelectedItems()));
        ankietyGrid.setSizeFull();
        ankietyPanel.setContent(ankietyGrid);
    }

    @Override
    public void goToView(Navigator navigator, String view) {
        navigator.navigateTo(view);
    }

}
