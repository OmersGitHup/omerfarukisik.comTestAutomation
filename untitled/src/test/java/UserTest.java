import Base.BaseTest;
import Pages.LoginPage;
import Pages.MainPage;
import Pages.RegisterPage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class UserTest extends BaseTest {

    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();
    MainPage mainPage = new MainPage();

    @Test(description = "Browser Site Check")
    @Severity(SeverityLevel.CRITICAL)
    public void browserSiteCheck() throws InterruptedException {
        mainPage.siteCheck();
    }

    @Test(description = "TakenUsername Register Check")
    @Severity(SeverityLevel.CRITICAL)
    public void registerCheck() throws InterruptedException {
        loginPage.goingLogin();
        registerPage.clickRegister()
                .fillEmailandPassword(email, password)
                .fillName(name, surname, username)
                .clickSubmitRegister();
        sleep(3000);
        registerPage.takenUsernameCheck()
        ;
    }

    @Test(description = "Loged Check")
    @Severity(SeverityLevel.CRITICAL)
    public void loginSuccessfully() throws InterruptedException {
        loginPage.goingLogin().fillEmailandPassword(username,password).clickLogin();
        sleep(3000);
        loginPage.logedCheck();
    }

    @Test(description = "Unsuccessful Login Check")
    @Severity(SeverityLevel.CRITICAL)
    public void loginUnsuccessfulCheck() throws InterruptedException {
        loginPage.goingLogin().fillEmailandPassword("1231","123123").clickLogin();
        sleep(3000);
        loginPage.unsuccessfullyLogin();
    }



}
