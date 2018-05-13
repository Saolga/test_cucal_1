package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import other.Stash;

public class FilmPage extends Base{
    @FindBy(xpath = ".//h1[@class='event-heading__title']")
    public WebElement filmHeader;

    @FindBy(xpath = ".//span[@class='event-heading__place']")
    public WebElement filmNumber;

    public FilmPage (){         //конструктор
        driver = Stash.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void checkNameNumbers (){
        waitVisibilityOf(filmHeader);
        Assert.assertEquals("Нужный заголовок отсутсвует",
                Stash.get(Stash.filmNameString), filmHeader.getText());
        Assert.assertEquals("Количество кинотеатров не совпадает",
                Stash.get(Stash.filmNumbersString), filmNumber.getText());
    }
}
