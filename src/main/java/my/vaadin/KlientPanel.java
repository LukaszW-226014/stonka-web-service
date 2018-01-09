package my.vaadin;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;

public class KlientPanel extends KlientPanelDesign implements View, SwitchView {

    public KlientPanel(Navigator navigator) {
        home.addClickListener(clickEvent -> this.goToView(navigator, ""));
    }

    @Override
    public void goToView(Navigator navigator, String view) {
        navigator.navigateTo(view);
    }
}
