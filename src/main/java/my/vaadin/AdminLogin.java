package my.vaadin;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;

public class AdminLogin extends AdminLoginDesign implements View, SwitchView {
    public AdminLogin(Navigator navigator) {
        cancel.addClickListener(clickEvent -> this.goToView(navigator, "login"));
        login.addClickListener(clickEvent -> this.logging(navigator));
    }

    @Override
    public void goToView(Navigator navigator, String view) {
        navigator.navigateTo(view);
    }

    public void logging(Navigator navigator){
        DatabaseConnection database = new DatabaseConnection();
        goToView(navigator, "adminPanel");
    }
}
