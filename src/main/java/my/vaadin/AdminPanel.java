package my.vaadin;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;

import java.awt.*;

public class AdminPanel extends AdminPanelDesign implements View, SwitchView {

    public AdminPanel(Navigator navigator) {

    }

    @Override
    public void goToView(Navigator navigator, String view) {
        navigator.navigateTo(view);
    }

}
