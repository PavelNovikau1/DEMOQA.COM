package tests;

import api_adapters.UserAdapter;
import api_objects.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTests extends BaseTest {

    @Test(description = "Confirm account login with valid credentials of the user, created by API request")
    public void loginWithValidCredentialsTest() {
        User user = User.builder()
                .userName("NewUser01")
                .password("very$trongPass1")
                .build();
        new UserAdapter().create(user);
        booksPage.openPage()
                .clickOnTheLoginButton()
                .login(user.getUserName(), user.getPassword());
        Assert.assertTrue(booksPage.isLogOutButtonDisplayed());
    }
}
