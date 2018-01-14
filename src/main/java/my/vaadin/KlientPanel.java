package my.vaadin;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.ui.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KlientPanel extends KlientPanelDesign implements View, SwitchView, SubWindow {
    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    final String DB_URL = "jdbc:mysql://localhost:3306/stonkav1";

    //  Database credentials
    final String USER = "stonka";
    final String PASS = "administrator";

    public KlientPanel(Navigator navigator) {
        downloadAnkietyTable();
        home.addClickListener(clickEvent -> this.goToView(navigator, ""));
        settings.addClickListener(clickEvent -> this.subWindow());
    }

    public void loadAnkieta(){

        List<Pytanie> pytanieList= new ArrayList<>();

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
            sql = "SELECT idPytania, tresc FROM pytania";
            //String sql = "INSERT INTO  klienci VALUES (2,'janek','dzbanek','94110201234', 'janek12@gmail.com', 'janek1')";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                int i = 0;
                int id1 = rs.getInt("idPytania");
                String tresc1 = rs.getString("tresc");
                pytanieList.add(new Pytanie(id1, tresc1));
                System.out.println(pytanieList.get(i).toString());
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

        List<Label> answersLabels = new ArrayList<>();
        List<RadioButtonGroup> radioButtonGroups = new ArrayList<>();


        VerticalLayout layout = new VerticalLayout();
        for (int i = 0; i < pytanieList.size(); i++){
            answersLabels.add(new Label(pytanieList.get(i).toString()));
        }
        for (int i = 0; i < pytanieList.size(); i++){
            RadioButtonGroup<String> radioButton = new RadioButtonGroup<>("Wybierz odpowiedz: ");
            radioButton.setItems("Bardzo dobrze", "Dobrze", "Srednio", "Niedobrze", "Strasznie");
            radioButtonGroups.add(radioButton);
        }
        for (int i = 0; i < answersLabels.size(); i++) {
            layout.addComponents(answersLabels.get(i), radioButtonGroups.get(i));
        }
        choiceAnkietyPanel.setContent(layout);
    }

    public void downloadAnkietyTable(){
        List<Ankiety> ankietyList = new ArrayList<>();

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
            sql = "SELECT idAnkieta, tytul, opis FROM ankiety";
            //String sql = "INSERT INTO  klienci VALUES (2,'janek','dzbanek','94110201234', 'janek12@gmail.com', 'janek1')";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                int i = 0;
                int id1 = rs.getInt("idAnkieta");
                String tytul1 = rs.getString("tytul");
                String opis1 = rs.getString("opis");
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

        //create grid
        Grid<Ankiety> ankietyGrid = new Grid<>();
        ankietyGrid.setItems(ankietyList);
        ankietyGrid.addColumn(Ankiety::getIdAnkiety).setCaption("ID");
        ankietyGrid.addColumn(Ankiety::getTytul).setCaption("Tytul");
        ankietyGrid.addColumn(Ankiety::getOpis).setCaption("Opis");
        ankietyGrid.addSelectionListener(selectionEvent -> this.loadAnkieta());
        ankietyPanel.setContent(ankietyGrid);
    }

    @Override
    public void goToView(Navigator navigator, String view) {
        navigator.navigateTo(view);
    }

    @Override
    public void subWindow() {
        // Create a sub-window and set the content
        Window subWindow = new Window("Edycja danych");
        RegistrationForm register = new RegistrationForm();
        register.downloadClient();
        subWindow.setContent(register);
        register.cancel.addClickListener(clickEvent -> subWindow.close());
        register.save.addClickListener(clickEvent -> register.updateClient());
        register.save.addClickListener(clickEvent -> subWindow.close());

        // Center it in the browser window
        subWindow.center();

        // Open it in the UI
        //addWindow(subWindow);
        UI.getCurrent().addWindow(subWindow);
    }
}
