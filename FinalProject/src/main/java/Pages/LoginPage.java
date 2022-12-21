package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    public static SelenideElement userName = $("#userName"),
            welcomeText = $x("//*[@id='userForm']/div/h2"),
            firstName =$("#firstname"),
            lastName = $("#lastname"),
            password = $("#password"),
            loginButton = $("#login"),
            registerButton = $("#register"),
            newUser = $("#newUser"),
            errorMessage = $("#name");
}

