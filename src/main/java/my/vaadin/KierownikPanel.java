package my.vaadin;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;

public class KierownikPanel extends KierownikPanelDesign implements View, SwitchView {

    public KierownikPanel(Navigator navigator) {
        home.addClickListener(clickEvent -> this.goToView(navigator, ""));
    }

    @Override
    public void goToView(Navigator navigator, String view) {
        navigator.navigateTo(view);
    }
}
