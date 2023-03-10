package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.RegistrationPage;

public class TestBase {
    public RegistrationPage registrationPage = new RegistrationPage();
    String name = "Pavel";
    String lastName = "Lepet";
    String fullName = name + " " + lastName;
    String email = "pavellepet@gmail.com";
    String gender = "Male";
    String phoneNumber = "8455345245";
    String birthMonth = "November";
    String birthYear = "1995";
    String birthDay = "06";
    String birthDate = birthDay + " " + birthMonth + "," + birthYear;
    String currentAddress = "2600 North Military Trail West Palm Beach FL 33409-0000 USA";
    String subject = "English";
    String hobby = "Sports";
    String pictureFIleName = "1.pmg";
    String state = "Haryana";
    String city = "Karnal";
    String stateAndCity = state + " " + city;

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
        Configuration.browserVersion = "100.0";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }
    @BeforeEach
    void addListenerAndOpenPage() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Selenide.closeWindow();
    }
}
