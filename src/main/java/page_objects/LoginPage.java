package page_objects;

import static com.codeborne.selenide.Selenide.$;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

@Log4j2
public class LoginPage extends BooksPage {

    private final SelenideElement userNameInputField = $(By.xpath("//*[@id='userName']"));
    private final SelenideElement passwordInputField = $(By.xpath("//*[@id='password']"));

    public BooksPage login(String name, String password) {
        log.info(String.format("Type text: '%s' into USERNAME input field", name));
        userNameInputField.sendKeys(name);
        log.info(String.format("Type text: '%s' into PASSWORD input field", password));
        passwordInputField.sendKeys(password);
        log.info("Press ENTER key on keyboard");
        passwordInputField.pressEnter();
        return new BooksPage();
    }
}
