package my.vaadin;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import my.vaadin.AnalystLoginDesign;
import my.vaadin.SwitchView;

import java.sql.*;

public class AnalystLogin extends AnalystLoginDesign implements View, SwitchView, LoggingAccount {

    public AnalystLogin(Navigator navigator) {
        cancel.addClickListener(clickEvent -> this.goToView(navigator, "login"));
        login.addClickListener(clickEvent -> this.logging(email, haslo, navigator, "adminPanel", "analitycy"));
    }

    @Override
    public void goToView(Navigator navigator, String view) {
        navigator.navigateTo(view);
    }

    @Override
    public void logging(TextField email, TextField haslo, Navigator navigator, String view, String table) {
        new LoginService(email, haslo, navigator, view, table);
    }
}
