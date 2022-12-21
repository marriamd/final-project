import Pages.LoginPage;
import Steps.Steps;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class Tests {
    Steps steps = new Steps();

    public Tests() {
        Configuration.timeout = 10000;
        Configuration.browserSize = "1920x1080";

    }

    public void login() {
        open("https://demoqa.com/login");
        LoginPage.userName.sendKeys("testAutomation");
        LoginPage.password.sendKeys("Automation@1234");
        LoginPage.loginButton.click();
    }

    @DataProvider(name = "inputCredentials")
    public Object[][] inputCredentials() {
        return new Object[][]{
                {"Muko", "Vadachkoria", "Mvad", "12345"},
                {"Test", "Username", "TestUser", "12345"}
        };
    }

    @Test(dataProvider = "inputCredentials", priority = 0)
    public void FirstTest(String firstName, String lastName, String username, String password) {
        steps.firstTestSteps(firstName, lastName, username, password);

    }

    @Test(priority = 1)
    public void SecondTest() {
        login();
        steps.secondTestSteps();
    }

    @Test(dependsOnMethods = {"SecondTest"}, priority = 2)
    public void ThirdTest() {
        login();
        steps.thirdTestSteps();

    }

    @Test(priority = 3)
    public void FourthTest() {
        login();
        steps.fourthTestSteps();
    }

    @Test(priority = 4)
    public void FifthTest() {
        steps.fifthTestSteps();
    }
}
