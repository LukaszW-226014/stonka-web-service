package my.vaadin;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.ui.Grid;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KierownikPanel extends KierownikPanelDesign implements View, SwitchView {

    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    final String DB_URL = "jdbc:mysql://localhost:3306/stonkav1";

    //  Database credentials
    final String USER = "stonka";
    final String PASS = "administrator";

    public KierownikPanel(Navigator navigator) {
        downloadSklepyTable();
        downloadDopuszczeniaTable();
        home.addClickListener(clickEvent -> this.goToView(navigator, ""));
    }

    public void downloadDopuszczeniaTable(){
        List<Dopuszczenia> dopList = new ArrayList<>();

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
            sql3 = "SELECT idDopuszczenia, dataDopuszczenia, dataWycofania, ankiety_idAnkieta, sklepy_idSklepy FROM dopuszczenia";
            //String sql = "INSERT INTO  klienci VALUES (2,'janek','dzbanek','94110201234', 'janek12@gmail.com', 'janek1')";
            ResultSet rs3 = stmt3.executeQuery(sql3);
            while (rs3.next()){
                int i = 0;
                int id1 = rs3.getInt("idDopuszczenia");
                String dataDop1 = rs3.getString("dataDopuszczenia");
                String dataWyc1 = rs3.getString("dataWycofania");
                int idAnal1 = rs3.getInt("ankiety_idAnkieta");
                int idSklep1 = rs3.getInt("sklepy_idSklepy");
                dopList.add(new Dopuszczenia(id1, dataDop1, dataWyc1, idAnal1, idSklep1));
                System.out.println(dopList.get(i).toString());
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
        Grid<Dopuszczenia> dopGrid = new Grid<>();
        dopGrid.setItems(dopList);
        dopGrid.addColumn(Dopuszczenia::getIdDopuszczenia).setCaption("ID");
        dopGrid.addColumn(Dopuszczenia::getDataDopuszczenia).setCaption("Data Dopuszczeia");
        dopGrid.addColumn(Dopuszczenia::getDataWycofania).setCaption("Data Wycofania");
        dopGrid.addColumn(Dopuszczenia::getIdAnkiety).setCaption("ID Ankiety");
        dopGrid.addColumn(Dopuszczenia::getIdSklepu).setCaption("ID Sklepu");
        dopGrid.setSizeFull();
        dopPanel.setContent(dopGrid);
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

    @Override
    public void goToView(Navigator navigator, String view) {
        navigator.navigateTo(view);
    }
}
