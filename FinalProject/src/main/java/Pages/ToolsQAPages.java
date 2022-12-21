package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ToolsQAPages {

    public static SelenideElement userNameValue = $("#userName-value"),
            goToBookStoreButton = $("#gotoStore"),
            searchField = $("#searchBox"),
    firstBook = $x("//*[@id='see-book-Git Pocket Guide']"),
    isbnValue = $x("//*[@id='ISBN-wrapper']/div[2]/label"),
    firstBookTitle = $x("//*[@class='rt-tr-group']/div/div[2]/div/span/a"),
    logOut = $("#submit");

}
