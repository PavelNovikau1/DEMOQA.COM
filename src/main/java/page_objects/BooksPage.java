package page_objects;

import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import java.time.Duration;
import java.util.ArrayList;

@Log4j2
public class BooksPage extends BasePage {

    private final SelenideElement loginButton = $(By.xpath("//button[contains(text(),'Login')]"));
    private static final String BOOK_LIST_XPATH = "//*[@class='action-buttons']//a";
    private final SelenideElement logOutButton = $(By.xpath("//button[contains(text(),'Log out')]"));

    public BooksPage openPage() {
        openUrl("books");
        return this;
    }

    public LoginPage clickOnTheLoginButton() {
        log.info("Click on the LOGIN button");
        loginButton.click();
        return new LoginPage();
    }

    public boolean isLogOutButtonDisplayed() {
        return logOutButton.shouldBe(Condition.visible, Duration.ofSeconds(5)).isDisplayed();
    }

    public ArrayList<String> getBookTitlesFromStore() {
        ArrayList<String> bookTitles = new ArrayList<>();
        for (SelenideElement element : $$(By.xpath(BOOK_LIST_XPATH))) {
            bookTitles.add(element.getText());
        }
        return bookTitles;
    }
}
