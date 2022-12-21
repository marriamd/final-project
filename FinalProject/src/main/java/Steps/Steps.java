package Steps;

import Pages.LoginPage;
import Pages.ToolsQAPages;
import com.codeborne.selenide.Condition;
import io.restassured.response.Response;

import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.open;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Steps {


    public void firstTestSteps(String firstName, String lastName, String userName, String password) {

        open("https://demoqa.com/login");
        LoginPage.newUser.click();
        LoginPage.firstName.setValue(firstName);
        LoginPage.lastName.setValue(lastName);
        LoginPage.userName.setValue(userName);
        LoginPage.password.setValue(password);
        actions().moveToElement(LoginPage.registerButton);
        actions().scrollToElement(LoginPage.registerButton);
        LoginPage.registerButton.click();
        LoginPage.errorMessage.shouldHave(Condition.visible);
        assertEquals(LoginPage.errorMessage.getText(), "Please verify reCaptcha to register!");


    }

    public void secondTestSteps() {
       //login();
        assertEquals(ToolsQAPages.userNameValue.getText(), "testAutomation");
        ToolsQAPages.logOut.click();


    }

    public void thirdTestSteps() {
        //secondTestSteps();
       // login();
        ToolsQAPages.goToBookStoreButton.click();
        ToolsQAPages.firstBook.click();
        String url = "https://bookstore.toolsqa.com/BookStore/v1/Book?ISBN=" + ToolsQAPages.isbnValue;
        Response response =
                given().
                        when().
                        get(url).
                        then().
                        assertThat().
                        statusCode(200).
                        assertThat().
                        extract().
                        response();


        String apiTitle = response.jsonPath().getString("title");
        assertEquals(apiTitle, ToolsQAPages.firstBookTitle.getText());
        ToolsQAPages.logOut.click();

    }

    public void fourthTestSteps() {
       //login();
        ToolsQAPages.goToBookStoreButton.click();
        ToolsQAPages.searchField.sendKeys(ToolsQAPages.firstBookTitle.getText());
        ToolsQAPages.firstBookTitle.shouldHave(Condition.visible);
        ToolsQAPages.logOut.click();

    }

    public void fifthTestSteps() {
        //login();
        ToolsQAPages.logOut.click();
        LoginPage.welcomeText.shouldHave(Condition.visible);
        assertEquals(LoginPage.welcomeText.getText(), "Welcome,");


    }

}
