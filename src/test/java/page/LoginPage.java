package page;

import com.codeborne.selenide.SelenideElement;
import data.DataHelper;
import org.openqa.selenium.support.FindBy;

import java.net.HttpCookie;

import static com.codeborne.selenide.Condition.visible;

public class LoginPage {
    @FindBy(css = "[data-test-id=login] input")
    private SelenideElement loginField;
    @FindBy(css = "[data-test-id=password] input")
    private SelenideElement passwordField;
    @FindBy(css = "[data-test-id=action-login] input")
    private SelenideElement loginButton;
    @FindBy(css = "[data-test-id='error-notification']")
    private SelenideElement errorNotification;

    public void verifyErrorNotificationVisiblity() {
        errorNotification.shouldBe(visible);
    }

    public VerificationPage validLogin(DataHelper.AuthInfo info) {
        HttpCookie LoginField = null;
        LoginField.setValue(info.getLogin());
        passwordField.setValue(info.getPassword());
        loginButton.click();
        return new VerificationPage();
    }
}
