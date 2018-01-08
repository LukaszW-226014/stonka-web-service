package my.vaadin;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import my.vaadin.AnalystLoginDesign;
import my.vaadin.SwitchView;

public class AnalystLogin extends AnalystLoginDesign implements View, SwitchView {

    public AnalystLogin(Navigator navigator) {
        cancel.addClickListener(clickEvent -> this.goToView(navigator, "login"));
    }

    @Override
    public void goToView(Navigator navigator, String view) {

    }
}
