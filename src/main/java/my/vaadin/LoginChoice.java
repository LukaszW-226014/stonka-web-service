package my.vaadin;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;

public class LoginChoice extends LoginDesign implements View, SwitchView{
    public LoginChoice(Navigator navigator) {
        home.addClickListener(clickEvent -> this.goToView(navigator, ""));
        admin.addClickListener(clickEvent -> this.goToView(navigator, "adminLogin"));
        analityk.addClickListener(clickEvent -> this.goToView(navigator, "analystLogin"));
        kierownik.addClickListener(clickEvent -> this.goToView(navigator, "directorLogin"));
        klient.addClickListener(clickEvent -> this.goToView(navigator, "clientLogin"));
    }

    @Override
    public void goToView(Navigator navigator, String view) {
        navigator.navigateTo(view);
    }
}
