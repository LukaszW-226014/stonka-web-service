package my.vaadin;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;

public class LoginChoice extends LoginDesign implements View, SwitchView{
    public LoginChoice(Navigator navigator) {
        home.addClickListener(clickEvent -> this.goToView(navigator, "main"));
        admin.addClickListener(clickEvent -> this.goToView(navigator, "adminLogin"));
    }

    @Override
    public void goToView(Navigator navigator, String view) {
        navigator.navigateTo(view);
    }
}
