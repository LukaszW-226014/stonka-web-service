package my.vaadin;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;

public class Main extends MainDesign implements View, SwitchView{
    public Main(Navigator navigator) {
        loginchoice.addClickListener(clickEvent -> this.goToView(navigator, "login"));
    }

    @Override
    public void goToView(Navigator navigator, String view) {
        navigator.navigateTo(view);
    }
}
