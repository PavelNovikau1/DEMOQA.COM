package tests;

import static io.restassured.RestAssured.get;
import static io.restassured.path.json.JsonPath.with;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class BooksPageTests extends BaseTest {

    @Test(description = "Checking that the books list received by API response matches the list of books on the web page")
    public void CheckingListOfTheBooksByApiRequestTest() {
        String jsonResponse = get("https://demoqa.com/BookStore/v1/Books")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract()
                .asString();
        ArrayList<String> getBooksTitlesFromJsonResponse = with(jsonResponse).get("books.title");
        Assert.assertEquals(booksPage.openPage().getBookTitlesFromStore(), getBooksTitlesFromJsonResponse);
    }
}






