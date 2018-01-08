package my.vaadin;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;

public class DirectorLogin extends DirectorLoginDesign implements View, SwitchView {

    public DirectorLogin(Navigator navigator) {
        cancel.addClickListener(clickEvent -> this.goToView(navigator, "login"));
    }

    @Override
    public void goToView(Navigator navigator, String view) {

    }
}
