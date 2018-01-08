package my.vaadin;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;

public class ClientLogin extends ClientLoginDesign implements View, SwitchView {

    public ClientLogin(Navigator navigator) {
        cancel.addClickListener(clickEvent -> this.goToView(navigator, "login"));
    }

    @Override
    public void goToView(Navigator navigator, String view) {

    }
}
