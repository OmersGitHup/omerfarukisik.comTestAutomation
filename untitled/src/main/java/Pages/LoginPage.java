package Pages;

import Base.BaseLibrary;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginPage extends BaseLibrary {

    @Step("Going Login Page")
    public LoginPage goingLogin(){
        webDriver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[7]/a")).click();
        return this;
    }

    @Step("Filling email and password")
    public LoginPage fillEmailandPassword(String email,String password){
        webDriver.findElement(By.xpath("/html/body/div/div/div/div/div/div/form/div[1]/input")).sendKeys(email);
        webDriver.findElement(By.xpath("//*[@id=\"exampleInputPassword1\"]")).sendKeys(password);
        return this;
    }

    @Step("Click Login")
    public LoginPage clickLogin(){
        webDriver.findElement(By.xpath("/html/body/div/div/div/div/div/div/form/div[3]/button")).click();
        return this;
    }

    @Step("Loged In")
    public LoginPage logedCheck(){
        String value= webDriver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div[1]/div/div/p[1]")).getText();
        String currentValue="Writer Panel";
        Assert.assertEquals(value,currentValue);
        return this;
    }

    @Step("LoginFalseCheck")
    public LoginPage unsuccessfullyLogin() {
        String text = webDriver.findElement(By.xpath("/html/body/div/div/div/div/div/div/form/div[3]/button")).getText();
        String texttrue = "SIGN IN";
        screenshot();
        Assert.assertEquals(text, texttrue);
        return this;
    }

}
