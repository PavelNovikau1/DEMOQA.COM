package page_objects;

import static com.codeborne.selenide.Selenide.open;
import lombok.extern.log4j.Log4j2;

@Log4j2
public abstract class BasePage {

   private static final String BASE_URL = "https://demoqa.com/";

    public void openUrl(String url) {
        log.info(String.format("Open URL: '%s%s'", BASE_URL ,url));
        open(BASE_URL + url);
    }
}
