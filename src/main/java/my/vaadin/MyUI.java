package my.vaadin;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.util.List;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI implements View {

    // Add the next two lines:

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Navigator navigator;

        getPage().setTitle("Stonka Service");

        // Create a navigator to control the views
        navigator = new Navigator(this, this);

        // Create and register the views
        navigator.addView("", new Main(navigator));
        navigator.addView("login", new LoginChoice(navigator));
        navigator.addView("adminLogin", new AdminLogin(navigator));
        navigator.addView("analystLogin", new AnalystLogin(navigator));
        navigator.addView("directorLogin", new DirectorLogin(navigator));
        navigator.addView("clientLogin", new ClientLogin(navigator));
        navigator.addView("adminPanel", new AdminPanel(navigator));
        navigator.addView("analitykPanel", new AnalitykPanel(navigator));
        navigator.addView("kierownikPanel", new KierownikPanel(navigator));
        navigator.addView("klientPanel", new KlientPanel(navigator));


        setContent(new Main(navigator));
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = true)
    public static class MyUIServlet extends VaadinServlet {
    }
}
