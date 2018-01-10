package my.vaadin;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;

public class Main extends MainDesign implements View, SwitchView, SubWindow{
    public Main(Navigator navigator) {
        loginchoice.addClickListener(clickEvent -> this.goToView(navigator, "login"));
        register.addClickListener(clickEvent -> this.subWindow());
    }

    @Override
    public void goToView(Navigator navigator, String view) {
        navigator.navigateTo(view);
    }

    @Override
    public void subWindow() {
        // Create a sub-window and set the content
        Window subWindow = new Window("Rejestracja");
        RegistrationForm register = new RegistrationForm();
        subWindow.setContent(register);
        register.cancel.addClickListener(clickEvent -> subWindow.close());

        // Center it in the browser window
        subWindow.center();

        // Open it in the UI
        //addWindow(subWindow);
        UI.getCurrent().addWindow(subWindow);
    }
}
