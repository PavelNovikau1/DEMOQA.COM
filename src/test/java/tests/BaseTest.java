package tests;

import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page_objects.BooksPage;
import page_objects.LoginPage;

@Log4j2
public abstract class BaseTest {

    BooksPage booksPage;
    LoginPage loginPage;

    public void configureRestAssured() {
        RestAssured.baseURI = "https://demoqa.com/Account/v1";
        RestAssured.requestSpecification = given()
                .contentType(ContentType.JSON).accept(ContentType.JSON);
    }

    @BeforeMethod
    public void init() {
        configureRestAssured();
        Configuration.browser = "chrome";
        Configuration.timeout = 15000;
        Configuration.holdBrowserOpen = true;
        Configuration.headless = false;
        booksPage = new BooksPage();
        loginPage = new LoginPage();
    }

    @AfterMethod
    public void quit() {
        getWebDriver().quit();
    }
}