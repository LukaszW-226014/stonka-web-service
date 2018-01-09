package my.vaadin;

import com.vaadin.navigator.Navigator;
import com.vaadin.ui.TextField;

public interface LoggingAccount {
    void logging(TextField email, TextField haslo, Navigator navigator, String view, String table);
}
