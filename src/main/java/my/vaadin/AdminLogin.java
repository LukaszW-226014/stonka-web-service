package my.vaadin;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;

import java.sql.*;

public class AdminLogin extends AdminLoginDesign implements View, SwitchView, LoggingAccount {
    public AdminLogin(Navigator navigator) {
        cancel.addClickListener(clickEvent -> this.goToView(navigator, "login"));
        login.addClickListener(clickEvent -> this.logging(email, haslo, navigator, "adminPanel", "administratorzy"));
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

