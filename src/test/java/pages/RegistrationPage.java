package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationsResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationsResultsModal registrationsResultsModal = new RegistrationsResultsModal();
    private String TITLE_TEXT = "Practice Form";
    private SelenideElement lastNameInput = $("#lastName ");
    private SelenideElement firstNameInput = $("#firstName ");
    private SelenideElement header = $(".main-header");
    private SelenideElement email = $("#userEmail ");
    private SelenideElement gender = $("#gender-radio-1");
    private SelenideElement userNumber = $("#userNumber ");
    private SelenideElement birthInput = $("#dateOfBirthInput");
    private SelenideElement address = $("#currentAddress");
    private SelenideElement stateCity = $("#stateCity-wrapper");
    private SelenideElement state = $("#state");
    private SelenideElement city = $("#city");
    private SelenideElement hobbies = $("#hobbiesWrapper");
    private SelenideElement picture = $("#uploadPicture");
    private SelenideElement submit = $("#submit");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        header.shouldHave(text(TITLE_TEXT));

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        email.setValue(value);

        return this;
    }

    public RegistrationPage setGender() {
        gender.parent().click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumber.setValue(value);

        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        birthInput.click();
        calendarComponent.setData(day, month, year);

        return this;
    }

    public RegistrationPage setAddress(String value) {
        address.setValue(value);

        return this;
    }

    public RegistrationPage verifyResults(String key, String value) {
        registrationsResultsModal.verifyResult(key, value);

        return this;
    }

    public RegistrationPage verifyResultsModalAppears() {
        registrationsResultsModal.verifyModalAppears();
        return this;
    }

    public RegistrationPage setState(String value_1, String value_2) {
        state.click();
        stateCity.$(byText(value_1)).click();
        city.click();
        stateCity.$(byText(value_2)).click();

        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbies.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setPicture(String value) {
        picture.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setSubmit(String value) {
        submit.shouldHave(text(value)).pressEnter();
        return this;
    }
}