package my.vaadin;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.ui.*;

public class KlientPanel extends KlientPanelDesign implements View, SwitchView {

    public KlientPanel(Navigator navigator) {
        home.addClickListener(clickEvent -> this.goToView(navigator, ""));
        settings.addClickListener(clickEvent -> this.subWindow());
    }

    public void subWindow(){
        // Create a sub-window and set the content
        Window subWindow = new Window("Sub-window");
        VerticalLayout subContent = new VerticalLayout();
        subWindow.setContent(subContent);

        // Put some components in it
        subContent.addComponent(new Label("Meatball sub"));
        subContent.addComponent(new Button("Awlright"));

        // Center it in the browser window
        subWindow.center();

        // Open it in the UI
        //addWindow(subWindow);
        UI.getCurrent().addWindow(subWindow);
    }
    @Override
    public void goToView(Navigator navigator, String view) {
        navigator.navigateTo(view);
    }
}
