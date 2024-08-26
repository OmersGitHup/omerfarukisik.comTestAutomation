package Pages;

import Base.BaseLibrary;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;

public class RegisterPage extends BaseLibrary {


    @Step("Going Register Page")
    public RegisterPage clickRegister() {
        webDriver.findElement(By.xpath("/html/body/div/div/div/div/div/div/form/div[5]/a")).click();
        return this;
    }

    @Step("Filling name, surname and username")
    public RegisterPage fillName(String name, String surname, String username) {
        webDriver.findElement(By.xpath("//*[@id=\"Name\"]")).sendKeys(name);
        webDriver.findElement(By.xpath("//*[@id=\"Surname\"]")).sendKeys(surname);
        webDriver.findElement(By.xpath("//*[@id=\"UserName\"]")).sendKeys(username);
        return this;
    }

    @Step("Filling email and password")
    public RegisterPage fillEmailandPassword(String email, String password) {
        webDriver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys(password);
        webDriver.findElement(By.xpath("//*[@id=\"ConfirmPassword\"]")).sendKeys(password);
        webDriver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys(email);
        return this;
    }

    @Step("Click Register")
    public RegisterPage clickSubmitRegister() {
        webDriver.findElement(By.cssSelector("body > div > div > div > div > div > div > form > div.mt-3 > button")).click();
        return this;
    }

    @Step("RegisterTrueCheck")
    public RegisterPage registeredUserCheck() {
        String text = webDriver.findElement(By.xpath("/html/body/div/div/div/div/div/div/form/div[3]/button")).getText();
        String texttrue = "SIGN IN";
        screenshot();
        Assert.assertEquals(text, texttrue);
        return this;
    }
    @Step("RegisterFalseCheck")
    public RegisterPage nonRegisterUserCheck() {
        String text = webDriver.findElement(By.xpath("/html/body/div/div/div/div/div/div/form/div[7]/button")).getText();
        String texttrue = "SIGN UP";
        screenshot();
        Assert.assertEquals(text, texttrue);
        return this;
    }

    @Step("Already Taken UsernameCheck")
    public RegisterPage takenUsernameCheck() {
        String text = webDriver.findElement(By.xpath("/html/body/div/div/div/div/div/div/form/div[7]/ul/li")).getText();
        String texttrue = "Username 'omerfaruk3' is already taken.";
        screenshot();
        Assert.assertEquals(text, texttrue);
        return this;
    }

    @Step("Worng Password Type Check")
    public RegisterPage wrongPasswordType() {
        String text = webDriver.findElement(By.xpath("/html/body/div/div/div/div/div/div/form/div[7]/ul/li")).getText();
        String texttrue = "Passwords must have at least one uppercase ('A'-'Z').";
        screenshot();
        Assert.assertEquals(text, texttrue);
        return this;
    }
}
